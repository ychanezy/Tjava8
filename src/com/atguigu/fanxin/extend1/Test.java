package com.atguigu.fanxin.extend1;

import java.util.GregorianCalendar;

/**
 * 
 * 这里编译报错，因为这里的<T extends Comparable<T>>相当于<GregorianCalendar extends Comparable<GregorianCalendar>>,
 * 但是GregorianCalendar中并没有实现Comparable<GregorianCalendar>，
 * 而是仅仅持有从Calendar继承过来的Comparable<Calendar>，这样就会因为不在限制范围内而报错。
 * 
 * @author ych
 *
 */
public class Test {

	public static void main(String[] args) {
		//Demo<GregorianCalendar> p = null;
	}

}
