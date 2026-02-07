package com.example.java.lang.advanced._2.io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 3};

        //메모리 쓰기
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(input); // Write the byte array to the ByteArrayOutputStream

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        byte[] bytes = bais.readAllBytes(); // Read all bytes from the ByteArrayInputStream
        System.out.println("Read bytes: " + Arrays.toString(bytes)); // Print the read bytes
    }
}
