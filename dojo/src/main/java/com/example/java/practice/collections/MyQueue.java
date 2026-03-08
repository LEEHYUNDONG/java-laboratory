package com.example.java.practice.collections;

/**
 * 연결 리스트 기반 Queue 구현 연습
 * <p>
 * 구현 요구사항:
 * 1. FIFO(First In First Out) 구조
 * 2. 내부적으로 단일 연결 리스트 사용
 * 3. head에서 제거, tail에서 추가
 * 4. enqueue/dequeue 모두 O(1) 시간복잡도
 * <p>
 * 핵심 메서드:
 * - offer(E element): 큐의 끝에 요소 추가
 * - poll(): 큐의 앞에서 요소 제거하고 반환
 * - peek(): 큐의 앞 요소 조회 (제거하지 않음)
 * - isEmpty(): 큐가 비어있는지 확인
 * - size(): 큐에 저장된 요소 개수
 */
public class MyQueue<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;  // 큐의 앞 (제거 위치)
    private Node<E> tail;  // 큐의 뒤 (추가 위치)
    private int size;

    public MyQueue() {
        // TODO: 초기화
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offer(E element) {
        // TODO: 큐의 끝에 요소 추가
        // 힌트: 새 노드를 만들고 tail 뒤에 연결
        // 큐가 비어있었다면 head도 업데이트

        // null 검증 (Java 표준 Queue 구현체들과 동일하게)
        if (element == null) {
            throw new NullPointerException("null elements not allowed");
        }

        Node<E> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public E poll() {
        // TODO: 큐의 앞에서 요소 제거하고 반환
        // 힌트: head를 다음 노드로 이동
        // 큐가 비게 되면 tail도 null로 설정
        // 큐가 비어있으면 null 반환
        if (isEmpty()) {
            return null;
        }
        E data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public E peek() {
        // TODO: 큐의 앞 요소 조회 (제거하지 않음)
        // 큐가 비어있으면 null 반환
        if (isEmpty()) return null;

        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        // TODO: 모든 요소 제거
        // 선택적: 노드 간 연결 끊기
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            current.data = null;
            current.next = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }
}
