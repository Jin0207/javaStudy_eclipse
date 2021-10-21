package com.sist.exam02;

import java.util.ArrayList;

class Person{
	private String name;
	private int age;
	//생성자
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//setter getter
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
	
	public void sayHello() {
		System.out.println(name + "님, 안녕하세요:)");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class ArrayListTest02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(true);
		list.add(new Person("홍길동", 20));
		list.add(new Person("이순실", 40));
		list.add(26.7);
		list.add(new Person("강감찬", 50));
		list.add("안녕 자바");
		list.add(2021);
		//list에 데이터가 있는 만큼 반복실행하면서
		//데이터를 하나씩 꺼집어내어 sayHello() 호출
		for(int i = 0; i < list.size(); i++) {
			//Object obj = list.get(i);
			//System.out.println(obj);
			Person p = (Person)list.get(i);
			p.sayHello();
		}
		
		
	}

}
