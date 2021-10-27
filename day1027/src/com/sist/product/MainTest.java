package com.sist.product;

public class MainTest {

	public static void main(String[] args) {
		//��ǰ ��ü�� �����մϴ�
		Product product = new Product();
		//������ ������ ��ü�� �����մϴ�
		Producer producer = new Producer(product);
		//�Һ��� ������ ��ü�� �����մϴ�
		Consumer consumer = new Consumer(product);
		
		//�����ڿ� �Һ��ڸ� �����մϴ�.
		producer.start();
		consumer.start();
	}

}
