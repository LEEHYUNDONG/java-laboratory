package com.example.java.designpattern._03_composite.after._2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class GenerativeAiApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GenerativeAiApp.class, args);

        // Spring이 자동으로 모든 GenerativeAi2 구현체를 주입
        List<GenerativeAi2> generativeAi2s = context.getBeansOfType(GenerativeAi2.class)
                .values()
                .stream()
                .toList();

        List<String> names = List.of("Claude", "ChatGpt");

        for (String name : names) {
            generativeAi2s.stream()
                    .filter(ai -> ai.isSupport(name))
                    .findFirst()
                    .ifPresent(ai -> ai.generate(name));
        }
    }
}
