package com.atguigu.fanxin.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 类没有泛型：方法：
 * private <T> T take1(List<T> a) {
		return (T) "";
		
	}
	
	“<T>"和"<?>"，首先要区分开两种不同的场景：
	第一，声明一个泛型类或泛型方法。
	第二，使用泛型类或泛型方法。
	类型参数“<T>”主要用于第一种，声明泛型类或泛型方法。
	无界通配符“<?>”主要用于第二种，使用泛型类或泛型方法
	
 * @author ych
 *
 */
public class Test {
	
	public static void printCollecton(Collection <?> collection){
	    for(Object obj: collection){
		    System.out.println(obj);
		}
	}
	
	public static <T> T autoConvertType(T obj){
	     return(T)obj;
	}

	private static void take(Demo<?> a) {
		a.print();
	}
	private static void take1(Demo<Animal> a) {
		a.print();
	}
	
	private static <T> T take2(List<T> a) {
		return (T) a;
		
	}
	
	public static void main(String[] args) {
		Integer integer = new Integer(1);
		System.out.println(autoConvertType(integer));
		
		int i = 111;
		System.out.println(autoConvertType(i));
		
		
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		System.out.println(take2(lists));
		
		
		Demo<Dog> dog = new Demo<Dog>(new Dog());
        take(dog);
//        take1(dog);
        Demo<Cat> cat = new Demo<Cat>(new Cat());
        take(cat);
//        take1(cat);
        Demo<Animal> animal = new Demo<Animal>(new Animal());
        take(animal);
        take1(animal);
        
        Collection <Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        printCollecton(collection);
	}

}
