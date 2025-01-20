package com.example.java.work.practice.junit.junit.entity;

import com.example.java.work.practice.junit.junit.annotation.BeforeEachJ;
import com.example.java.work.practice.junit.junit.annotation.TestJ;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JTest {

    private List<Method> beforeMethods = new ArrayList<>();

    private List<Method> methods = new ArrayList<>();

    /**
     * 테스트를 실행시키는 메서드
     *
     * @param clazz
     * @return
     *
     * 테스트 메서드를 한개씩 실행하는 것이 맞음 왜냐하면 tearDown해야 하기 때문,
     * @BeforeEach와 같은 어노테이션은 구현하지 않는 것으로,,
     */
    public JTestResult run(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        //제네릭을 사용해서 해당 클래스의 메소드를 불러온다.
        //테스트 클래스의 생성자는 한개인 것으로 가정
        Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
//        Method[] methods = clazz.getDeclaredMethods();


        // setUp
        /**
         * 1. 인스턴스 변수 다 불러옴
         * 2. @BeforeEach 붙은 메서드 가져와
         * 3. 메서드 실행 - 내부 의존성 주입
         */
        setMethodByAnnotations(clazz);

        /**
         * 테스트 result는 뽑아서 주입을 받아야한다고 생각.
         * 그이유는 result는 외부에서 관리하여 message를 출력할 수 있어야함.
         * 테스트 클래스를 실행하는 곳에서 해당 행위를 하는것이 최선의 방식이 아니라고 생각함.
         * private 인스턴스로 가지고 있고 생성자 주입을 통하여 JTestResult를 포함하고 있어야하고,
         * 해당 인스턴스를 가지고 외부에서 testResult의 메시지를 뽑아야함.
         * ------------------------------------------------------------------------
         * 생각이 바뀜 run한 테스트가 테스트 결과를 반환하면 된다고 생각함..
         */
        JTestResult testResult = new JTestResult(methods.size(), 0); // 테스트 결과


        // 이부분이 tearDown이 된다고 생각하면 되는가..? 조금 헷갈림
        for (Method method : methods) {
            // method에 @Test 어노테이션이 붙이면 continue; 아니면 뺴고
            // Annotation annotations = method.getAnnotationsByType();

            //메서드 호출 허용
            method.setAccessible(true);
            Object o = constructor.newInstance();


            /**
             * 테스트 시에 인자값을 받지 않고 테스트 하는 방식으로 작성했으나, 어노테이션이나 특정 라이브러리를
             * 이용하여 인자값이 있는 메서드를 테스트할 수 있다.
             * ------------------------------------------------------------------------
             * 테스트 메서드를 실행하는 부분까지 작성을 완료했고,
             * 테스트가 끝나는 결과에 따라 결과값을 설정하는 것 개발
             */
            // 메서드 실행
            try {
                if(!ObjectUtils.isEmpty(beforeMethods)) {
                    for (Method beforeMethod : beforeMethods) {
                        beforeMethod.invoke(o);
                    }
                }
                method.invoke(o);
            } catch (Exception e) {
                //테스트 실패 케이스
                testResult.testFailed();
                e.printStackTrace();
            }
        }
        return testResult;
    }


    /**
     * @param clazz
     * @description : beforeEach 어노테이션이 붙은 메서드를 실행시키는 메서드
     * @issues      :
     * -----------------------------------------------------------
     * DATE              AUTHOR             MAJOR_ISSUE
     * -----------------------------------------------------------
     * 1/20/25           hd.lee6cj.net            생성
     * -----------------------------------------------------------
     *     */
    private void setMethodByAnnotations(Class<?> clazz) {
        Method[] clazzMethods = clazz.getDeclaredMethods();
        try {
        for (Method method : clazzMethods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(BeforeEachJ.class)) {
                beforeMethods.add(method);
            } else if (method.isAnnotationPresent(TestJ.class)) {
                methods.add(method);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

