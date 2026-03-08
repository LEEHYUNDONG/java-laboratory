package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyQueue 구현 테스트")
class MyQueueTest {

    private MyQueue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    @DisplayName("빈 큐 생성 테스트")
    void testEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("offer 테스트")
    void testOffer() {
        assertTrue(queue.offer("A"));
        assertTrue(queue.offer("B"));
        assertTrue(queue.offer("C"));

        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("poll 테스트 - FIFO 순서 확인")
    void testPoll() {
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        assertEquals("A", queue.poll());
        assertEquals("B", queue.poll());
        assertEquals("C", queue.poll());

        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("빈 큐에서 poll 시 null 반환")
    void testPollFromEmptyQueue() {
        assertNull(queue.poll());
    }

    @Test
    @DisplayName("peek 테스트 - 요소 제거하지 않음")
    void testPeek() {
        queue.offer("A");
        queue.offer("B");

        assertEquals("A", queue.peek());
        assertEquals(2, queue.size()); // 크기는 변하지 않음
        assertEquals("A", queue.peek()); // 여러 번 호출해도 같은 값
    }

    @Test
    @DisplayName("빈 큐에서 peek 시 null 반환")
    void testPeekFromEmptyQueue() {
        assertNull(queue.peek());
    }

    @Test
    @DisplayName("offer와 poll 혼합 테스트")
    void testMixedOperations() {
        queue.offer("A");
        queue.offer("B");
        assertEquals("A", queue.poll());

        queue.offer("C");
        queue.offer("D");

        assertEquals("B", queue.poll());
        assertEquals("C", queue.poll());
        assertEquals("D", queue.poll());

        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        queue.clear();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("많은 요소 처리 테스트")
    void testManyElements() {
        for (int i = 0; i < 100; i++) {
            queue.offer("Item" + i);
        }

        assertEquals(100, queue.size());

        for (int i = 0; i < 100; i++) {
            assertEquals("Item" + i, queue.poll());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("null 요소는 허용되지 않음")
    void testNullElementNotAllowed() {
        // Java 표준 Queue 구현체들과 동일하게 null 불허
        assertThrows(NullPointerException.class, () -> queue.offer(null));

        // null 추가 실패 후에도 큐는 정상 동작
        queue.offer("A");
        assertEquals("A", queue.poll());
    }

    @Test
    @DisplayName("단일 요소 추가/제거 반복 테스트")
    void testSingleElementOperations() {
        queue.offer("A");
        assertEquals("A", queue.poll());
        assertTrue(queue.isEmpty());

        queue.offer("B");
        assertEquals("B", queue.poll());
        assertTrue(queue.isEmpty());

        queue.offer("C");
        assertEquals("C", queue.peek());
        assertEquals("C", queue.poll());
        assertTrue(queue.isEmpty());
    }
}
