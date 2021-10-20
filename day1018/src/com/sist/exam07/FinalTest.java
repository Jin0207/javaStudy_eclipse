package com.sist.exam07;
class Person{
	public String name = "홍길동";
	public final String addr = "서울시 마포구 서교동";
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		System.out.println(person.name);
		System.out.println(person.addr);
		person.name = "홍두식";
		System.out.println(person.addr);
		System.out.println(person.name);
		
	}

}
