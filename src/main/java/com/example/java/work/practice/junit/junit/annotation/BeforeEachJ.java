package com.example.java.work.practice.junit.junit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author : easttwave
 * @date : 2025.01.20
 * @description : OO 기능을 구현한 Class
 * @issues :
 * -----------------------------------------------------------
 * DATE              AUTHOR             MAJOR_ISSUE
 * -----------------------------------------------------------
 * 2025.01.20           easttwave              생성
 * -----------------------------------------------------------
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeforeEachJ {
}
