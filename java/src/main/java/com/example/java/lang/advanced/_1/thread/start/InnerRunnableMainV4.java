package com.example.java.lang.advanced._1.thread.start;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        log("main() start");
        Thread thread = new Thread( () -> log(": run()") );


        Thread thread2 = new Thread(() -> log(": run()"));
        thread.start();
        thread2.start();

        log("main() end");
    }

    
}
