package com.atguigu.ms.volatiledemo;

import java.util.concurrent.TimeUnit;


/**
 * class files->class loader->runtime data area={程序计数器、java程序栈、本地方法栈}
 * 方法区|栈(程序GC主要针对这两块区域)
 * --------------------------
 * 执行引擎 -->本地方法接口--->本地方法库
 */
class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    // 持有自己的锁，还想得到别人的锁

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + "\t 尝试获取：" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + "\t 尝试获取：" + lockA);
            }
        }
    }
    public static class DeadLockDemo {
        public static void main(String[] args) {
            String lockA = "lockA";
            String lockB = "lockB";

            new Thread(new HoldLockThread(lockA, lockB), "t1").start();

            new Thread(new HoldLockThread(lockB, lockA), "t2").start();
        }
    }
}
