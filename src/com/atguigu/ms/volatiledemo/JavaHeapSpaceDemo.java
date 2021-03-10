package com.atguigu.ms.volatiledemo;
/**
 * Java堆内存不足
 * @author: 陌溪
 * @create: 2020-03-24-14:50
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {

        // 堆空间的大小 -Xms10m -Xmx10m
        // 创建一个 80M的字节数组
        byte [] bytes = new byte[80 * 1024 * 1024];
    }
}