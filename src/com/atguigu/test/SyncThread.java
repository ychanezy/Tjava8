package com.atguigu.test;
/**
* 同步线程
*/
class SyncThread implements Runnable {
        private static int count;

        public SyncThread() {
            count = 0;
        }

        public void run() {
            synchronized(this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public int getCount() {
            return count;
        }
}