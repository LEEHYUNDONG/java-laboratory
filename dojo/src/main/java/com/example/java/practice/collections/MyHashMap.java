package com.example.java.practice.collections;

/**
 * 해시 테이블 기반 HashMap 구현 연습
 *
 * 구현 요구사항:
 * 1. 내부적으로 배열(버킷)과 연결 리스트(체이닝) 사용
 * 2. hashCode()로 해시값 계산 후 버킷 인덱스 결정
 * 3. 해시 충돌은 체이닝(Separate Chaining) 방식으로 해결
 * 4. 로드 팩터(Load Factor)가 임계값을 초과하면 리해싱(rehashing)
 * 5. 평균 O(1) 시간복잡도로 put/get/remove 수행
 *
 * 핵심 메서드:
 * - put(K key, V value): 키-값 쌍 저장 (기존 키면 값 업데이트)
 * - get(K key): 키로 값 조회
 * - remove(K key): 키-값 쌍 제거
 * - containsKey(K key): 특정 키 존재 여부 확인
 * - size(): 저장된 엔트리 개수
 * - clear(): 모든 엔트리 제거
 */
public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        final int hash;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private int threshold;  // 리해싱이 발생하는 크기 (capacity * loadFactor)
    private final float loadFactor;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        // TODO: 기본 용량과 로드 팩터로 초기화
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        this.threshold = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity) {
        // TODO: 지정된 용량으로 초기화
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = (Entry<K, V>[]) new Entry[initialCapacity];
        this.threshold = (int) (initialCapacity * DEFAULT_LOAD_FACTOR);
    }

    public V put(K key, V value) {
        // TODO: 키-값 쌍 저장
        // 1. key의 해시값 계산
        // 2. 버킷 인덱스 계산 (hash % table.length)
        // 3. 해당 버킷에서 동일 키 검색
        //    - 있으면: 값 업데이트하고 이전 값 반환
        //    - 없으면: 새 Entry 생성하여 체인 앞에 추가
        // 4. size 증가 후 threshold 초과 시 resize() 호출
        return null;
    }

    public V get(K key) {
        // TODO: 키로 값 조회
        // 1. key의 해시값 계산
        // 2. 버킷 인덱스 계산
        // 3. 해당 버킷의 체인을 순회하며 키 비교
        // 4. 찾으면 값 반환, 없으면 null 반환
        return null;
    }

    public V remove(K key) {
        // TODO: 키-값 쌍 제거하고 값 반환
        // 힌트: 체인에서 노드를 제거할 때 이전 노드의 next 포인터 업데이트
        return null;
    }

    public boolean containsKey(K key) {
        // TODO: 특정 키가 존재하는지 확인
        return false;
    }

    public boolean containsValue(V value) {
        // TODO: 특정 값이 존재하는지 확인
        // 힌트: 모든 버킷의 모든 체인을 순회해야 함
        return false;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        // TODO: 모든 엔트리 제거
    }

    private int hash(K key) {
        // TODO: 해시값 계산
        // 힌트: key가 null이면 0, 아니면 key.hashCode()
        // 추가: 해시값의 상위 비트를 하위 비트와 XOR하여 분산성 개선
        return 0;
    }

    private int indexFor(int hash, int length) {
        // TODO: 버킷 인덱스 계산
        // 힌트: hash % length 또는 hash & (length - 1) (length가 2의 거듭제곱일 때)
        return 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        // TODO: 테이블 크기를 2배로 확장하고 모든 엔트리 재배치
        // 1. 새로운 더 큰 테이블 생성
        // 2. 기존 테이블의 모든 엔트리를 새 테이블로 이동
        // 3. threshold 업데이트
    }
}
