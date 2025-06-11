package com.example.java.lang.advanced.thread.start;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;

public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        log("main() start");
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                log(": run()");
            }
        });


        Thread thread2 = new Thread(() -> log(": run()"));
        thread.start();
        thread2.start();

        log("main() end");
    }

    
}
