package com.atguigu.fanxin.t;

public class Generic {

	public <T> T getObject(Class<T> c ) throws InstantiationException, IllegalAccessException {
		T t = c.newInstance();
		return t;
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Generic gene = new Generic();
		Object obj = gene.getObject(Test2.class);
		System.out.println(obj);
		
		System.out.println(Test2.class.newInstance());
		
		obj = gene.getObject(Class.forName("com.atguigu.fanxin.t.Cat"));
		System.out.println(obj);
	}
}
