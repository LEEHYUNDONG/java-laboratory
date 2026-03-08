package com.example.java.practice.collections;

/**
 * 동적 배열 기반 ArrayList 구현 연습
 *
 * 구현 요구사항:
 * 1. 내부적으로 배열을 사용하여 데이터 저장
 * 2. 용량이 부족하면 자동으로 배열 크기 확장 (보통 1.5배 또는 2배)
 * 3. 인덱스 기반 빠른 접근 (O(1))
 * 4. 중간 삽입/삭제 시 요소 이동 필요 (O(n))
 *
 * 핵심 메서드:
 * - add(E element): 끝에 요소 추가
 * - add(int index, E element): 특정 위치에 요소 삽입
 * - get(int index): 인덱스로 요소 조회
 * - set(int index, E element): 인덱스 위치의 요소 변경
 * - remove(int index): 인덱스 위치의 요소 제거
 * - size(): 현재 저장된 요소 개수
 * - clear(): 모든 요소 제거
 */
public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        // TODO: 기본 용량으로 배열 초기화
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        // TODO: 지정된 용량으로 배열 초기화
        this.elements = new Object[initialCapacity];
        this.size = initialCapacity;
    }

    public boolean add(E element) {
        // TODO: 배열 끝에 요소 추가
        // 힌트: 용량이 부족하면 grow() 호출

        if (size < elements.length) {
            grow();
        }
        elements[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        // TODO: 특정 인덱스에 요소 삽입
        // 힌트: index 유효성 검사, 요소들을 오른쪽으로 이동
        checkIndexForAdd(index);

        for (int i = index; i < size; i++) {
            elements[i+1] = elements[i];
        }

        if (size < elements.length) {
            grow();
        }
        elements[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        // TODO: 인덱스 위치의 요소 반환
        // 힌트: 인덱스 범위 체크
        checkIndex(index);

        return (E) elements[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        // TODO: 인덱스 위치의 요소를 새 값으로 변경하고 이전 값 반환
        checkIndex(index);
        E old = (E) elements[index];
        elements[index] = element;
        return old;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        // TODO: 인덱스 위치의 요소 제거하고 반환
        // 힌트: 요소들을 왼쪽으로 이동
        checkIndex(index);

        E old = (E) elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return old;
    }

    public boolean remove(Object o) {
        // TODO: 특정 객체를 찾아서 제거 (첫 번째 발견된 것만)
        for (int i = 0; i < size; i++) {
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                // GC를 위해 마지막 요소를 null로 설정
                elements[--size] = null;
                return true;  // 제거 성공
            }
        }
        return false;  // 요소를 찾지 못함
    }

    public int size() {
        // TODO: 현재 저장된 요소 개수 반환
        return size;
    }

    public boolean isEmpty() {
        // TODO: 리스트가 비어있는지 확인
        return size == 0 || elements.length == 0;
    }

    public void clear() {
        // TODO: 모든 요소 제거
        // 힌트: GC를 위해 참조를 null로 설정
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        // TODO: 특정 객체가 포함되어 있는지 확인
        for (int i = 0; i < size; i++) {
            // null 안전하게 비교
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        // TODO: 배열 용량 확장 (보통 현재 크기의 1.5배 또는 2배)
        // 힌트: 새 배열을 만들고 기존 요소들을 복사
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private void checkIndex(int index) {
        // TODO: 인덱스가 유효한 범위인지 검사 (0 <= index < size)
        // 힌트: 유효하지 않으면 IndexOutOfBoundsException 발생
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexForAdd(int index) {
        // TODO: add 작업을 위한 인덱스 검사 (0 <= index <= size)
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
