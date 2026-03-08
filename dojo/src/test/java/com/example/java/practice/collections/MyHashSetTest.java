package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyHashSet 구현 테스트")
class MyHashSetTest {

    private MyHashSet<String> set;

    @BeforeEach
    void setUp() {
        set = new MyHashSet<>();
    }

    @Test
    @DisplayName("빈 셋 생성 테스트")
    void testEmptySet() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    @DisplayName("요소 추가 테스트")
    void testAdd() {
        assertTrue(set.add("Apple"));
        assertTrue(set.add("Banana"));
        assertTrue(set.add("Cherry"));

        assertEquals(3, set.size());
        assertTrue(set.contains("Apple"));
        assertTrue(set.contains("Banana"));
        assertTrue(set.contains("Cherry"));
    }

    @Test
    @DisplayName("중복 요소 추가 테스트")
    void testAddDuplicate() {
        assertTrue(set.add("Apple"));
        assertFalse(set.add("Apple")); // 중복 추가 실패

        assertEquals(1, set.size());
        assertTrue(set.contains("Apple"));
    }

    @Test
    @DisplayName("요소 제거 테스트")
    void testRemove() {
        set.add("A");
        set.add("B");
        set.add("C");

        assertTrue(set.remove("B"));
        assertEquals(2, set.size());
        assertFalse(set.contains("B"));

        assertFalse(set.remove("D")); // 존재하지 않는 요소 제거 실패
    }

    @Test
    @DisplayName("contains 테스트")
    void testContains() {
        set.add("Apple");
        set.add("Banana");

        assertTrue(set.contains("Apple"));
        assertTrue(set.contains("Banana"));
        assertFalse(set.contains("Cherry"));
    }

    @Test
    @DisplayName("null 요소 처리 테스트")
    void testNullElement() {
        assertTrue(set.add(null));
        assertTrue(set.contains(null));

        assertFalse(set.add(null)); // 중복 추가
        assertEquals(1, set.size());

        assertTrue(set.remove(null));
        assertFalse(set.contains(null));
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        set.add("A");
        set.add("B");
        set.add("C");

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        assertFalse(set.contains("A"));
    }

    @Test
    @DisplayName("많은 요소 추가 테스트")
    void testManyElements() {
        for (int i = 0; i < 100; i++) {
            assertTrue(set.add("Element" + i));
        }

        assertEquals(100, set.size());

        for (int i = 0; i < 100; i++) {
            assertTrue(set.contains("Element" + i));
        }
    }

    @Test
    @DisplayName("중복 제거 동작 확인")
    void testDuplicateRemoval() {
        set.add("A");
        set.add("B");
        set.add("A"); // 중복
        set.add("C");
        set.add("B"); // 중복

        assertEquals(3, set.size());
        assertTrue(set.contains("A"));
        assertTrue(set.contains("B"));
        assertTrue(set.contains("C"));
    }
}
