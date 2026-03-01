package com.example.java.lang.advanced._1.thread.control;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run() {
//            throw new Exception();
        }
    }
}
