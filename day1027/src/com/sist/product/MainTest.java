package com.sist.product;

public class MainTest {

	public static void main(String[] args) {
		//제품 객체를 생성합니다
		Product product = new Product();
		//생산자 쓰레드 객체를 생성합니다
		Producer producer = new Producer(product);
		//소비자 쓰레드 객체를 생성합니다
		Consumer consumer = new Consumer(product);
		
		//생산자와 소비자를 가동합니다.
		producer.start();
		consumer.start();
	}

}
