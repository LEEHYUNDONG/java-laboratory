package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyPriorityQueue 구현 테스트")
class MyPriorityQueueTest {

    private MyPriorityQueue<Integer> pq;

    @BeforeEach
    void setUp() {
        pq = new MyPriorityQueue<>();
    }

    @Test
    @DisplayName("빈 우선순위 큐 생성 테스트")
    void testEmptyQueue() {
        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
    }

    @Test
    @DisplayName("요소 추가 및 최소값 조회 테스트")
    void testOfferAndPeek() {
        pq.offer(5);
        pq.offer(3);
        pq.offer(7);
        pq.offer(1);

        assertEquals(4, pq.size());
        assertEquals(1, pq.peek()); // 최소값
    }

    @Test
    @DisplayName("poll 테스트 - 오름차순으로 제거")
    void testPoll() {
        pq.offer(5);
        pq.offer(2);
        pq.offer(8);
        pq.offer(1);
        pq.offer(9);

        assertEquals(1, pq.poll());
        assertEquals(2, pq.poll());
        assertEquals(5, pq.poll());
        assertEquals(8, pq.poll());
        assertEquals(9, pq.poll());

        assertTrue(pq.isEmpty());
    }

    @Test
    @DisplayName("빈 큐에서 poll 시 null 반환")
    void testPollFromEmptyQueue() {
        assertNull(pq.poll());
    }

    @Test
    @DisplayName("빈 큐에서 peek 시 null 반환")
    void testPeekFromEmptyQueue() {
        assertNull(pq.peek());
    }

    @Test
    @DisplayName("중복 요소 처리 테스트")
    void testDuplicateElements() {
        pq.offer(5);
        pq.offer(3);
        pq.offer(5);
        pq.offer(3);
        pq.offer(1);

        assertEquals(1, pq.poll());
        assertEquals(3, pq.poll());
        assertEquals(3, pq.poll());
        assertEquals(5, pq.poll());
        assertEquals(5, pq.poll());
    }

    @Test
    @DisplayName("커스텀 Comparator 테스트 - Max Heap")
    void testCustomComparator() {
        MyPriorityQueue<Integer> maxPq = new MyPriorityQueue<>(Comparator.reverseOrder());

        maxPq.offer(5);
        maxPq.offer(2);
        maxPq.offer(8);
        maxPq.offer(1);

        assertEquals(8, maxPq.poll()); // 최대값부터
        assertEquals(5, maxPq.poll());
        assertEquals(2, maxPq.poll());
        assertEquals(1, maxPq.poll());
    }

    @Test
    @DisplayName("문자열 우선순위 큐 테스트")
    void testStringPriorityQueue() {
        MyPriorityQueue<String> strPq = new MyPriorityQueue<>();

        strPq.offer("Banana");
        strPq.offer("Apple");
        strPq.offer("Cherry");
        strPq.offer("Apricot");

        assertEquals("Apple", strPq.poll());
        assertEquals("Apricot", strPq.poll());
        assertEquals("Banana", strPq.poll());
        assertEquals("Cherry", strPq.poll());
    }

    @Test
    @DisplayName("동적 배열 확장 테스트")
    void testGrowth() {
        for (int i = 20; i >= 1; i--) {
            pq.offer(i);
        }

        assertEquals(20, pq.size());

        // 오름차순으로 제거되는지 확인
        for (int i = 1; i <= 20; i++) {
            assertEquals(i, pq.poll());
        }
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);

        pq.clear();

        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
    }

    @Test
    @DisplayName("offer와 poll 혼합 테스트")
    void testMixedOperations() {
        pq.offer(5);
        pq.offer(3);
        assertEquals(3, pq.poll());

        pq.offer(7);
        pq.offer(1);
        assertEquals(1, pq.poll());
        assertEquals(5, pq.poll());

        pq.offer(4);
        assertEquals(4, pq.poll());
        assertEquals(7, pq.poll());

        assertTrue(pq.isEmpty());
    }

    @Test
    @DisplayName("힙 속성 검증 테스트")
    void testHeapProperty() {
        // 랜덤 순서로 추가
        int[] values = {10, 5, 15, 3, 7, 12, 20, 1, 6};
        for (int val : values) {
            pq.offer(val);
        }

        // 제거할 때마다 이전 값보다 크거나 같아야 함
        Integer prev = pq.poll();
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            assertTrue(prev <= current, "힙 속성 위반: " + prev + " > " + current);
            prev = current;
        }
    }

    @Test
    @DisplayName("커스텀 객체 우선순위 큐 테스트")
    void testCustomObjectPriorityQueue() {
        record Task(String name, int priority) implements Comparable<Task> {
            @Override
            public int compareTo(Task other) {
                return Integer.compare(this.priority, other.priority);
            }
        }

        MyPriorityQueue<Task> taskQueue = new MyPriorityQueue<>();

        taskQueue.offer(new Task("Low", 3));
        taskQueue.offer(new Task("High", 1));
        taskQueue.offer(new Task("Medium", 2));

        assertEquals("High", taskQueue.poll().name());
        assertEquals("Medium", taskQueue.poll().name());
        assertEquals("Low", taskQueue.poll().name());
    }
}
