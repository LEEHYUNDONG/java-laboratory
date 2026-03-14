package com.example.java.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유효한 괄호 테스트")
class ValidParenthesesTest {

    private ValidParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new ValidParentheses();
    }

    @Test
    @DisplayName("빈 문자열은 유효하다")
    void testEmptyString() {
        assertThat(solution.isValid("")).isTrue();
    }

    @Test
    @DisplayName("단순한 괄호는 유효하다")
    void testSimpleParentheses() {
        assertThat(solution.isValid("()")).isTrue();
        assertThat(solution.isValid("[]")).isTrue();
        assertThat(solution.isValid("{}")).isTrue();
    }

    @Test
    @DisplayName("여러 종류의 괄호가 올바르게 닫히면 유효하다")
    void testMultipleTypes() {
        assertThat(solution.isValid("()[]{}")).isTrue();
        assertThat(solution.isValid("{[]}")).isTrue();
        assertThat(solution.isValid("([{}])")).isTrue();
    }

    @Test
    @DisplayName("중첩된 괄호가 올바르게 닫히면 유효하다")
    void testNestedParentheses() {
        assertThat(solution.isValid("((()))")).isTrue();
        assertThat(solution.isValid("((()()))")).isTrue();
        assertThat(solution.isValid("{[()]}")).isTrue();
    }

    @Test
    @DisplayName("짝이 맞지 않으면 유효하지 않다")
    void testMismatchedParentheses() {
        assertThat(solution.isValid("(]")).isFalse();
        assertThat(solution.isValid("([)]")).isFalse();
        assertThat(solution.isValid("{[}]")).isFalse();
    }

    @Test
    @DisplayName("열린 괄호만 있으면 유효하지 않다")
    void testOnlyOpeningParentheses() {
        assertThat(solution.isValid("(((")).isFalse();
        assertThat(solution.isValid("[{(")).isFalse();
    }

    @Test
    @DisplayName("닫힌 괄호만 있으면 유효하지 않다")
    void testOnlyClosingParentheses() {
        assertThat(solution.isValid(")))")).isFalse();
        assertThat(solution.isValid("]})")).isFalse();
    }

    @Test
    @DisplayName("닫힌 괄호가 먼저 나오면 유효하지 않다")
    void testClosingBeforeOpening() {
        assertThat(solution.isValid(")(")).isFalse();
        assertThat(solution.isValid("}{")).isFalse();
    }

    @Test
    @DisplayName("유효하지 않은 괄호 제거 - 기본 케이스")
    void testRemoveInvalidParenthesesBasic() {
        assertThat(solution.removeInvalidParentheses("()())()")).isEqualTo("()()()");
        assertThat(solution.removeInvalidParentheses("(a)())()")).isEqualTo("(a)()()");
    }

    @Test
    @DisplayName("유효하지 않은 괄호 제거 - 닫힌 괄호가 먼저")
    void testRemoveInvalidParenthesesClosingFirst() {
        assertThat(solution.removeInvalidParentheses(")(")).isEqualTo("");
        assertThat(solution.removeInvalidParentheses(")()()")).isEqualTo("()()");
    }

    @Test
    @DisplayName("유효하지 않은 괄호 제거 - 열린 괄호만")
    void testRemoveInvalidParenthesesOnlyOpening() {
        assertThat(solution.removeInvalidParentheses("(((")).isEqualTo("");
    }

    @Test
    @DisplayName("가장 긴 유효한 괄호 - 기본 케이스")
    void testLongestValidParenthesesBasic() {
        assertThat(solution.longestValidParentheses("(()")).isEqualTo(2);
        assertThat(solution.longestValidParentheses(")()())")).isEqualTo(4);
    }

    @Test
    @DisplayName("가장 긴 유효한 괄호 - 전체가 유효한 경우")
    void testLongestValidParenthesesAllValid() {
        assertThat(solution.longestValidParentheses("()()")).isEqualTo(4);
        assertThat(solution.longestValidParentheses("(())")).isEqualTo(4);
    }

    @Test
    @DisplayName("가장 긴 유효한 괄호 - 빈 문자열")
    void testLongestValidParenthesesEmpty() {
        assertThat(solution.longestValidParentheses("")).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 긴 유효한 괄호 - 복잡한 케이스")
    void testLongestValidParenthesesComplex() {
        assertThat(solution.longestValidParentheses("()(())")).isEqualTo(6);
        assertThat(solution.longestValidParentheses("(()()")).isEqualTo(4);
    }
}
