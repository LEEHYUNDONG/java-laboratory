package com.example.java.algorithm.interview;

import java.util.Stack;

/**
 * 문제: Valid Parentheses
 *
 * '(', ')', '{', '}', '[', ']' 만 포함된 문자열 s가 주어집니다.
 * 입력 문자열이 유효한지 확인하세요.
 *
 * 유효한 조건:
 * 1. 여는 괄호는 같은 타입의 닫는 괄호로 닫혀야 합니다.
 * 2. 여는 괄호는 올바른 순서로 닫혀야 합니다.
 * 3. 모든 닫는 괄호는 같은 타입의 여는 괄호를 가져야 합니다.
 *
 * 예시:
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s = "(]"
 * Output: false
 *
 * Input: s = "([)]"
 * Output: false
 *
 * Input: s = "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // TODO: 구현하세요
        // 힌트: Stack 자료구조를 사용하면 효율적입니다
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // 정답 (참고용)
    public boolean isValidSolution(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
