package com.atguigu.fanxin.extend1.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	  //第一种声明：简单，灵活性低

    public static <T extends Comparable<T>> void mySort1(List<T> list){
        Collections.sort(list);
    }

    //第二种声明：复杂，灵活性高

    public static <T extends Comparable<? super T>> void mySort2(List<T> list){
        Collections.sort(list);
    }

    public static void main(String[] args){

        //主函数中将分别创建Animal和Dog两个序列，然后调用排序方法对其进行测试

        //main函数中具体的两个版本代码将在下面具体展示
    	// 创建一个 Animal List

    	List<Animal> animals = new ArrayList<Animal>();
    	animals.add(new Animal(25));
    	animals.add(new Dog(35));
    	
    	// 创建一个 Dog List
    	List<Dog> dogs = new ArrayList<Dog>();
    	dogs.add(new Dog(5));
    	dogs.add(new Dog(18));

    	/**
    	 * 　mySort1() 方法的类型参数是<T extends Comparable<T>>，它要求的类型参数是类型为T的Comparable。

		　　如果传入的是List<Animal>程序将正常执行，因为Animal实现了接口Comparable<Animal>。
		
		　　但是，如果传入的参数是List<Dog>程序将报错，因为Dog类中没有实现接口Comparable<Dog>，它只从Animal继承了一个Comparable<Animal>接口。
		
		　　注意：animals list中实际上是包含一个Dog实例的。如果碰上类似的情况（子类list不能传入到一个方法中），可以考虑把子类实例放到一个父类 list 中，避免编译错误。
    	 */
    	// 测试  mySort1() 方法
    	mySort1(animals);
//    	mySort1(dogs);
    	
    	// 测试  mySort2() 方法

    	/**
    	 * 这时候我们发现该程序可以正常运行。它不但能够接受Animal implements Comparable<Animal>这样的参数，
    	 * 也可以接收：Dog implements Comparable<Animal>这样的参数。
    	 */
        mySort2(animals);

        mySort2(dogs);
    	
        /**
         * 总结　

　                        　对Animal/Dog这两个有父子关系的类来说：<T extends Comparable<? super T>>可以接受List<Animal>，
                               也可以接收 List<Dog> 。而<T extends Comparable<T>>只可以接收 List<Animal>所以，<T extends Comparable<? super T>>这样的类型参数对所传入的参数限制更少，
                               提高了 API 的灵活性。总的来说，在保证类型安全的前提下，要使用限制最少的类型参数。
         */
    }
}
