package com.example.java.designpattern._03_composite.after._2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GenerativeAiAppTest {

    @Autowired
    private List<GenerativeAi2> generativeAiList;


    @Test
    void generativeAiContextShouldHaveTwoComponent() {
        assertThat(generativeAiList.size()).isEqualTo(2);
    }


}