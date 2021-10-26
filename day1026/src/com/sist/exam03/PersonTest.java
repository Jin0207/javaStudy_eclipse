package com.sist.exam03;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("홍식이");
		Person p2 = new Person("황진이");
		Person p3 = new Person("상이");
		
		p1.start();
		p2.start();
		p3.start();
		
		//쓰레드를 가동(동시에 공평하게 실행 해봐요)하려면 "start()"호출
		//그런데 start를 호출하지 않고 run()을 직접 호출하면
		//일반메소드처럼 동작한다. ( 호출순서대로 실행 )
	}

}
