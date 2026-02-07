package com.example.java.lang.advanced._1.thread.cas.spinlock;

import static com.example.java.lang.advanced._1.thread.util.MyLogger.log;
import static com.example.java.lang.advanced._1.thread.util.ThreadUtils.sleep;

public class SpinLockBad {
    private volatile boolean lock = false;

    public void lock() {
        log("락 획득 시도");
        while(true){
            if(!lock) {
                sleep(100);
                lock = true;
                break;
            }
            log("락 획득 실패 - 스핀 대기");
            // busy-waiting: CPU를 계속 사용하며 대기
        }
    }

    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }
}
