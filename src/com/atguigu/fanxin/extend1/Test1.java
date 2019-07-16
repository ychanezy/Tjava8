package com.atguigu.fanxin.extend1;

import java.util.GregorianCalendar;

/**
 * 
 * 此时编译通过，这里可以理解为<GregorianCalendar extends Comparable<Calendar>>！
 * 因为Calendar为GregorianCalendar 的父类并且GregorianCalendar 
 * 实现了Comparable<Calendar>,具体可以在API中进行查看！
 * 
 * @author ych
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Demo1<GregorianCalendar> p = null;
	}
}
