package com.atguigu.test;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyn {

	public static void main(String[] args) throws InterruptedException {
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		SyncThread syncThread3 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread1, "SyncThread2");
		Thread thread3 = new Thread(syncThread1, "SyncThread3");
		thread1.start();
		//Thread.sleep(4000);
		thread2.start();
		thread3.start();
		Lock l = new ReentrantLock();
		ReadWriteLock ll = null;
		Condition c =null;
		ConcurrentSkipListMap cmap = null;
	}
}
