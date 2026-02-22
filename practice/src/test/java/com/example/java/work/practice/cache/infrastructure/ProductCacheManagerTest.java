package com.example.java.work.practice.cache.infrastructure;

import com.example.java.work.practice.cache.domain.CacheStatistics;
import com.example.java.work.practice.cache.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class ProductCacheManagerTest {
    private ExternalProductApi externalProductApi;
    private ProductCacheManager cacheManager;

    @BeforeEach
    void setUp() {
        externalProductApi = new ExternalProductApi();
        cacheManager = new ProductCacheManager(externalProductApi);
        externalProductApi.resetApiCallCount();
        cacheManager.clear();
    }

    @Test
    @DisplayName("첫 조회 시 Cache Miss가 발생하고 API를 호출한다")
    void cacheMissOnFirstAccess() {
        // given
        Long productId = 1L;

        // when
        Product product = cacheManager.get(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("노트북");
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);

        CacheStatistics stats = cacheManager.getStatistics();
        assertThat(stats.getMissCount()).isEqualTo(1);
        assertThat(stats.getHitCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("두 번째 조회 시 Cache Hit가 발생하고 API를 호출하지 않는다")
    void cacheHitOnSecondAccess() {
        // given
        Long productId = 1L;
        cacheManager.get(productId); // 첫 조회
        externalProductApi.resetApiCallCount();

        // when
        Product product = cacheManager.get(productId); // 두 번째 조회

        // then
        assertThat(product).isNotNull();
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(0);

        CacheStatistics stats = cacheManager.getStatistics();
        assertThat(stats.getHitCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("TTL 만료 후 다시 Cache Miss가 발생한다")
    void cacheMissAfterTTLExpiration() throws InterruptedException {
        // given
        Long productId = 1L;
        cacheManager.get(productId); // 첫 조회

        // when
        Thread.sleep(11_000); // TTL(60초) 이상 대기
        externalProductApi.resetApiCallCount();
        Product product = cacheManager.get(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("캐시 무효화 후 Cache Miss가 발생한다")
    void cacheMissAfterEviction() {
        // given
        Long productId = 1L;
        cacheManager.get(productId); // 첫 조회

        // when
        cacheManager.evict(productId);
        externalProductApi.resetApiCallCount();
        Product product = cacheManager.get(productId);

        // then
        assertThat(product).isNotNull();
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("전체 캐시 삭제 후 모든 상품이 Cache Miss가 발생한다")
    void cacheMissAfterClear() {
        // given
        cacheManager.get(1L);
        cacheManager.get(2L);
        cacheManager.get(3L);

        // when
        cacheManager.clear();
        externalProductApi.resetApiCallCount();
        cacheManager.get(1L);
        cacheManager.get(2L);
        cacheManager.get(3L);

        // then
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("동시에 같은 상품을 조회해도 API는 1번만 호출된다")
    void noDuplicateApiCallOnConcurrentAccess() throws InterruptedException {
        // given
        Long productId = 1L;
        int threadCount = 10;

        CountDownLatch latch = new CountDownLatch(threadCount);

        // when
        try(ExecutorService executorService = Executors.newFixedThreadPool(threadCount)) {
            for (int i = 0; i < threadCount; i++) {
                executorService.submit(() -> {
                    try {
                        cacheManager.get(productId);
                    } finally {
                        latch.countDown();
                    }
                });
            }
            latch.await(10, TimeUnit.SECONDS);

        }


        // then
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("캐시 통계가 정확하게 계산된다")
    void cacheStatisticsCalculatedCorrectly() {
        // given & when
        cacheManager.get(1L); // miss
        cacheManager.get(1L); // hit
        cacheManager.get(1L); // hit
        cacheManager.get(2L); // miss
        cacheManager.get(2L); // hit

        // then
        CacheStatistics stats = cacheManager.getStatistics();
        assertThat(stats.getHitCount()).isEqualTo(3);
        assertThat(stats.getMissCount()).isEqualTo(2);
        assertThat(stats.getHitRate()).isEqualTo(0.6); // 3/5 = 0.6
    }

    @Test
    @DisplayName("여러 상품을 동시에 조회해도 각각 캐시가 동작한다")
    void cacheWorksForMultipleProducts() throws InterruptedException {
        // given
        List<Long> productIds = List.of(1L, 2L, 3L, 4L, 5L);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // when - 1단계: 각 상품을 첫 조회 (캐시 저장)
        CountDownLatch firstLatch = new CountDownLatch(productIds.size());
        for (Long productId : productIds) {
            executorService.submit(() -> {
                try {
                    cacheManager.get(productId);
                } finally {
                    firstLatch.countDown();
                }
            });
        }
        firstLatch.await(10, TimeUnit.SECONDS);

        // when - 2단계: 각 상품을 두 번째 조회 (캐시 히트)
        externalProductApi.resetApiCallCount();
        CountDownLatch secondLatch = new CountDownLatch(productIds.size());
        for (Long productId : productIds) {
            executorService.submit(() -> {
                try {
                    cacheManager.get(productId);
                } finally {
                    secondLatch.countDown();
                }
            });
        }
        secondLatch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();

        // then
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(0); // 두 번째 조회는 API 호출 안 함

        CacheStatistics stats = cacheManager.getStatistics();
        assertThat(stats.getHitCount()).isEqualTo(5);
        assertThat(stats.getMissCount()).isEqualTo(5);
    }
}
