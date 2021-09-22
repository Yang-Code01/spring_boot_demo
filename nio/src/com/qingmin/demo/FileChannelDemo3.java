package com.qingmin.demo;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author code-yang
 * @date 2021/9/22 15:20
 * @Description
 * @Return
 * @Throws
 */
public class FileChannelDemo3 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\AVTNTW672\\develop\\spring_boot_demo\\nio\\note\\02.txt", "rw");
        FileChannel aFileChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("C:\\Users\\AVTNTW672\\develop\\spring_boot_demo\\nio\\note\\03.txt", "rw");
        FileChannel bFileChannel = bFile.getChannel();

        long position = 0;
        long size = aFileChannel.size();
        bFileChannel.transferFrom(aFileChannel,position,size);

        aFileChannel.close();
        bFileChannel.close();
    }
}
