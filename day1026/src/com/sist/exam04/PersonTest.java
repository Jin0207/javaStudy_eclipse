package com.sist.exam04;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person("ȫ����");
		Person p1 = new Person("������");
		
		//p.start();
		/*
		 * Runnable �������̽��� run�޼��常 ����
		 * �׷��� ������ Thread ��ü�� �����ؼ� start�޼��带 ȣ��
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
