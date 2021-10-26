package com.sist.exam04;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person("홍돌이");
		Person p1 = new Person("갑돌이");
		
		//p.start();
		/*
		 * Runnable 인터페이스는 run메서드만 있음
		 * 그렇기 때문에 Thread 객체로 포장해서 start메서드를 호출
		 */
		/*
		Thread t = new Thread(p);
		Thread t1 = new Thread(p1);
		
		t.start();
		t1.start();
		*/
		new Thread(p).start();
		new Thread(p1).start();
		
	}

}
