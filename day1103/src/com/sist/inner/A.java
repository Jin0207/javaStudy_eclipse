package com.sist.inner;

public class A {
	private String title = "Hello";
	
	public void pro() {
		System.out.println("A 클래스의 pro메소드");
		
		// 이너클래스의 멤버변수에 바로 접근할 수 없다
		// System.out.println(year);
		
		//접근하려면 객체를 생성하고 객체를 통해서 접근해야한다.
		B b = new B();
		System.out.println(b.year);
		
		//이너클래스는 이런식으로 사용할려고 만듦
		b.test();
	}
	
	//클래스 안의 클래스 -- inner class
	// 다른곳에선 B클래스가 필요가 없어서 이너클래스로 만듦
	class B{
		public int year = 2021;
		public void test() {
			System.out.println("B 클래스의 test메소드");
			
			//outter클래스의 멤버에 자유롭게 접근
			System.out.println(title);
			title = "hi";
			System.out.println(title);
			
		}// end test()
		
	}// end B class
	
	public static void main(String[] args) {
		A a = new A();
		a.pro();
		
		// 아래와 같이 하는 경우는 드물다
		//A.B ib = new A.B();
		
	}
}// end A
