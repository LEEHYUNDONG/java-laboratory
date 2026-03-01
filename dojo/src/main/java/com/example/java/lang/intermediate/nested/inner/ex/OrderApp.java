package com.example.java.lang.intermediate.nested.inner.ex;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.nested.inner.ex
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-19         lhd
 */
public class OrderApp {
    public static void main(String[] args) {
        Order order = new Order();

//        order.setItemName("kimchi");
//        order.setQuantity(1);

        // private 으로 감싸져있고 안해도 되는 행위이다.
        // Order.OrderDeliver orderDeliver = order.new OrderDeliver();
        order.deliverOrder();


    }
}
