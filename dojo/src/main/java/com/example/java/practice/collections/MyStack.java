package com.example.java.practice.collections;

import java.util.EmptyStackException;

/**
 * 배열 기반 Stack 구현 연습
 *
 * 구현 요구사항:
 * 1. LIFO(Last In First Out) 구조
 * 2. 내부적으로 배열 사용
 * 3. 용량이 부족하면 자동으로 확장
 * 4. push/pop/peek 모두 O(1) 시간복잡도
 *
 * 핵심 메서드:
 * - push(E element): 스택 맨 위에 요소 추가
 * - pop(): 스택 맨 위의 요소 제거하고 반환
 * - peek(): 스택 맨 위의 요소 조회 (제거하지 않음)
 * - isEmpty(): 스택이 비어있는지 확인
 * - size(): 스택에 저장된 요소 개수
 */
public class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyStack() {
        // TODO: 기본 용량으로 배열 초기화
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyStack(int initialCapacity) {
        // TODO: 지정된 용량으로 배열 초기화
        elements = new Object[initialCapacity];
        size = 0;
    }

    public void push(E element) {
        // TODO: 스택 맨 위에 요소 추가
        // 힌트: 용량이 부족하면 grow() 호출
        if (size < elements.length) {
            grow();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        // TODO: 스택 맨 위의 요소 제거하고 반환
        // 힌트: 스택이 비어있으면 예외 발생
        checkNotEmpty();

        return (E) elements[--size];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        // TODO: 스택 맨 위의 요소 조회 (제거하지 않음)
        checkNotEmpty();
        return (E) elements[size-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        // TODO: 모든 요소 제거
        elements = null;
        size = 0;
    }

    private void grow() {
        // TODO: 배열 용량 확장 (보통 현재 크기의 1.5배 또는 2배)
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }



    private void checkNotEmpty() {
        // TODO: 스택이 비어있지 않은지 확인
        // 힌트: 비어있으면 예외 발생
        if (size == 0) {
            throw new EmptyStackException();
        }
    }
}
