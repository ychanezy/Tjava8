package com.atguigu.java81;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
