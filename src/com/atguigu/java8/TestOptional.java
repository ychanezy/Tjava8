package com.atguigu.java8;

import java.util.Optional;

import org.junit.Test;

/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {
	
	@Test
	public void test10() {
		/**
		 * 不允许包裹为null的对象，否则程序报错。
		 */
//		Optional op = Optional.of(null);//此处会报错
//		System.out.println(op);
		/**
		 * 注意：当使用get()获取容器中的对象时，如果对象为null，会有java.util.NoSuchElementException异常。
		 * 所以最好先进行isPresent()判断，如果返回true，说明存在，然后再获取。
		 */
		Optional op1 = Optional.ofNullable(null); //这种是正常的
		System.out.println(op1.orElse("a"));
		if(op1.isPresent()) {
			System.out.println("OK");
		}else {
			System.out.println("nok");
		}
//		System.out.println(op1.get());
		/**
		 * 如果值存在并且满足断言，则返回满足条件的Optional，否则返回empty。经常用来做过滤。
		 */
		 Optional<String> op = Optional.of("jack");
	     Optional res = op.filter((name)-> name.length()>6);
	     System.out.println(res);  //Optional.empty
	     
	     /**
	      * 如果值存在则对其进行mapping函数操作，如果mappping结果不为空则返回Optional，否则返回empty。
	      */
//	     Optional<String> op_1 = Optional.of("jack");  ////Optional[hello,jack]
	     Optional<String> op_1 = Optional.ofNullable(null);  //Optional.empty
	     Optional res1 = op_1.map((name) -> "hello,"+name);
	     System.out.println(res1+"=res_1");
	     
	     /**
	      * 功能类似map，只不过需要在mapping函数中，自己封装成Optional。
	      */
//	     Optional<String> op_2 = Optional.of("jack"); //Optional[hello,jack]
	     Optional<String> op_2 = Optional.ofNullable(null);  //Optional.empty
	     Optional res_2 = op_2.flatMap((name) -> Optional.ofNullable("hello,"+name));
	     System.out.println(res_2+"=res_2");
	     
	     /**
	      * orElse值存在则返回，否则返回其它值。相当于给默认值。
	      */
//	     Optional<String> op_3 = Optional.ofNullable(null); //other
	     Optional<String> op_3 = Optional.ofNullable("lisi");  //lisi
	     System.out.println(op_3.orElse("other"));  
	     
	     /**
	      * 功能类似orElse都是返回值，不同在于它能使用lambda表达式更灵活的处理返回默认值
	      */
//	     Optional<String> op_4 = Optional.ofNullable(null);  //true
	     Optional<String> op_4 = Optional.ofNullable("baidu"); //baidu
	     System.out.println(op_4.orElseGet(() -> String.valueOf(true))); 
		
	}
	
	@Test
	public void test4(){
		Optional<Employee> op = Optional.of(new Employee(101, "张三", 18, 9999.99));
		
//		Optional<String> op2 = op.map(Employee::getName);
//		System.out.println(op2.get());
		
		Optional<String> op2 = op.map(e -> e.getName());
		System.out.println(op2.get());
		
		Optional<String> op3 = op.flatMap(e -> Optional.of(e.getName()));
		System.out.println(op3.get());
	}
	
	@Test
	public void test3(){
		Employee e = null;
		Optional<Employee> op = Optional.ofNullable(e);
		
		if(op.isPresent()){
			System.out.println(op.get());
		}
		
		Employee emp = op.orElse(new Employee("张三"));
		System.out.println(emp);
		
		Employee emp2 = op.orElseGet(() -> new Employee());
		System.out.println(emp2);
	}
	
	@Test
	public void test2(){
		/*Optional<Employee> op = Optional.ofNullable(null);
		System.out.println(op.get());*/
		
//		Optional<Employee> op = Optional.empty();
//		System.out.println(op.get());
	}

	@Test
	public void test1(){
		Optional<Employee> op = Optional.of(new Employee());
		Employee emp = op.get();
		System.out.println(emp);
	}
	
	@Test
	public void test5(){
		Man man = new Man();
		
		String name = getGodnessName(man);
		System.out.println(name);
	}
	
	//需求：获取一个男人心中女神的名字
	public String getGodnessName(Man man){
		if(man != null){
			Godness g = man.getGod();
			
			if(g != null){
				return g.getName();
			}
		}
		
		return "苍老师";
	}
	
	//运用 Optional 的实体类
//	@Test
//	public void test6(){
//		Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));
//		
//		Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
//		String name = getGodnessName2(op);
//		System.out.println(name);
//	}
//	
//	public String getGodnessName2(Optional<NewMan> man){
//		return man.orElse(new NewMan())
//				  .getGodness()
//				  .orElse(new Godness("苍老师"))
//				  .getName();
//	}
}
