package com.atguigu.fanxin.demoT;

public class Student{

	private  String name;
	
	private int age;
	
	private int sex;
	
	public Student(String string, int i, int j) {
		this.name = string;
		this.age = i;
		this.sex = j;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	

}
