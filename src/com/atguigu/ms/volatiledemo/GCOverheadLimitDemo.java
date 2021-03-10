package com.atguigu.ms.volatiledemo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * GC 回收超时
 * JVM参数配置: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * @author: 陌溪
 * @create: 2020-03-24-15:14
 */
public class GCOverheadLimitDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
//            while(true) {
//                list.add(String.valueOf(++i).intern());
//            }
        	// 只设置了5M的物理内存使用，但是却分配 6M的空间
        	ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        } catch (Exception e) {
            System.out.println("***************i:" + i);
            e.printStackTrace();
            throw e;
        } finally {

        }

    }
}