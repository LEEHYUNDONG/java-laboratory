package com.example.java.work.practice.junit.junit.entity;

import lombok.Getter;

public class JTestResult {
    @Getter
    private TestStatus status;
    private String message;
    private int passed; //테스트에 몇개 passed
    private int failed; //테스트에 몇개 failed

    public JTestResult(int passed, int failed) {
        this.passed = passed;
        this.failed = failed;
        this.message = "passed: " + passed + " failed: " + failed;
        setTestStatus(failed);
    }

    private void setTestStatus(int failed) {
        if (!isTestPassed(failed)){
            this.status = TestStatus.FAILURE;
            return;
        }
        this.status = TestStatus.SUCCESS;

    }

    private boolean isTestPassed(int failed) {
        return failed == 0 && passed >= 1;
    }

    public String printMessage() {
        return this.message;
    }
}
