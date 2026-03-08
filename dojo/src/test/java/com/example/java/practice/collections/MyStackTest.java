package com.example.java.practice.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyStack 구현 테스트")
class MyStackTest {

    private MyStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
    }

    @Test
    @DisplayName("빈 스택 생성 테스트")
    void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("push 테스트")
    void testPush() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("pop 테스트 - LIFO 순서 확인")
    void testPop() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("peek 테스트 - 요소 제거하지 않음")
    void testPeek() {
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
        assertEquals(2, stack.size()); // 크기는 변하지 않음
        assertEquals("B", stack.peek()); // 여러 번 호출해도 같은 값
    }

    @Test
    @DisplayName("빈 스택에서 pop 시 예외 발생")
    void testPopFromEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("빈 스택에서 peek 시 예외 발생")
    void testPeekFromEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("push와 pop 혼합 테스트")
    void testMixedOperations() {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());

        stack.push("C");
        stack.push("D");

        assertEquals("D", stack.pop());
        assertEquals("C", stack.pop());
        assertEquals("A", stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("동적 배열 확장 테스트")
    void testGrowth() {
        // 초기 용량(10)을 초과하여 추가
        for (int i = 0; i < 20; i++) {
            stack.push("Item" + i);
        }

        assertEquals(20, stack.size());

        // LIFO 순서로 제거되는지 확인
        assertEquals("Item19", stack.pop());
        assertEquals("Item18", stack.pop());
    }

    @Test
    @DisplayName("clear 테스트")
    void testClear() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("null 요소 처리 테스트")
    void testNullElement() {
        stack.push(null);
        stack.push("A");
        stack.push(null);

        assertNull(stack.pop());
        assertEquals("A", stack.pop());
        assertNull(stack.pop());
    }

    @Test
    @DisplayName("스택 사용 예제 - 괄호 검사")
    void testParenthesesMatching() {
        String expression = "((()))";
        MyStack<Character> parenStack = new MyStack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                parenStack.push(ch);
            } else if (ch == ')') {
                if (parenStack.isEmpty()) {
                    fail("불균형한 괄호");
                }
                parenStack.pop();
            }
        }

        assertTrue(parenStack.isEmpty(), "모든 괄호가 매칭되어야 함");
    }
}
