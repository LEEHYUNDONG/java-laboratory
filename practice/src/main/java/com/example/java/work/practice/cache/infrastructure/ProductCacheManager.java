package com.example.java.work.practice.cache.infrastructure;

import com.example.java.work.practice.cache.domain.CacheStatistics;
import com.example.java.work.practice.cache.domain.Product;
import com.example.java.work.practice.cache.domain.ProductCache;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 상품 캐시 관리자
 *
 * TODO: 아래 기능들을 구현하세요
 * 1. 캐시 저장소 (ConcurrentHashMap 사용)
 * 2. TTL 관리 (각 항목마다 만료 시간 저장)
 * 3. Cache Hit/Miss 통계
 * 4. 동시성 제어 (같은 상품에 대한 중복 API 호출 방지)
 */
@Component
public class ProductCacheManager {
    private final ExternalProductApi externalProductApi;
    private final long ttlMillis;

    // TODO: 필요한 필드 추가
    // - 캐시 저장소
    // - 만료 시간 저장소
    // - Hit/Miss 카운터
    // - 동시성 제어를 위한 Lock 맵
    private final ConcurrentMap<Long, ProductCache> cache = new ConcurrentHashMap<>();

    private final AtomicInteger hitCount = new AtomicInteger(0);
    private final AtomicInteger missCount = new AtomicInteger(0);

    private final ConcurrentMap<Long, ReentrantLock> lock;

    public ProductCacheManager(ExternalProductApi externalProductApi) {
        this.externalProductApi = externalProductApi;
        this.lock = new ConcurrentHashMap<>();

        this.ttlMillis = 10_000; // 10초 TTL
    }

    /**
     * 캐시에서 상품 조회
     * - 캐시에 있고 만료되지 않았으면 캐시에서 반환 (Cache Hit)
     * - 캐시에 없거나 만료되었으면 API 호출 후 캐시에 저장 (Cache Miss)
     * - 동시에 같은 상품을 조회할 때 중복 API 호출 방지
     */
    public Product get(Long productId) {
        ProductCache productCache = cache.get(productId);
        lock.computeIfAbsent(productId, k -> new ReentrantLock());

        if (!ObjectUtils.isEmpty(productCache) && !isExpired(productId)) {
            hitCount.incrementAndGet();
            return productCache.getProduct();
        }
        Product product = null;


        lock.get(productId).lock();
        try {
            product = loadFromApi(productId);
        } finally {
            lock.get(productId).unlock();
        }

        missCount.incrementAndGet();
        put(productId, ProductCache.of(product, System.currentTimeMillis()));
        return product;
    }

    /**
     * 캐시에 상품 저장
     */
    public void put(Long productId, ProductCache product) {
        cache.put(productId, product);
    }

    /**
     * 특정 상품의 캐시 삭제
     */
    public void evict(Long productId) {
        // TODO: 구현
        cache.remove(productId);
        lock.remove(productId);
    }

    /**
     * 전체 캐시 삭제
     */
    public void clear() {
        // TODO: 구현
        cache.forEach((key, value) -> cache.remove(key));
        lock.clear();
    }

    /**
     * 캐시 통계 조회
     */
    public CacheStatistics getStatistics() {
        // TODO: 구현
        return new CacheStatistics(hitCount.get(), missCount.get());
    }

    /**
     * 캐시 항목이 만료되었는지 확인
     */
    private boolean isExpired(Long productId) {

        return ttlMillis < System.currentTimeMillis() - cache.get(productId).getTtls();

    }

    /**
     * 외부 API에서 상품 조회 및 캐시 저장
     */
    private Product loadFromApi(Long productId) {
        // TODO: 구현

        return externalProductApi.getProduct(productId);
    }
}
