package com.example.java.work.practice.masking.config;

import com.example.java.work.practice.masking.config.annotation.MaskApply;
import com.example.java.work.practice.masking.entity.MaskType;
import com.example.java.work.practice.masking.utils.MaskingUtil;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MaskStringSerializer extends StdSerializer<String> implements ContextualSerializer {

    MaskType maskType;

    protected MaskStringSerializer() {
        super(String.class);
    }
    protected MaskStringSerializer(MaskType maskType) {
        super(String.class);
        this.maskType = maskType;

    }

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeString(MaskingUtil.mask(maskType, s));
    }

    /**
     *
     * @param serializerProvider
     * @param beanProperty
     * @return
     * @throws JsonMappingException
     * bean property가 null이
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        MaskApply maskApply = null;
        MaskType maskType = null;

        if (beanProperty != null) {
            maskApply = beanProperty.getAnnotation(MaskApply.class);
        }
        if(maskApply != null) {
            maskType = maskApply.type();
        }
        return new MaskStringSerializer(maskType);
    }
}
