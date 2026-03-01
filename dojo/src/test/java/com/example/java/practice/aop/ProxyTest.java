package com.example.java.practice.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProxyTest {

    @Autowired
    private TestService testService;

    @Autowired
    private ConcreteService concreteService;

    @Test
    void JDK_동적_프록시_확인() {
        System.out.println("\n===== JDK 동적 프록시 테스트 =====");

        boolean isAopProxy = AopUtils.isAopProxy(testService);
        boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(testService);
        boolean isCglibProxy = AopUtils.isCglibProxy(testService);
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(testService);

        System.out.println("TestService는 AOP 프록시인가? " + isAopProxy);
        System.out.println("TestService는 JDK 동적 프록시인가? " + isJdkDynamicProxy);
        System.out.println("TestService는 CGLIB 프록시인가? " + isCglibProxy);
        System.out.println("TestService의 실제 타겟 클래스: " + targetClass.getName());
        System.out.println("TestService의 프록시 클래스: " + testService.getClass().getName());

        assertThat(isAopProxy).isTrue();

        testService.doSomething();
    }

    @Test
    void CGLIB_프록시_확인() {
        System.out.println("\n===== CGLIB 프록시 테스트 =====");

        boolean isAopProxy = AopUtils.isAopProxy(concreteService);
        boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(concreteService);
        boolean isCglibProxy = AopUtils.isCglibProxy(concreteService);
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(concreteService);

        System.out.println("ConcreteService는 AOP 프록시인가? " + isAopProxy);
        System.out.println("ConcreteService는 JDK 동적 프록시인가? " + isJdkDynamicProxy);
        System.out.println("ConcreteService는 CGLIB 프록시인가? " + isCglibProxy);
        System.out.println("ConcreteService의 실제 타겟 클래스: " + targetClass.getName());
        System.out.println("ConcreteService의 프록시 클래스: " + concreteService.getClass().getName());

        assertThat(isAopProxy).isTrue();
        assertThat(isCglibProxy).isTrue();

        concreteService.doSomething();
    }

    @Test
    void 프록시_생성_없이_일반_객체_확인() {
        System.out.println("\n===== 일반 객체 테스트 =====");

        TestService directTestService = new TestServiceImpl();
        ConcreteService directConcreteService = new ConcreteService();

        boolean isTestServiceProxy = AopUtils.isAopProxy(directTestService);
        boolean isConcreteServiceProxy = AopUtils.isAopProxy(directConcreteService);

        System.out.println("직접 생성한 TestServiceImpl은 프록시인가? " + isTestServiceProxy);
        System.out.println("직접 생성한 ConcreteService는 프록시인가? " + isConcreteServiceProxy);

        assertThat(isTestServiceProxy).isFalse();
        assertThat(isConcreteServiceProxy).isFalse();

        System.out.println("\n직접 생성한 객체 실행:");
        directTestService.doSomething();
        directConcreteService.doSomething();
    }

    @Test
    void ProxyFactory로_JDK_동적_프록시_생성_확인() {
        System.out.println("\n===== ProxyFactory로 JDK 동적 프록시 생성 =====");

        TestService target = new TestServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        proxyFactory.setProxyTargetClass(false);

        proxyFactory.addAdvice((MethodInterceptor) invocation -> {
            System.out.println("Before method: " + invocation.getMethod().getName());
            Object result = invocation.proceed();
            System.out.println("After method: " + invocation.getMethod().getName());
            return result;
        });

        TestService proxy = (TestService) proxyFactory.getProxy();

        boolean isAopProxy = AopUtils.isAopProxy(proxy);
        boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean isCglibProxy = AopUtils.isCglibProxy(proxy);
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(proxy);

        System.out.println("ProxyFactory로 생성한 TestService는 AOP 프록시인가? " + isAopProxy);
        System.out.println("ProxyFactory로 생성한 TestService는 JDK 동적 프록시인가? " + isJdkDynamicProxy);
        System.out.println("ProxyFactory로 생성한 TestService는 CGLIB 프록시인가? " + isCglibProxy);
        System.out.println("실제 타겟 클래스: " + targetClass.getName());
        System.out.println("프록시 클래스: " + proxy.getClass().getName());

        assertThat(isAopProxy).isTrue();
        assertThat(isJdkDynamicProxy).isTrue();
        assertThat(isCglibProxy).isFalse();

        System.out.println("\n프록시를 통한 메서드 실행:");
        proxy.doSomething();
    }

    @Test
    void ProxyFactory로_CGLIB_프록시_생성_확인() {
        System.out.println("\n===== ProxyFactory로 CGLIB 프록시 생성 =====");

        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        proxyFactory.setProxyTargetClass(true);

        proxyFactory.addAdvice((MethodInterceptor) invocation -> {
            System.out.println("Before method: " + invocation.getMethod().getName());
            Object result = invocation.proceed();
            System.out.println("After method: " + invocation.getMethod().getName());
            return result;
        });

        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();

        boolean isAopProxy = AopUtils.isAopProxy(proxy);
        boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean isCglibProxy = AopUtils.isCglibProxy(proxy);
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(proxy);

        System.out.println("ProxyFactory로 생성한 ConcreteService는 AOP 프록시인가? " + isAopProxy);
        System.out.println("ProxyFactory로 생성한 ConcreteService는 JDK 동적 프록시인가? " + isJdkDynamicProxy);
        System.out.println("ProxyFactory로 생성한 ConcreteService는 CGLIB 프록시인가? " + isCglibProxy);
        System.out.println("실제 타겟 클래스: " + targetClass.getName());
        System.out.println("프록시 클래스: " + proxy.getClass().getName());

        assertThat(isAopProxy).isTrue();
        assertThat(isJdkDynamicProxy).isFalse();
        assertThat(isCglibProxy).isTrue();

        System.out.println("\n프록시를 통한 메서드 실행:");
        proxy.doSomething();
    }

    @Test
    void 인터페이스가_있어도_CGLIB_프록시_생성_확인() {
        System.out.println("\n===== 인터페이스가 있어도 CGLIB 프록시 생성 =====");

        TestService target = new TestServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        proxyFactory.setProxyTargetClass(true);

        proxyFactory.addAdvice((MethodInterceptor) invocation -> {
            System.out.println("Before method: " + invocation.getMethod().getName());
            Object result = invocation.proceed();
            System.out.println("After method: " + invocation.getMethod().getName());
            return result;
        });

        TestService proxy = (TestService) proxyFactory.getProxy();

        boolean isAopProxy = AopUtils.isAopProxy(proxy);
        boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        boolean isCglibProxy = AopUtils.isCglibProxy(proxy);

        System.out.println("인터페이스가 있는 TestService를 CGLIB로 생성: " + isCglibProxy);
        System.out.println("JDK 동적 프록시인가? " + isJdkDynamicProxy);
        System.out.println("프록시 클래스: " + proxy.getClass().getName());

        assertThat(isAopProxy).isTrue();
        assertThat(isCglibProxy).isTrue();
        assertThat(isJdkDynamicProxy).isFalse();

        System.out.println("\n프록시를 통한 메서드 실행:");
        proxy.doSomething();
    }
}
