package study.practice.hm3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class GenerateLargeFile {
    //写入一个2GB的文件，文件内容全用0xFF填充，其中随机混入随机个0x01
    public static void main(String[] args) {
        String filePath = "largeFile.bin";
        long fileSize = 2L * 1024 * 1024 * 1024; // 2GB
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            byte[] data = new byte[1024 * 1024 * 4];//4MB
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) 0xFF;
            }
            for (int j = 0; j < fileSize / data.length; j++) {
                file.write(data,0,data.length);
            }
            Random random = new Random();
            long numReplacements = random.nextInt((int) (fileSize / 2)) + 1;
            for (long i = 0; i < numReplacements; i++) {
                long indexToReplace = random.nextInt((int)numReplacements);
                file.seek(indexToReplace);
                file.write(0x01);
            }
            System.out.println("File generation complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

