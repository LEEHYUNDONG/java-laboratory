package com.example.java.algorithm.interview;

/**
 * 문제: Reverse Linked List
 *
 * 단일 연결 리스트의 헤드가 주어지면, 리스트를 역순으로 뒤집으세요.
 *
 * 예시:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Input: head = []
 * Output: []
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 반복문을 사용한 솔루션
     */
    public ListNode reverseList(ListNode head) {
        // TODO: 구현하세요
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * 재귀를 사용한 솔루션
     */
    public ListNode reverseListRecursive(ListNode head) {
        // TODO: 구현하세요
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // 정답 (참고용)
    public ListNode reverseListSolution(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public ListNode reverseListRecursiveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursiveSolution(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
