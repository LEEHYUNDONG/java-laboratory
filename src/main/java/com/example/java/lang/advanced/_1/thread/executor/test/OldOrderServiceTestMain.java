package com.example.java.lang.advanced._1.thread.executor.test;

public class OldOrderServiceTestMain {
    public static void main(String[] args) throws Exception {
        String orderNo = "Order#1234"; // 예시 주문 번호
//        OldOrderService orderService = new OldOrderService();
//        orderService.order(orderNo);
        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order(orderNo);
    }
}
