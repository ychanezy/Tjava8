package com.atguigu.eventBus;

public class RegNotificationObserver {

    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("RegNotificationObserver:"+userId);
    }
}


