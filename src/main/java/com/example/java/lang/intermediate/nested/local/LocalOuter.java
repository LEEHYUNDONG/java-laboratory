package com.example.java.lang.intermediate.nested.local;

/**
 * @author : lhd
 * @packageName : com.example.java.java1.intermediate.nested.local
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-19         lhd
 */
public class LocalOuter {
    private int outInstanceVar = 2;

    public void process(int paramVar) {
        int localVar = 412;

        class LocalPrinterClass {
            int val = 32;

            public void printData() {
                System.out.println("val = " + val);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinterClass localPrinterClass = new LocalPrinterClass();
        localPrinterClass.printData();

    }
    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        localOuter.process(10);
    }
}
