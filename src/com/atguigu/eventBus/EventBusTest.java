package com.atguigu.eventBus;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class EventBusTest {

    private EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public EventBusTest() {
        eventBus = new EventBus();
//        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式 } public void setRegObservers(List observers) { for (Object observer : observers) { eventBus.register(observer); } } public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码 long userId = userService.register(telephone, password); eventBus.post(userId); return userId; }}public class RegPromotionObserver { private PromotionService promotionService; // 依赖注入 @Subscribe public void handleRegSuccess(Long userId) { promotionService.issueNewUserExperienceCash(userId); }}public class RegNotificationObserver { private NotificationService notificationService; @Subscribe public void handleRegSuccess(Long userId) { notificationService.sendInboxMessage(userId, "..."); }}
    }

    public void setRegObservers(List <Object> observers) {
        observers.forEach(o -> eventBus.register(o));
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
        long userId = 1234567890L;
        eventBus.post(userId);
        return userId;
    }


        public static void main (String[]args){
            EventBusTest t =  new EventBusTest();
            t.setRegObservers(Arrays.asList(new RegPromotionObserver(), new RegNotificationObserver()));
           t.register("1234","12345");
        }


    }
