package com.example.java.practice.collections;

/**
 * 이중 연결 리스트(Doubly Linked List) 구현 연습
 *
 * 구현 요구사항:
 * 1. 각 노드는 데이터, 이전 노드 참조, 다음 노드 참조를 가짐
 * 2. head와 tail 포인터로 양방향 순회 가능
 * 3. 중간 삽입/삭제가 빠름 (O(1), 노드 위치를 알고 있을 때)
 * 4. 인덱스 기반 접근은 느림 (O(n))
 *
 * 핵심 메서드:
 * - addFirst(E element): 리스트 앞에 추가
 * - addLast(E element): 리스트 끝에 추가
 * - getFirst(): 첫 번째 요소 조회
 * - getLast(): 마지막 요소 조회
 * - removeFirst(): 첫 번째 요소 제거
 * - removeLast(): 마지막 요소 제거
 * - add(int index, E element): 특정 위치에 삽입
 * - get(int index): 인덱스로 조회
 * - remove(int index): 인덱스로 제거
 */
public class MyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        // TODO: 초기화
    }

    public void addFirst(E element) {
        // TODO: 리스트 맨 앞에 노드 추가
        // 힌트: 새 노드를 만들고 head를 업데이트
    }

    public void addLast(E element) {
        // TODO: 리스트 맨 뒤에 노드 추가
        // 힌트: 새 노드를 만들고 tail을 업데이트
    }

    public boolean add(E element) {
        // TODO: addLast와 동일
        return false;
    }

    public void add(int index, E element) {
        // TODO: 특정 인덱스에 노드 삽입
        // 힌트: 인덱스가 0이면 addFirst, size면 addLast
        // 그 외에는 노드를 찾아서 중간에 삽입
    }

    public E getFirst() {
        // TODO: 첫 번째 요소 반환
        // 힌트: 리스트가 비어있으면 예외 발생
        return null;
    }

    public E getLast() {
        // TODO: 마지막 요소 반환
        return null;
    }

    public E get(int index) {
        // TODO: 인덱스 위치의 요소 반환
        // 힌트: node(index)로 노드를 찾아서 반환
        return null;
    }

    public E set(int index, E element) {
        // TODO: 인덱스 위치의 요소 변경
        return null;
    }

    public E removeFirst() {
        // TODO: 첫 번째 노드 제거하고 데이터 반환
        // 힌트: head를 다음 노드로 이동
        return null;
    }

    public E removeLast() {
        // TODO: 마지막 노드 제거하고 데이터 반환
        // 힌트: tail을 이전 노드로 이동
        return null;
    }

    public E remove(int index) {
        // TODO: 인덱스 위치의 노드 제거
        return null;
    }

    public boolean remove(Object o) {
        // TODO: 특정 객체를 찾아서 제거
        return false;
    }

    public int size() {
        // TODO: 리스트 크기 반환
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {
        // TODO: 모든 노드 제거
        // 힌트: GC를 위해 노드 간 참조를 끊어줌
    }

    public boolean contains(Object o) {
        // TODO: 특정 객체가 포함되어 있는지 확인
        return false;
    }

    private Node<E> node(int index) {
        // TODO: 인덱스 위치의 노드 반환 (내부 헬퍼 메서드)
        // 힌트: index가 size/2보다 작으면 head부터, 크면 tail부터 탐색
        return null;
    }

    private void checkIndex(int index) {
        // TODO: 인덱스 유효성 검사
    }

    private void checkIndexForAdd(int index) {
        // TODO: add를 위한 인덱스 검사
    }

    private void checkNotEmpty() {
        // TODO: 리스트가 비어있지 않은지 확인
    }
}
