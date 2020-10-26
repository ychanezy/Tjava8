package com.atguigu.java.sync;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class AsynThread {

	@Test
	public void asyncThread() throws Exception{
		CompletableFuture async1 = CompletableFuture.runAsync(()->{
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				System.out.println("none return Async");
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		//调用get()将等待异步逻辑处理完成
		async1.get();
		System.out.println(async1.get());
	}

	@Test
	public void asyncThread2() throws Exception {
		CompletableFuture<String> async2 = CompletableFuture.supplyAsync(()->{
			return "hello";
		});
		String result = async2.get();
		System.out.println(result);
	}
	
	@Test
	public void asyncThread3() throws Exception{
		CompletableFuture<String> a = CompletableFuture.supplyAsync(()->"hello");
		CompletableFuture<String> b = CompletableFuture.supplyAsync(()-> "youth");
		CompletableFuture<String> c = CompletableFuture.supplyAsync(()->"!");
		
		CompletableFuture all = CompletableFuture.allOf(a,b,c);
		all.get();
		
		String result = Stream.of(a,b,c)
				.map(CompletableFuture::join)
				.collect(Collectors.joining(" "));
		
		System.out.println(result);
	}
	
	@Test
	public void asyncThread4() throws Exception{
		CompletableFuture<String> a = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(20);
				return "hello";
			}catch(Exception e) {
				e.printStackTrace();
				return "none~";
			}
		});
		CompletableFuture<String> b = CompletableFuture.supplyAsync(()-> "youth");
		CompletableFuture<String> c = CompletableFuture.supplyAsync(()->"!");
		
		CompletableFuture<Object> any = CompletableFuture.anyOf(a,b,c);
		String result = (String) any.get();
		System.out.println(result);
	}
}






















