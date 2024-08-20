package com.example.java.lang.basic.polymorphism.practice.ex2;

/**
 * @author : lhd
 * @packageName : com.example.java.basic.polymorphism.practice.ex2
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-16         lhd
 */
public class PayService{
    private Pay pay;

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public boolean processPay(String options, int amount) {
        boolean result = false;

        Pay pay = PayFactory.findPay(options);


        System.out.println("결제 수단 = " + options + " amount=" + amount);
        result = pay.pay(amount);

        if(result) {
            System.out.println("결제 성공");
            return true;
        }

        System.out.println("결제 실패");

        return false;
    }
}
