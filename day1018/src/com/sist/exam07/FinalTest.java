package com.sist.exam07;
class Person{
	public String name = "ȫ�浿";
	public final String addr = "����� ������ ������";
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		System.out.println(person.name);
		System.out.println(person.addr);
		person.name = "ȫ�ν�";
		System.out.println(person.addr);
		System.out.println(person.name);
		
	}

}
