package com.example.java.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 유효한 괄호
 * <p>
 * 주어진 문자열에 포함된 괄호가 올바르게 짝지어져 있는지 판단하는 문제
 * <p>
 * 괄호의 종류: '(', ')', '{', '}', '[', ']'
 * <p>
 * 유효한 괄호 조건:
 * 1. 열린 괄호는 같은 타입의 닫힌 괄호로 닫혀야 한다
 * 2. 열린 괄호는 올바른 순서로 닫혀야 한다
 * 3. 모든 닫힌 괄호는 같은 타입의 열린 괄호를 가져야 한다
 * <p>
 * 예시:
 * - "()" -> true
 * - "()[]{}" -> true
 * - "(]" -> false
 * - "([)]" -> false
 * - "{[]}" -> true
 * - "((()))" -> true
 * - "(()" -> false
 */
public class ValidParentheses {

    /**
     * 주어진 문자열의 괄호가 유효한지 확인
     *
     * @param s 괄호를 포함한 문자열
     * @return 유효하면 true, 아니면 false
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * 유효하지 않은 괄호를 제거하여 유효한 괄호 문자열로 만들기
     * <p>
     * 예시:
     * - "()())()" -> "()()()"
     * - "(a)())()" -> "(a)()()"
     * - ")(" -> ""
     *
     * @param s 괄호를 포함한 문자열
     * @return 유효한 괄호 문자열
     */
    public String removeInvalidParentheses(String s) {
        // TODO: Stack을 사용하여 유효하지 않은 괄호를 제거하세요
        return "";
    }

    /**
     * 가장 긴 유효한 괄호 부분 문자열의 길이 반환
     * <p>
     * 예시:
     * - "(()" -> 2 (유효한 부분: "()")
     * - ")()())" -> 4 (유효한 부분: "()()")
     * - "" -> 0
     *
     * @param s 괄호 문자열
     * @return 가장 긴 유효한 괄호의 길이
     */
    public int longestValidParentheses(String s) {
        // TODO: Stack을 사용하여 가장 긴 유효한 괄호 길이를 구하세요
        // 힌트: 인덱스를 스택에 저장
        return 0;
    }
}
