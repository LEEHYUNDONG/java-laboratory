package com.example.java.practice.junit.junit.entity;

public class JTestResult {
    private int passed; //테스트에 몇개 passed
    private int failed; //테스트에 몇개 failed

    public JTestResult(int testCnt, int failed) {
        this.passed = testCnt;
        this.failed = failed;
    }

    public TestStatus getTestStatus() {
        if (!isTestAllPassed()) {
            return TestStatus.FAILURE;
        }
        return TestStatus.SUCCESS;
    }

    private boolean isTestAllPassed() {
        return this.failed == 0;
    }

    public String printMessage() {
        return "passed: " + passed + " failed: " + failed;
    }

    /**
     * JTest 만들면서 테스트가 성공, 실패 cnt를 처리하는 메서드가 필요하다고 판단
     */
    public void testFailed() {
        this.passed--;
        this.failed++;
    }
}
