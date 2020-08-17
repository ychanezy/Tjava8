package com.atguigu.eventBus;

public class RegPromotionObserver {

     @Subscribe
     public void handleRegSuccess(Long userId) {
         System.out.println("userId:"+userId);
     }
}
