package com.atguigu.fanxin.t;

import java.util.List;

/**
 * 1、类有泛型：Class<T>
 * private  T take1(List<T> a) {
		return (T) "";
		
	}
   2、?与T区别：
   private static void take(Demo<?> a) {
		a.print();
	}
	@Test
	与@com.atguigu.fanxin.t.@Test对比看：
 * @author ych
 *
 * @param <T>
 */
public class Test2<T> {

	private static void take(Demo<?> a) {
		a.print();
	}
//	private static void take1(Demo<T> a) { //这里的<T> 有问题： 因为Demo<T extends Animal>
//		a.print();
//	}
	@SuppressWarnings("unused")
	private  T take1(List<T> a,Class<T> c) {
		return (T) a;
		
	}
	
	public static void main(String[] args) {
		Demo<Dog> dog = new Demo<Dog>(new Dog());
	
        take(dog);
//        take1(dog);
        Demo<Cat> cat = new Demo<Cat>(new Cat());
        take(cat);
//        take1(cat);
        Demo<Animal> animal = new Demo<Animal>(new Animal());
        take(animal);
//        take1(animal);
	}

}
