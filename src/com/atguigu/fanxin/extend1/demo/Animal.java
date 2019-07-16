package com.atguigu.fanxin.extend1.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @AtomicInteger
 * @author Administrator
 *
 */
public class Animal implements Comparable<Animal>{

	protected int age;

    public Animal(int age){
        this.age = age;
    }

	//使用年龄与另一实例比较大小
	@Override
	public int compareTo(Animal other) {
		
		return this.age - other.age;
	}

}
