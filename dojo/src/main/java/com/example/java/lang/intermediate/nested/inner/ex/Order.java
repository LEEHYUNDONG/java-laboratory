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
public class Order {
    private static int orderNum;
    private String itemName;
    private int quantity;

    public Order() {
        orderNum++;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int deliverOrder() {
        OrderDeliver orderDeliver = new OrderDeliver();

        return orderDeliver.sendOrder();
    }

    private class OrderDeliver {

        public int sendOrder() {
            System.out.println("=== Send Order" + orderNum + " ===");
            System.out.println("Order{" +
                    "orderNum=" + orderNum +
                    ", itemName='" + itemName + '\'' +
                    ", quantity=" + quantity +
                    '}');
            return orderNum++;
        }
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
