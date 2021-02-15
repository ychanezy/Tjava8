package com.atguigu.test;
/**
* 银行账户类
*/
class Account {
        String name;
        float amount;

        public Account(String name, float amount) {
            this.name = name;
            this.amount = amount;
        }
//存钱
        public void deposit(float amt) {
            amount += amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//取钱
        public void withdraw(float amt) {
            amount -= amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public float getBalance() {
            return amount;
        }
}

/**
* 账户操作类
*/
class AccountOperator implements Runnable {
        private Account account;
        public AccountOperator(Account account) {
            this.account = account;
        }

        public void run() {
            synchronized (account) {
                account.deposit(500);
                account.withdraw(500);
                System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
            }
        }
}