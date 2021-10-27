package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		Person kim = new Person("김유신");
		Person im = new Person("상이");
		Person hong = new Person("홍달이");
		//im.setPriority(10);
		//상수를 이용하면 보다 직관적이다.
		im.setPriority(Thread.MAX_PRIORITY);
		//최고우선순위를 설정하였다고 반드시 일이 가장 먼저 끝나지는 않는다
		//가급적 일을 빨리 끝내달라고 "응급성"을 설정한느 것 뿐임
		kim.start();
		im.start();
		hong.start();
		

		System.out.println("im의 우선순위" + im.getPriority());
		System.out.println("kim의 우선순위" + kim.getPriority());
		System.out.println("hong의 우선순위" + hong.getPriority());
	}

}
