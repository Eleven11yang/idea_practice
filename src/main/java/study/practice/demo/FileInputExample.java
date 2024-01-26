package study.practice.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputExample {
    public static void main(String[] args) {
//        File file = new File("largeFile.bin");
//        System.out.print(file.length());
        try (FileInputStream fis = new FileInputStream("largeFile.bin")) {
//            int byteData;
//            while ((byteData = fis.read()) != -1) {
//                // 处理每个字节的操作
//                System.out.print((char) byteData);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

