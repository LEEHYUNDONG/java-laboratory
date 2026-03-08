package com.example.java.algorithm.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LFUNodeTest {

    private LFUCache cache;

    @BeforeEach
    void setUp() {
        cache = new LFUCache(2);
    }

    @Test
    void putAndGet() {
        cache.put(1, 100);
        assertEquals(100, cache.get(1));
    }

    @Test
    void getNonExistentKey() {
        assertEquals(-1, cache.get(999));
    }

    @Test
    void evictLeastFrequentlyUsed() {
        cache.put(1, 100);
        cache.put(2, 200);

        cache.get(1); // key 1의 frequency 증가

        cache.put(3, 300); // capacity 초과, key 2 제거 (가장 적게 사용됨)

        assertEquals(100, cache.get(1));
        assertEquals(-1, cache.get(2)); // 제거됨
        assertEquals(300, cache.get(3));
    }

    @Test
    void evictLRUWhenFrequencyTied() {
        cache.put(1, 100);
        cache.put(2, 200);

        // 둘 다 frequency = 1
        cache.put(3, 300); // key 1 제거 (가장 오래됨)

        assertEquals(-1, cache.get(1));
        assertEquals(200, cache.get(2));
        assertEquals(300, cache.get(3));
    }

    @Test
    void updateExistingKey() {
        cache.put(1, 100);
        cache.put(1, 101); // 업데이트

        assertEquals(101, cache.get(1));
    }

    @Test
    void frequencyIncreasesOnGet() {
        cache.put(1, 100);
        cache.put(2, 200);

        cache.get(2); // key 2의 frequency 증가
        cache.get(2); // 한 번 더 증가

        cache.put(3, 300); // key 1 제거 (frequency 낮음)

        assertEquals(-1, cache.get(1));
        assertEquals(200, cache.get(2));
        assertEquals(300, cache.get(3));
    }

    @Test
    void complexSequence() {
        LFUCache bigCache = new LFUCache(3);

        bigCache.put(1, 1);
        bigCache.put(2, 2);
        bigCache.put(3, 3);

        bigCache.get(1); // freq: 1->2
        bigCache.get(1); // freq: 2->3

        bigCache.get(2); // freq: 1->2

        bigCache.put(4, 4); // key 3 제거 (frequency 1, 가장 낮음)

        assertEquals(-1, bigCache.get(3));
        assertEquals(1, bigCache.get(1));
        assertEquals(2, bigCache.get(2));
        assertEquals(4, bigCache.get(4));
    }

    @Test
    void allSameFrequency() {
        cache.put(1, 100);
        cache.put(2, 200);

        // 둘 다 frequency 1
        cache.put(3, 300); // key 1 제거 (LRU)

        assertEquals(-1, cache.get(1));
        assertEquals(200, cache.get(2));
        assertEquals(300, cache.get(3));
    }

    @Test
    void putIncreasesFrequency() {
        cache.put(1, 100);
        cache.get(1); // freq: 2

        cache.put(2, 200);
        cache.put(1, 101); // 업데이트, freq: 2->3

        cache.put(3, 300); // key 2 제거 (freq: 1)

        assertEquals(101, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(300, cache.get(3));
    }

    @Test
    void capacityOne() {
        LFUCache singleCache = new LFUCache(1);

        singleCache.put(1, 100);
        assertEquals(100, singleCache.get(1));

        singleCache.put(2, 200);
        assertEquals(-1, singleCache.get(1));
        assertEquals(200, singleCache.get(2));
    }

    @Test
    void largeCapacity() {
        LFUCache largeCache = new LFUCache(100);

        for (int i = 0; i < 100; i++) {
            largeCache.put(i, i * 10);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(i * 10, largeCache.get(i));
        }

        // 101번째 삽입
        largeCache.put(100, 1000);

        // 가장 적게 사용된 key 0이 제거되어야 함
        assertEquals(-1, largeCache.get(0));
        assertEquals(1000, largeCache.get(100));
    }

    @Test
    void leetCodeExample() {
        // LeetCode 460 예제
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertEquals(1, lfuCache.get(1));

        lfuCache.put(3, 3); // key 2 제거
        assertEquals(-1, lfuCache.get(2));

        assertEquals(3, lfuCache.get(3));
        lfuCache.put(4, 4); // key 1 제거
        assertEquals(-1, lfuCache.get(1));

        assertEquals(3, lfuCache.get(3));
        assertEquals(4, lfuCache.get(4));
    }
}
