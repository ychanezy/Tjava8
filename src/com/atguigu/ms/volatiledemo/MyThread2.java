package com.atguigu.ms.volatiledemo;

import java.util.concurrent.Callable;

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        return 1024;
    }
}
