package com.atguigu.stream;

import java.util.Optional;

import com.atguigu.java8.Employee;

public class T {

	public static void main(String[] args) {
		Employee e = new Employee();
		System.out.println(Optional.ofNullable(e.getName()).isPresent());
		
		

	}

}
