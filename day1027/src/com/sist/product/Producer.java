package com.sist.product;

public class Producer extends Thread {
	//제품을 위한 클래스를 멤버변수로 선언
	private Product product;
	
	public Producer(Product product) {
		this.product = product;
	}
	
	//생산자 클래스는 계속하여 새로운 제품을 생성하기 위한 메소드를 호출시키기위하여
	//쓰레드가 해야하는 일을 run메소드를 오버라이딩하여 작성한다.
	public void run() {
		
		//10개의 새로운 제품 생산
		for(int i = 1; i <= 10; i++) {
			product.makeNumber();
			try {
				Thread.sleep(200);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
