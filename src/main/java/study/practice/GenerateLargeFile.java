package study.practice;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class GenerateLargeFile {
    //写入一个2GB的文件，文件内容全用0xFF填充，其中随机混入随机个0x01
    public static void main(String[] args) {
        String filePath = "largeFile.bin";
        long fileSize = 2L * 1024 * 1024 * 1024; // 2GB
        // 创建一个RandomAccessFile实例，模式为读写（rw）
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            fillWithFF(file, fileSize);
            System.out.println("File generation complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillWithFF(RandomAccessFile file, long size) throws IOException {
        byte[] buffer = new byte[1024*1024*4]; // 4MB buffer 这个数组被用作读取和写入文件时的缓冲区。
        long remainingSize = size;

        while (remainingSize > 0) {
            int bytesToWrite =  (int) Math.min(remainingSize, buffer.length);
            for (int i = 0; i < bytesToWrite; i++) {
                buffer[i] = (byte) 0xFF;
            }
            file.write(buffer, 0, bytesToWrite);
            remainingSize -= bytesToWrite;
        }
        Random random = new Random();
    }
}

