package com.example.java.java1.basic.extends1.access.child;

import com.example.java.java1.basic.extends1.access.parent.Parent;

/**
 * @author : lhd
 * @packageName : com.example.java.extends1.access
 * @fileName : java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-06         lhd
 */
public class Child extends Parent {

    public void call() {
        publicValue = 1;
        protectedValue = 1; // 상속 관계 or 같은 패키지
        // defaultValue = 20; // 다른 패키지 접근 불가, 컴파일 오류
        // privateValue = 30; // 접근 불가

        publicMethod();
        protectedMethod(); // 상속 관계 or 같은 패키지
        // defaultMethod(); // 다른 패키지 접근 불가, 컴파일 오류
        // privateMethod(); // 접근 불가, 컴파일 오류

        printParent();
    }
}
