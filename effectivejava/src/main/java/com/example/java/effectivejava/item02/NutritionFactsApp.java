package com.example.java.effectivejava.item02;

/**
 * @author : lhd
 * @packageName : lhd.practice.effectivejava.item02
 * @fileName : effective-java
 * @description :
 * <p>
 * ====================================================
 * DATE            AUTHOR              NOTE
 * ====================================================
 * 2024-08-01         lhd
 */
public class NutritionFactsApp {

    public static void main(String[] args) {
        //기본 생성자를 생성하는 방식
        NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100, 0, 35, 27);
        System.out.println(nutritionFacts.toString());

        // 자바빈즈 생성자를 이용하여 실행
        NutritionFactsWithJavaBeansPattern nutritionFactsWithJavaBeansPattern = new NutritionFactsWithJavaBeansPattern();
        nutritionFactsWithJavaBeansPattern.setServingSize(240);
        nutritionFactsWithJavaBeansPattern.setServings(8);
        System.out.println(nutritionFactsWithJavaBeansPattern.toString());
    }
    
}
