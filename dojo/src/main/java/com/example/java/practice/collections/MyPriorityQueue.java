package com.example.java.practice.collections;

import java.util.Comparator;

/**
 * Min Heap 기반 우선순위 큐 구현 연습
 *
 * 구현 요구사항:
 * 1. 내부적으로 배열 기반 이진 힙(Binary Heap) 사용
 * 2. Min Heap: 부모 노드가 자식 노드보다 작거나 같음
 * 3. 가장 작은 요소가 항상 루트(인덱스 0)에 위치
 * 4. offer: O(log n), poll: O(log n), peek: O(1)
 *
 * 핵심 메서드:
 * - offer(E element): 요소 추가 후 힙 속성 유지
 * - poll(): 최소값(루트) 제거하고 반환
 * - peek(): 최소값 조회 (제거하지 않음)
 *
 * 힙 인덱스 관계:
 * - 부모: (i - 1) / 2
 * - 왼쪽 자식: 2 * i + 1
 * - 오른쪽 자식: 2 * i + 2
 */
public class MyPriorityQueue<E> {

    private static final int DEFAULT_CAPACITY = 11;
    private Object[] heap;
    private int size;
    private final Comparator<? super E> comparator;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue() {
        // TODO: 기본 용량으로 초기화, natural ordering 사용
        this.heap = new Object[DEFAULT_CAPACITY];
        this.comparator = null;
    }

    @SuppressWarnings("unchecked")
    public MyPriorityQueue(Comparator<? super E> comparator) {
        // TODO: 커스텀 comparator로 초기화
        this.heap = new Object[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    public boolean offer(E element) {
        // TODO: 요소 추가
        // 1. 용량 확인 후 필요하면 grow()
        // 2. 요소를 배열 끝에 추가
        // 3. siftUp으로 힙 속성 복구
        return false;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        // TODO: 최소값 제거하고 반환
        // 1. 루트 요소 저장
        // 2. 마지막 요소를 루트로 이동
        // 3. siftDown으로 힙 속성 복구
        // 4. 비어있으면 null 반환
        return null;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        // TODO: 최소값 조회 (인덱스 0)
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {
        // TODO: 모든 요소 제거
    }

    @SuppressWarnings("unchecked")
    private void siftUp(int index) {
        // TODO: 인덱스 위치의 요소를 위로 이동하며 힙 속성 복구
        // 부모와 비교하여 작으면 교환, 반복
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int index) {
        // TODO: 인덱스 위치의 요소를 아래로 이동하며 힙 속성 복구
        // 두 자식 중 작은 것과 비교하여 크면 교환, 반복
    }

    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        // TODO: 두 요소 비교
        // comparator가 있으면 사용, 없으면 Comparable 사용
        return 0;
    }

    private void grow() {
        // TODO: 배열 용량 확장 (보통 2배)
    }

    private void swap(int i, int j) {
        // TODO: 두 인덱스의 요소 교환
    }
}
