package study.practice.hm3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CountByteOccurrences {
    //使用不超过100M的内存，扫描这个2GB的文件，统计0x01的数量
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
                // 计数缓冲区中目标字节的出现次数
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
