package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {

    private final ReverseLinkedList solution = new ReverseLinkedList();

    @Test
    @DisplayName("기본 테스트: [1,2,3,4,5] -> [5,4,3,2,1]")
    void test1() {
        ReverseLinkedList.ListNode head = createLinkedList(1, 2, 3, 4, 5);

        ReverseLinkedList.ListNode result = solution.reverseListSolution(head);

        assertThat(toList(result)).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("테스트: [1,2] -> [2,1]")
    void test2() {
        ReverseLinkedList.ListNode head = createLinkedList(1, 2);

        ReverseLinkedList.ListNode result = solution.reverseListSolution(head);

        assertThat(toList(result)).containsExactly(2, 1);
    }

    @Test
    @DisplayName("빈 리스트 테스트: [] -> []")
    void testEmpty() {
        ReverseLinkedList.ListNode result = solution.reverseListSolution(null);

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("단일 노드 테스트: [1] -> [1]")
    void testSingleNode() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);

        ReverseLinkedList.ListNode result = solution.reverseListSolution(head);

        assertThat(toList(result)).containsExactly(1);
    }

    @Test
    @DisplayName("재귀 솔루션 테스트: [1,2,3,4,5] -> [5,4,3,2,1]")
    void testRecursive() {
        ReverseLinkedList.ListNode head = createLinkedList(1, 2, 3, 4, 5);

        ReverseLinkedList.ListNode result = solution.reverseListRecursiveSolution(head);

        assertThat(toList(result)).containsExactly(5, 4, 3, 2, 1);
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // ReverseLinkedList.ListNode head = createLinkedList(1, 2, 3, 4, 5);
        // ReverseLinkedList.ListNode result = solution.reverseList(head);
        // assertThat(toList(result)).containsExactly(5, 4, 3, 2, 1);
    }

    // 헬퍼 메서드
    private ReverseLinkedList.ListNode createLinkedList(int... values) {
        if (values.length == 0) return null;

        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(values[0]);
        ReverseLinkedList.ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ReverseLinkedList.ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private List<Integer> toList(ReverseLinkedList.ListNode head) {
        List<Integer> result = new ArrayList<>();
        ReverseLinkedList.ListNode current = head;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result;
    }
}
