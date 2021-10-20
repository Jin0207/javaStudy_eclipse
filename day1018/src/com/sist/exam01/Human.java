package com.sist.exam01;

public abstract class Human {
	protected String name;
	protected int age;
	public String addr;
	//생성자
	public Human(String name, int age) {
		super();
		System.out.println("Human 생성자 동작함");
		this.name = name;
		this.age = age;
	}
	//getter, setter
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

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
	public abstract String getProfession(); //추상메서드
	/*
	public static void main(String[] args) {
		Human human = new Human("춘향", 18);
		Human human2 = new Human("몽룡", 21);
		Human human3 = new Human("사또", 50);
		
		System.out.println(human.toString());
		System.out.println(human2);
		System.out.println(human3);
		//추상클래스의 객체는 생성할 수 없음
	}
	*/
	
}
