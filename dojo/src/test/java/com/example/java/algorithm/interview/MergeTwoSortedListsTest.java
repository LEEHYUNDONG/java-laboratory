package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @Test
    @DisplayName("기본 테스트: [1,2,4] + [1,3,4] -> [1,1,2,3,4,4]")
    void test1() {
        MergeTwoSortedLists.ListNode list1 = createLinkedList(1, 2, 4);
        MergeTwoSortedLists.ListNode list2 = createLinkedList(1, 3, 4);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);

        assertThat(toList(result)).containsExactly(1, 1, 2, 3, 4, 4);
    }

    @Test
    @DisplayName("빈 리스트들: [] + [] -> []")
    void test2() {
        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(null, null);

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("한쪽만 빈 리스트: [] + [0] -> [0]")
    void test3() {
        MergeTwoSortedLists.ListNode list2 = createLinkedList(0);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(null, list2);

        assertThat(toList(result)).containsExactly(0);
    }

    @Test
    @DisplayName("다른 길이: [1,3,5] + [2,4,6,7,8] -> [1,2,3,4,5,6,7,8]")
    void testDifferentLength() {
        MergeTwoSortedLists.ListNode list1 = createLinkedList(1, 3, 5);
        MergeTwoSortedLists.ListNode list2 = createLinkedList(2, 4, 6, 7, 8);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);

        assertThat(toList(result)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    @DisplayName("모든 요소가 한쪽보다 큰 경우: [1,2,3] + [4,5,6] -> [1,2,3,4,5,6]")
    void testNoOverlap() {
        MergeTwoSortedLists.ListNode list1 = createLinkedList(1, 2, 3);
        MergeTwoSortedLists.ListNode list2 = createLinkedList(4, 5, 6);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);

        assertThat(toList(result)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("재귀 솔루션 테스트: [1,2,4] + [1,3,4] -> [1,1,2,3,4,4]")
    void testRecursive() {
        MergeTwoSortedLists.ListNode list1 = createLinkedList(1, 2, 4);
        MergeTwoSortedLists.ListNode list2 = createLinkedList(1, 3, 4);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoListsRecursive(list1, list2);

        assertThat(toList(result)).containsExactly(1, 1, 2, 3, 4, 4);
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
         MergeTwoSortedLists.ListNode list1 = createLinkedList(1, 2, 4);
         MergeTwoSortedLists.ListNode list2 = createLinkedList(1, 3, 4);
         MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);
         assertThat(toList(result)).containsExactly(1, 1, 2, 3, 4, 4);
    }

    // 헬퍼 메서드
    private MergeTwoSortedLists.ListNode createLinkedList(int... values) {
        if (values.length == 0) return null;

        MergeTwoSortedLists.ListNode head = new MergeTwoSortedLists.ListNode(values[0]);
        MergeTwoSortedLists.ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new MergeTwoSortedLists.ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private List<Integer> toList(MergeTwoSortedLists.ListNode head) {
        List<Integer> result = new ArrayList<>();
        MergeTwoSortedLists.ListNode current = head;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result;
    }
}
