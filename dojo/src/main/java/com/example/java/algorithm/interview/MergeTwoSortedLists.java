package com.example.java.algorithm.interview;

/**
 * 문제: Merge Two Sorted Lists
 *
 * 두 개의 정렬된 연결 리스트의 헤드 list1과 list2가 주어집니다.
 * 두 리스트를 하나의 정렬된 리스트로 병합하세요.
 *
 * 예시:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;


        return dummyHead.next;
    }

    /**
     * 재귀를 사용한 솔루션
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    // 정답 (참고용)
    public ListNode mergeTwoListsSolution(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 남은 노드들 연결
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public ListNode mergeTwoListsRecursiveSolution(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursiveSolution(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursiveSolution(list1, list2.next);
            return list2;
        }
    }
}
