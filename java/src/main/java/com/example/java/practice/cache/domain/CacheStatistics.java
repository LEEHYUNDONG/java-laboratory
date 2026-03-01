package com.example.java.practice.cache.domain;

/**
 * 캐시 통계 정보
 */
public class CacheStatistics {
    private final long hitCount;
    private final long missCount;
    private final double hitRate;

    public CacheStatistics(long hitCount, long missCount) {
        this.hitCount = hitCount;
        this.missCount = missCount;
        long totalCount = hitCount + missCount;
        this.hitRate = totalCount == 0 ? 0.0 : (double) hitCount / totalCount;
    }

    public long getHitCount() {
        return hitCount;
    }

    public long getMissCount() {
        return missCount;
    }

    public double getHitRate() {
        return hitRate;
    }

    @Override
    public String toString() {
        return String.format("CacheStatistics{hitCount=%d, missCount=%d, hitRate=%.2f%%}",
                hitCount, missCount, hitRate * 100);
    }
}
