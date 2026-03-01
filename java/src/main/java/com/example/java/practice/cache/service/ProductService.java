package com.example.java.practice.cache.service;

import com.example.java.practice.cache.domain.CacheStatistics;
import com.example.java.practice.cache.domain.Product;
import com.example.java.practice.cache.infrastructure.ProductCacheManager;
import org.springframework.stereotype.Service;

/**
 * 상품 서비스
 * 캐시를 활용하여 상품 정보를 조회
 */
@Service
public class ProductService {
    private final ProductCacheManager cacheManager;

    public ProductService(ProductCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * 상품 조회 (캐시 활용)
     */
    public Product getProduct(Long productId) {
        return cacheManager.get(productId);
    }

    /**
     * 상품 캐시 무효화
     */
    public void invalidateProduct(Long productId) {
        cacheManager.evict(productId);
    }

    /**
     * 전체 캐시 무효화
     */
    public void invalidateAll() {
        cacheManager.clear();
    }

    /**
     * 캐시 통계 조회
     */
    public CacheStatistics getCacheStatistics() {
        return cacheManager.getStatistics();
    }
}
