package study.practice.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String content = "Hello, this is a text file!";

        try {
            createTextFile(filePath, content);
            System.out.println("Text file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTextFile(String filePath, String content) throws IOException {
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }
}
