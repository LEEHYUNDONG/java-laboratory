//package com.example.java.generic;
//
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.MatchResult;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@SpringBootTest
//public class JavaGenericTest {
//
//    @Test
//    void generic() {
//        GenericT<Integer> integerData = new GenericT<Integer>();
//        integerData.setData(3);
//        assertThat(3).isEqualTo(integerData.getData());
//
//        GenericT<Double> floatData = new GenericT<>();
//        floatData.setData(0.3);
//        assertThat(0.3).isEqualTo(floatData.getData());
//
//        GenericT<String> stringData = new GenericT<>();
//        stringData.setData("333");
//        assertThat("333").isEqualTo(stringData.getData());
//
//    }
//
//    @Test
//    void printGeneric() {
//        ClassName<String> a = new ClassName<>();
//        ClassName<Integer> b = new ClassName<>();
//
//        a.setElement("This is String");
//        b.setElement(3);
//
//        System.out.println("a data :" + a.getElement());
//        System.out.println("a E Type :" + a.getElement().getClass().getName());
//        System.out.println();
//
//        System.out.println("b data :" + b.getElement());
//        System.out.println("b E Type :" + b.getElement().getClass().getName());
//        System.out.println();
//        // 제네릭 메소드1 Integer
//        System.out.println("<E> returnType : " + ClassName.method1(3).getClass().getName());
//
//        // 제네릭 메소드1 String
//        System.out.println("<E> returnType : " + ClassName.method1("ABCD").getClass().getName());
//
//        // 제네릭 메소드2 ClassName a
//        System.out.println("<T> returnType : " + ClassName.method2(a).getClass().getName());
//
//        // 제네릭 메소드2 Double
//        System.out.println("<T> returnType : " + ClassName.method2(3.0).getClass().getName());
//    }
//
//    @Test
//    @DisplayName("제네릭의 상속과 타입에 관련하여 알아보자")
//    void genericTypeTest() {
//        ClassName<Double> a1 = new ClassName<>();
//        ClassName<String> a2 = new ClassName<>();
//        a1.setElement(2.0);
//        a2.setElement("22");
//        assertThat(a1.getElement().getClass()).isNotEqualTo(a2.getElement().getClass());
//
//
//    }
//
//    @Test
//    @DisplayName("문자열 자르기")
//    void regexTest() {
//        String case1 = "AP1001 CP000111-101";
//        String case2 = "CP000111-101";
//        String case3 = "101";
//
//        String pjctCd = "CP00112";
//        String wbsCd = "W123123-103";
//
//
//        String word = case1;
//
//        Matcher m = Pattern
//                .compile("([a-zA-Z0-9+])+")
//                .matcher(word);    // 검색할 문자열 패턴 : 숫자
//
////        List<String> result = new ArrayList<>();
////
////        while (m.find()) {
////            result.add(m.group());
////        }
//
//
//
//    }
//}
//
