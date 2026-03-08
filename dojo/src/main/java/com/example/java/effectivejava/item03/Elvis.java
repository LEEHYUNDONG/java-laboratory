package com.example.java.effectivejava.item03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
        if (created){
            throw new UnsupportedOperationException("already created!");
        }
        created = true;
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis1 = Elvis.INSTANCE;
        Elvis elvis2 = elvis1.getInstance();


        /**
         * 자바 reflection을 이용하여 singleton을 깬다.
         */
        Constructor<Elvis> declaredConstructors = Elvis.class.getDeclaredConstructor();
        declaredConstructors.setAccessible(true);
        Elvis elvis3 = declaredConstructors.newInstance();

        System.out.println(elvis1 == elvis2);
        System.out.println(elvis1 == elvis3);
    }
}
