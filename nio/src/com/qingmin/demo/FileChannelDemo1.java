package com.qingmin.demo;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author code-yang
 * @date 2021/9/22 14:43
 * @Description
 * @Return
 * @Throws
 */
public class FileChannelDemo1 {
    /*
    * FileChannel 读取数据到Buffer 再从buffer中读出
    * */

    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\AVTNTW672\\develop\\spring_boot_demo\\nio\\note\\01.txt", "rw");
        // 根据文件创建Channel
        FileChannel channel = accessFile.getChannel();
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        while (read != -1){
            System.out.println("读取："+read);
            // 转换
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        accessFile.close();
        System.out.println("结束");


    }
}
