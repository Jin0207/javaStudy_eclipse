package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		Person kim = new Person("������");
		Person im = new Person("����");
		Person hong = new Person("ȫ����");
		//im.setPriority(10);
		//����� �̿��ϸ� ���� �������̴�.
		im.setPriority(Thread.MAX_PRIORITY);
		//�ְ�켱������ �����Ͽ��ٰ� �ݵ�� ���� ���� ���� �������� �ʴ´�
		//������ ���� ���� �����޶�� "���޼�"�� �����Ѵ� �� ����
		kim.start();
		im.start();
		hong.start();
		

		System.out.println("im�� �켱����" + im.getPriority());
		System.out.println("kim�� �켱����" + kim.getPriority());
		System.out.println("hong�� �켱����" + hong.getPriority());
	}

}
