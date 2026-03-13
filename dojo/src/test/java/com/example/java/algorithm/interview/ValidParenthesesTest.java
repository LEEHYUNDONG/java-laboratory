package com.example.java.algorithm.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @Test
    @DisplayName("기본 테스트: () -> true")
    void test1() {
        assertThat(solution.isValidSolution("()")).isTrue();
    }

    @Test
    @DisplayName("테스트: ()[]{} -> true")
    void test2() {
        assertThat(solution.isValidSolution("()[]{}")).isTrue();
    }

    @Test
    @DisplayName("테스트: (] -> false")
    void test3() {
        assertThat(solution.isValidSolution("(]")).isFalse();
    }

    @Test
    @DisplayName("테스트: ([)] -> false")
    void test4() {
        assertThat(solution.isValidSolution("([)]")).isFalse();
    }

    @Test
    @DisplayName("테스트: {[]} -> true")
    void test5() {
        assertThat(solution.isValidSolution("{[]}")).isTrue();
    }

    @Test
    @DisplayName("빈 문자열 테스트: \"\" -> true")
    void testEmpty() {
        assertThat(solution.isValidSolution("")).isTrue();
    }

    @Test
    @DisplayName("홀수 길이 테스트: ( -> false")
    void testOddLength() {
        assertThat(solution.isValidSolution("(")).isFalse();
    }

    @Test
    @DisplayName("닫는 괄호만: ) -> false")
    void testClosingOnly() {
        assertThat(solution.isValidSolution(")")).isFalse();
    }

    @Test
    @DisplayName("복잡한 중첩: (([]){}) -> true")
    void testComplex() {
        assertThat(solution.isValidSolution("(([]){})")).isTrue();
    }

    @Test
    @DisplayName("잘못된 순서: {[(])} -> false")
    void testWrongOrder() {
        assertThat(solution.isValidSolution("{[(])}")).isFalse();
    }

    @Test
    @DisplayName("학생 구현 테스트 (구현 후 주석 해제)")
    void testStudentImplementation() {
        // TODO: 구현 후 아래 주석을 해제하고 테스트하세요
        // assertThat(solution.isValid("()[]{}")).isTrue();
        // assertThat(solution.isValid("(]")).isFalse();
        // assertThat(solution.isValid("{[]}")).isTrue();
    }
}
