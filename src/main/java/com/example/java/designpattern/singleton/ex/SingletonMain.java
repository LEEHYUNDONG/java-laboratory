package com.example.java.designpattern.singleton.ex;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
public class SingletonMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Father father1 = Father.getInstance();
        Father father2 = Father.getInstance();

        //실제 싱글턴을 구현되었는지 확인
        System.out.println(father1 == father2);

        /**
         * 싱글턴을 깨뜨릴 수 있는 방법
         *
         * 1. java reflection
         * 2. 직렬화 역직렬화를 이용하여 깨뜨릴 수 있음.
         */
        // 1
        Constructor<Father> constructor = Father.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Father father3 = constructor.newInstance();
        System.out.println(father1 == father3);

        // 2
        SerializableFather father4 = SerializableFather.getInstance();
        SerializableFather father5 = null;
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("father.obj"))) {
            out.writeObject(father4);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("father.obj"))) {
            father5 = (SerializableFather) in.readObject();
        }

        System.out.println(father4 == father5);
                
    }
}
