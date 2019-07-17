package com.atguigu.fanxin.demoT;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
	 public static void main(String[] args) throws ClassNotFoundException {
		 Class<?> t = Class.forName("com.atguigu.fanxin.demoT.Demo3");
//       //限制T 为String 类型
//       Demo2<String> demo = new Demo2<String>();
//
//       //获取string类型
//       List<String> array = new ArrayList<String>();
//       array.add("test");
//       array.add("doub");
//       String str = demo.getListFisrt(array);
//       System.out.println(str);
//
//       //获取Integer类型 T 为Integer类型
//       Demo2<Integer> demo2 = new Demo2<Integer>();
       Demo3 demo3 = new Demo3();
       List<Integer> nums = new ArrayList<Integer>();
       nums.add(12);
       nums.add(13);
       Integer num = demo3.getListFisrt(nums);
       System.out.println(num);
   }
   /**
    * 这个只能传递T类型的数据
    * 返回值 就是Demo<T> 实例化传递的对象类型
    * @param data
    * @return
    */
   private <T> T getListFisrt(List<T> data) {
       if (data == null || data.size() == 0) {
           return null;
       }
       return data.get(0);
   }
}
