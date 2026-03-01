package com.example.java.lang.advanced._1.thread.control;


import com.example.java.lang.advanced._1.thread.start.HelloRunnable;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        //main thread
        Thread mainThread = Thread.currentThread();
        log("mainThread :" + mainThread);
        log("mainThread.threadId :" + mainThread.getId());
        log("mainThread.threadName :" + mainThread.getName());
        log("mainThread.threadGroup :" + mainThread.getThreadGroup());
        log("mainThread.threadState :" + mainThread.getState());


        //my thread

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread :" + myThread);
        log("myThread.threadId :" + myThread.getId());
        log("myThread.threadName :" + myThread.getName());
        log("myThread.threadGroup :" + myThread.getThreadGroup());
        log("myThread.threadState :" + myThread.getState());

    }
}
