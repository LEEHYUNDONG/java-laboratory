package com.example.java.lang.advanced._2.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat", false);
        byte[] input = {65, 66, 67}; // A, B, C in ASCII
        fos.write(input); // Write the byte array to the file

        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] readBytes = fis.readAllBytes(); // Read all bytes from the file
        System.out.println(Arrays.toString(readBytes)); // Print the buffer contents
        fis.close();
    }
}
