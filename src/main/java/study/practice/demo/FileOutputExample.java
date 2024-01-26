package study.practice.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String data = "Hello, FileOutputStream!";
            byte[] byteData = data.getBytes();
            fos.write(byteData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
