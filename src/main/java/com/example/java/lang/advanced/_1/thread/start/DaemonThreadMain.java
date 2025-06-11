package com.example.java.lang.advanced.thread.start;


public class DaemonThreadMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonTrhead daemonTrhead = new DaemonTrhead();
        daemonTrhead.setDaemon(true); // 데몬 스레드 여부
        daemonTrhead.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonTrhead extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": DaemonThread run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": DaemonThread run() end");
        }
    }
}
