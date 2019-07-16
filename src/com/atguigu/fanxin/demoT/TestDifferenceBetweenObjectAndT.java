package com.atguigu.fanxin.demoT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDifferenceBetweenObjectAndT {
	public static void printList1(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static <T> void printList2(List<T> list) {
        for (T elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static  void printList3(List<?> list) {
        for (int i = 0;i<list.size();i++)
            System.out.println(list.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3);
        List<String>  test2 = Arrays.asList("one", "two", "three");
        List<Object> test3 = Arrays.asList(1, "two", 1.23);
    //    List<Fruit> test4 = Arrays.asList(new Apple(), new Banana());
        /*
        * 下面这句会编译报错，因为参数不能转化成功
        * */
    //    printList1(test4);
        /**/
//        printList1(test3);
//        printList1(test3);
//        printList2(test1);
//        printList2(test2);
//        printList2(test3);
//        printList3(test1);
//        printList3(test2);
//        printList3(test3);
        

//		List<Object> list1 = new ArrayList<>();
//		list1.add("hello");
//		list1.add(0);
//		 
//		List<String> list2 = new ArrayList<>();
//		list2.add("world");
//		 
//		List<?> list3 = new ArrayList<>();
//		list3.add("1");
		
		List<Student> list1 = new ArrayList<>();
		   list1.add(new Student("zhangsan",18,0));
		   list1.add(new Student("lisi",28,0));
		   list1.add(new Student("wangwu",24,1));
		   //这里如果add(new Teacher(...));就会报错，因为我们已经给List指定了数据类型为Student
		   show1(list1);

		   System.out.println("************分割线**************");

		   //这里我们并没有给List指定具体的数据类型，可以存放多种类型数据
		   List list2 = new ArrayList<>();
		   list2.add(new Student("zhaoliu",22,1));  //这里可以保存Student也可以保存Teacher
		   list2.add(new Teacher("sunba",30,0));
		   show2(list2);
		   show3(list2);
		   
		   List<Object> list4 = new ArrayList<>();
		   list4.add(new Student("sunba",30,0));
		   list4.add(new Teacher("zhaoliu",22,1));
		   show4(list4);
		
    }
    public static <T> void show1(List<T> list){
    	 for (Object object : list) {
    	        System.out.println(object.toString());
    	    }
    	}

	public static void show2(List<?> list) {
	    for (Object object : list) {
	        System.out.println(object);
	    }
	}
	//List<? extends Teacher> list这种写法表示可以接收Teacher和它的子类数据类型的list集合，写个测试方法show3(list2);试试：
	public static void show3(List<? extends Teacher> list) {
	    for (Object object : list) {
	        System.out.println(object);
	    }
	}
	public static void show4(List<? super Student> list) {
	    for (Object object : list) {
	        System.out.println(object);
	    }
	}
}
