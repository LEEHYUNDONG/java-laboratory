package com.example.java.practice.masking.config.annotation;

import com.example.java.practice.masking.config.MaskStringSerializer;
import com.example.java.practice.masking.entity.MaskType;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@JacksonAnnotationsInside
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = MaskStringSerializer.class)
public @interface MaskApply {
    MaskType type();
}
