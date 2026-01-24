package com.example.java.work.practice.masking.dto;

import com.example.java.work.practice.masking.config.annotation.MaskApply;
import com.example.java.work.practice.masking.entity.MaskType;



public class MemberResDto {

    private long memberId;

    @MaskApply(type = MaskType.NAME)
    private String name;

    @MaskApply(type = MaskType.PHONE)
    private String phone;

    @MaskApply(type = MaskType.EMAIL)
    private String email;
}
