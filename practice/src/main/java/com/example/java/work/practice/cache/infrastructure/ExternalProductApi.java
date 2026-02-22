package com.example.java.work.practice.cache.infrastructure;

import com.example.java.work.practice.cache.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 외부 API를 시뮬레이션하는 클래스
 * 실제로는 외부 HTTP API를 호출하겠지만, 테스트를 위해 내부 데이터로 시뮬레이션
 */
@Component
public class ExternalProductApi {
    private final Map<Long, Product> productDatabase = new ConcurrentHashMap<>();
    private final AtomicInteger apiCallCount = new AtomicInteger(0);

    public ExternalProductApi() {
        // 테스트용 상품 데이터 초기화
        productDatabase.put(1L, new Product(1L, "노트북", new BigDecimal("1500000"), "전자제품"));
        productDatabase.put(2L, new Product(2L, "키보드", new BigDecimal("150000"), "전자제품"));
        productDatabase.put(3L, new Product(3L, "마우스", new BigDecimal("50000"), "전자제품"));
        productDatabase.put(4L, new Product(4L, "모니터", new BigDecimal("300000"), "전자제품"));
        productDatabase.put(5L, new Product(5L, "책상", new BigDecimal("200000"), "가구"));
    }

    /**
     * 외부 API 호출 시뮬레이션
     * 실제 API 호출은 느리므로 100ms 지연 추가
     */
    public Product getProduct(Long productId) {
        apiCallCount.incrementAndGet();

        // API 호출 지연 시뮬레이션
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return productDatabase.get(productId);
    }

    /**
     * API 호출 횟수 조회 (테스트용)
     */
    public int getApiCallCount() {
        return apiCallCount.get();
    }

    /**
     * API 호출 횟수 초기화 (테스트용)
     */
    public void resetApiCallCount() {
        apiCallCount.set(0);
    }
}
