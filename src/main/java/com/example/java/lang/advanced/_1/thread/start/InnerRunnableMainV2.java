package com.example.java.lang.advanced.thread.start;

import static com.example.java.lang.advanced.thread.util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log(": run()");
            }
        });
        thread.start();

        log("main() end");
    }

    
}
