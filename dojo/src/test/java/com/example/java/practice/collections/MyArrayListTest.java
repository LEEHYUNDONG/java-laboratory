package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyArrayList 구현 테스트")
class MyArrayListTest {

    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    @DisplayName("빈 리스트 생성 테스트")
    void testEmptyList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("요소 추가 테스트")
    void testAdd() {
        assertTrue(list.add("A"));
        assertTrue(list.add("B"));
        assertTrue(list.add("C"));

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    @DisplayName("특정 인덱스에 요소 삽입 테스트")
    void testAddAtIndex() {
        list.add("A");
        list.add("C");
        list.add(1, "B");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));

        }

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
    @DisplayName("잘못된 인덱스 조회 시 예외 발생")
    void testGetInvalidIndex() {
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    @DisplayName("요소 변경 테스트")
    void testSet() {
        list.add("A");
        list.add("B");

        String oldValue = list.set(1, "Z");

        assertEquals("B", oldValue);
        assertEquals("Z", list.get(1));
    }

    @Test
    @DisplayName("인덱스로 요소 제거 테스트")
    void testRemoveByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
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

        assertFalse(list.remove("Grape"));
    }

    @Test
    @DisplayName("동적 배열 확장 테스트")
    void testGrowth() {
        // 초기 용량(10)을 초과하여 추가
        for (int i = 0; i < 20; i++) {
            list.add("Item" + i);
        }

        assertEquals(20, list.size());
        assertEquals("Item0", list.get(0));
        assertEquals("Item19", list.get(19));
    }

    @Test
    @DisplayName("contains 테스트")
    void testContains() {
        list.add("Apple");
        list.add("Banana");

        assertTrue(list.contains("Apple"));
        assertTrue(list.contains("Banana"));
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
    @DisplayName("null 요소 처리 테스트")
    void testNullElement() {
        list.add(null);
        list.add("A");
        list.add(null);

        assertEquals(3, list.size());
        assertNull(list.get(0));
        assertEquals("A", list.get(1));
        assertNull(list.get(2));

        assertTrue(list.contains(null));
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
    }
}
