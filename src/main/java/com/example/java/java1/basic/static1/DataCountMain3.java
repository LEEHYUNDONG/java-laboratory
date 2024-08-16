package com.example.java.java1.basic.static1;

/**
 * @author : lhd
 * @packageName : com.example.java.static1
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-02         lhd
 */
public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("data1");
        System.out.println("data1.count = " + Data3.count);

        Data3 data2 = new Data3("data2");
        System.out.println("data2.count = " + Data3.count);

        Data3 data3 = new Data3("data3");
        System.out.println("data3.count = " + Data3.count);

        // 인스턴스를 통한 접근
        // static 변수는 클래스 변수이기 때문에 클래스 이름을 통해 접근하는 것이 좋다.
        // 하지만 인스턴스를 통해서도 접근이 가능하다.
        Data3 data4 = new Data3("data4");
        // 가능하지만 권장하지 않는 방벙
//        System.out.println("data4.count = " + data4.count);

        System.out.println("Data3.count = " + Data3.count);
    }


}
