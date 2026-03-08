package com.example.java.algorithm.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 2. LFU Cache 구현 (Least Frequently Used)
 *
 * 요구사항:
 * - get(key): O(1) - 키가 존재하면 값 반환하고 사용 빈도 증가
 * - put(key, value): O(1) - 키-값 저장, capacity 초과 시 가장 적게 사용된 항목 제거
 * - 사용 빈도가 같으면 가장 오래된 항목 제거 (LRU)
 */
public class LFUCache {

    // TODO: 필요한 자료구조 선언
    private final int capacity;

    private final Map<Integer, Integer> valueMap;

    private final Map<Integer, Integer> freqMap;

    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.valueMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }

        // frequency 증가
        updateFrequency(key);

        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        // 이미 존재하는 키면 값 업데이트 + frequency 증가
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            updateFrequency(key);
            return;
        }

        // capacity 초과 시 가장 적게 사용된 항목 제거
        if (valueMap.size() >= capacity) {
            removeMinFreqKey();
        }

        valueMap.put(key, value);
        freqMap.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void updateFrequency(int key) {
        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);

        // 이전 빈도 목록에서 제거
        freqToKeys.get(freq).remove(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);

        // LinkedHashSet의 첫 번째 원소 = 가장 오래된 키 (LRU)
        int keyToRemove = keys.iterator().next();
        keys.remove(keyToRemove);

        if (keys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }

        valueMap.remove(keyToRemove);
        freqMap.remove(keyToRemove);
    }
}
