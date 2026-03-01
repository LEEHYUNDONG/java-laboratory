package com.example.java.practice.cache.service;

import com.example.java.practice.cache.domain.CacheStatistics;
import com.example.java.practice.cache.domain.Product;
import com.example.java.practice.cache.infrastructure.ExternalProductApi;
import com.example.java.practice.cache.infrastructure.ProductCacheManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest {
    private ExternalProductApi externalProductApi;
    private ProductCacheManager cacheManager;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        externalProductApi = new ExternalProductApi();
        cacheManager = new ProductCacheManager(externalProductApi);
        productService = new ProductService(cacheManager);
        externalProductApi.resetApiCallCount();
    }

    @Test
    @DisplayName("상품 조회 시 캐시가 동작한다")
    void getProductWithCache() {
        // when
        Product product1 = productService.getProduct(1L);
        Product product2 = productService.getProduct(1L);

        // then
        assertThat(product1).isNotNull();
        assertThat(product2).isNotNull();
        assertThat(product1).isSameAs(product2);
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("상품 캐시 무효화가 동작한다")
    void invalidateProduct() {
        // given
        productService.getProduct(1L);
        externalProductApi.resetApiCallCount();

        // when
        productService.invalidateProduct(1L);
        productService.getProduct(1L);

        // then
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("전체 캐시 무효화가 동작한다")
    void invalidateAll() {
        // given
        productService.getProduct(1L);
        productService.getProduct(2L);
        externalProductApi.resetApiCallCount();

        // when
        productService.invalidateAll();
        productService.getProduct(1L);
        productService.getProduct(2L);

        // then
        assertThat(externalProductApi.getApiCallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("캐시 통계를 조회할 수 있다")
    void getCacheStatistics() {
        // given
        productService.getProduct(1L);
        productService.getProduct(1L);
        productService.getProduct(2L);

        // when
        CacheStatistics statistics = productService.getCacheStatistics();

        // then
        assertThat(statistics.getHitCount()).isEqualTo(1);
        assertThat(statistics.getMissCount()).isEqualTo(2);
        assertThat(statistics.getHitRate()).isEqualTo(1.0 / 3.0);
    }
}
