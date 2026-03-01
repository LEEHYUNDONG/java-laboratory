package com.example.java.practice.cache.domain;

import lombok.Getter;

@Getter
public class ProductCache {

    private Product product;

    private long ttls;

    public static ProductCache of(Product product, long ttls) {
        ProductCache productCache = new ProductCache();
        productCache.product = product;
        productCache.ttls = ttls;
        return productCache;
    }
}
