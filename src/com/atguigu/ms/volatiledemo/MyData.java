package com.atguigu.ms.volatiledemo;

public class MyData {
//	int number = 0;
	/**
     * volatile 修饰的关键字，是为了增加 主线程和线程之间的可见性，只要有一个线程修改了内存中的值，其它线程也能马上感知
     */
    volatile int number = 0;
	public void addTo60() {
		this.number = 60;
	}
}
