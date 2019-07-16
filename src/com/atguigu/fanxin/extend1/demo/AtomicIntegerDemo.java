package com.atguigu.fanxin.extend1.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author WQ<br>
 * @version 创建时间：2017年6月18日 下午3:38:59<br>
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(-1);
        int i1 = ai.get();
        v(i1);
        int i2 = ai.getAndSet(5);
        v(i2);
        int i3 = ai.get();
        v(i3);
        int i4 = ai.getAndIncrement();
        v(i4);
        v(ai.get());

    }

    static void v(int i) {
        System.out.println("i : " + i);
    }
}