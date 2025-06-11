package com.example.java.lang.advanced._2.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false);
        byte[] input = {65, 66, 67}; // A, B, C in ASCII
        fos.write(input); // Write the byte array to the file

        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10]; // Buffer to hold the read bytes
        int readCount = fis.read(buffer, 0, 10); // Read bytes into the buffer
        System.out.println("readCount =" + readCount);
        System.out.println(Arrays.toString(buffer)); // Print the buffer contents
        fis.close();
    }
}
