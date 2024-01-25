package study.practice;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CountByteOccurrences {
    public static void main(String[] args) {
        String filePath = "largeFile.bin";
        byte targetByte = 0x01;
        //  RandomAccessFile 是 Java 中用于随机访问文件的类，它允许你在文件中定位读写的位置。
        //  你可以使用 RandomAccessFile 类来进行文件的读取和写入，并且可以在文件中移动到指定的位置。
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long fileSize = file.length();
            int bufferSize = 100 * 1024 * 1024; // 100MB buffer size
            byte[] buffer = new byte[bufferSize];

            long bytesRead = 0;
            long totalCount = 0;

            while (bytesRead < fileSize) {
                int bytesToRead = (int) Math.min(bufferSize, fileSize - bytesRead);
                file.read(buffer, 0, bytesToRead);

                // Count occurrences of target byte in the buffer
                for (int i = 0; i < bytesToRead; i++) {
                    if (buffer[i] == targetByte) {
                        totalCount++;
                    }
                }

                bytesRead += bytesToRead;
            }

            System.out.println("Occurrences of 0x01: " + totalCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
