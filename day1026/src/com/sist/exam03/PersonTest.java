package com.sist.exam03;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("ȫ����");
		Person p2 = new Person("Ȳ����");
		Person p3 = new Person("����");
		
		p1.start();
		p2.start();
		p3.start();
		
		//�����带 ����(���ÿ� �����ϰ� ���� �غ���)�Ϸ��� "start()"ȣ��
		//�׷��� start�� ȣ������ �ʰ� run()�� ���� ȣ���ϸ�
		//�Ϲݸ޼ҵ�ó�� �����Ѵ�. ( ȣ�������� ���� )
	}

}
