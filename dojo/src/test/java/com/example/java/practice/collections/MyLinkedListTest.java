package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyLinkedList 구현 테스트")
class MyLinkedListTest {

    private MyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    @DisplayName("빈 리스트 생성 테스트")
    void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("맨 앞에 요소 추가 테스트")
    void testAddFirst() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        assertEquals(3, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
    }

    @Test
    @DisplayName("맨 뒤에 요소 추가 테스트")
    void testAddLast() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals(3, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
    }

    @Test
    @DisplayName("특정 인덱스에 요소 삽입 테스트")
    void testAddAtIndex() {
        list.add("A");
        list.add("C");
        list.add(1, "B");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    @DisplayName("요소 조회 테스트")
    void testGet() {
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Cherry", list.get(2));
    }

    @Test
    @DisplayName("첫 번째 요소 제거 테스트")
    void testRemoveFirst() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.removeFirst());
        assertEquals(2, list.size());
        assertEquals("B", list.getFirst());
    }

    @Test
    @DisplayName("마지막 요소 제거 테스트")
    void testRemoveLast() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.removeLast());
        assertEquals(2, list.size());
        assertEquals("B", list.getLast());
    }

    @Test
    @DisplayName("인덱스로 요소 제거 테스트")
    void testRemoveByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    @DisplayName("객체로 요소 제거 테스트")
    void testRemoveByObject() {
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        assertTrue(list.remove("Banana"));
        assertEquals(2, list.size());
        assertFalse(list.contains("Banana"));
    }

    @Test
    @DisplayName("요소 변경 테스트")
    void testSet() {
        list.add("A");
        list.add("B");
        list.add("C");

        String old = list.set(1, "Z");

        assertEquals("B", old);
        assertEquals("Z", list.get(1));
    }

    @Test
    @DisplayName("빈 리스트에서 요소 조회 시 예외 발생")
    void testGetFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    @Test
    @DisplayName("빈 리스트에서 요소 제거 시 예외 발생")
    void testRemoveFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    @DisplayName("contains 테스트")
    void testContains() {
        list.add("Apple");
        list.add("Banana");

        assertTrue(list.contains("Apple"));
        assertFalse(list.contains("Cherry"));
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("양방향 리스트 무결성 테스트")
    void testBidirectionalIntegrity() {
        list.add("A");
        list.add("B");
        list.add("C");

        // 앞에서 뒤로
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        // 뒤에서 앞으로 (removeLast로 확인)
        assertEquals("C", list.removeLast());
        assertEquals("B", list.removeLast());
        assertEquals("A", list.removeLast());
        assertTrue(list.isEmpty());
    }
}
