package com.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e:\\a.txt",true));

        bufferedWriter.write("hello,world");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,world");

        bufferedWriter.close();
    }
}
