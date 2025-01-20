package com.example.java.work.practice.junit.junit.aop;

import com.example.java.work.practice.junit.junit.annotation.AfterEachJ;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class AfterEachAop {

    @After("@annotation(com.example.java.work.practice.junit.junit.annotation.TestJ)")
    public void afterEach(final JoinPoint joinPoint) throws Throwable {
        System.out.println("AfterEachAop.afterEach");
        log.info("AfterEachAop.afterEach {}", joinPoint.getArgs());
        Object[] args = joinPoint.getArgs();
        Class<?> klass = args[0].getClass();
        Method[] declaredMethods = klass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(AfterEachJ.class)) {
                declaredMethod.invoke(args[0]);
            }
        }

    }

}
