package com.example.java.designpattern._01_singleton.ex;

/**
 * @author : lhd
 * @packageName : com.example.java.designpattern.singleton.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-12         lhd
 */
public class Father {
    // 1
    // private static Father instance;
    //2
    // private static volatile Father instance;

    private Father() {}

    //3
    private static class FatherHolder {
        private static final Father INSTANCE = new Father();
    }


    // 1
//    public static Father getInstance() {
//        if(instance == null) {
//            instance = new Father();
//        }
//        return instance;
//    }

    /**
     * 2. thread-safe한 방법
     *  SYCHRONIZED 키워드 사용하기 -> 성능의 문제가 생길 수 있음.
     *  method 앞에 synchronize 키워드를 붙이면 인스턴스 메모리 사이즈와 관계없이 static final로 인하여 비용 소모가 크다
     *  하지만 method 앞이 아닌 getInstance 내부에 만들게 되면 아래와 같이 해결할 수 있음. (double checked locking)
     */
//    public static Father getInstance() {
//        if(instance == null) {
//            synchronized (Father.class) {
//                if(instance == null) {
//                    instance = new Father();
//                }
//            }
//        }
//        return instance;
//    }

    //3
    public static Father getInstance() {
        return FatherHolder.INSTANCE;
    }

}
