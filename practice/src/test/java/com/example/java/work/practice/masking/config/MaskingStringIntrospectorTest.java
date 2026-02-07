package com.example.java.work.practice.masking.config;

import com.example.java.work.practice.masking.dto.MemberResDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;


class MaskingStringIntrospectorTest {
    private MemberResDto memberDto1;

    @BeforeEach
    void setUp() {
        memberDto1 =MemberResDto.builder()
                .memberId(1)
                .email("easttwave@gmail.com")
                .phone("010-1234-1234")
                .name("홍길동")
                .build();
    }


    @Test
    void isMaskingAplliedToDto() throws IOException {
        //given
        String expected = "{\"memberId\":1,\"name\":\"홍*동\",\"phone\":\"010-****-1234\",\"email\":\"eas******@gmail.com\"}";

        //when
        // 2. ObjectMapper를 사용하여 JSON 문자열로 직렬화
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(memberDto1);

        //then
        // 3. JSON 문자열 확인
        Assertions.assertThat(json).isEqualTo(expected);
    }

}
