package com.example.java.practice.collections;

/**
 * HashMap 기반 HashSet 구현 연습
 *
 * 구현 요구사항:
 * 1. 내부적으로 HashMap을 사용하여 구현
 * 2. Set은 중복을 허용하지 않음
 * 3. 순서를 보장하지 않음
 * 4. null 요소를 하나 저장할 수 있음
 * 5. 평균 O(1) 시간복잡도로 add/contains/remove 수행
 *
 * 핵심 메서드:
 * - add(E element): 요소 추가 (중복이면 false 반환)
 * - remove(E element): 요소 제거
 * - contains(E element): 요소 존재 여부 확인
 * - size(): 저장된 요소 개수
 * - clear(): 모든 요소 제거
 *
 * 힌트: HashMap의 key로 요소를 저장하고, value는 더미 객체 사용
 */
public class MyHashSet<E> {

    private static final Object PRESENT = new Object();

    private MyHashMap<E, Object> map;

    public MyHashSet() {
        // TODO: MyHashMap 초기화
        map = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity) {
        // TODO: 지정된 용량으로 MyHashMap 초기화
    }

    public boolean add(E element) {
        // TODO: 요소 추가
        // 힌트: map.put(element, PRESENT)의 반환값이 null이면 새로 추가된 것
        return false;
    }

    public boolean remove(E element) {
        // TODO: 요소 제거
        // 힌트: map.remove(element)의 반환값이 null이 아니면 제거 성공
        return false;
    }

    public boolean contains(E element) {
        // TODO: 요소 존재 여부 확인
        return false;
    }

    public int size() {
        // TODO: 저장된 요소 개수 반환
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {
        // TODO: 모든 요소 제거
    }
}
