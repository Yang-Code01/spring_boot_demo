package com.qingmin.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author code-yang
 * @date 2021/9/22 14:58
 * @Description
 * @Return
 * @Throws
 */
public class FileChannelDemo2 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\AVTNTW672\\develop\\spring_boot_demo\\nio\\note\\01.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        String str1 = "yqm 5201314";

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(str1.getBytes());

        buffer.flip();
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }
        channel.close();


    }
}
