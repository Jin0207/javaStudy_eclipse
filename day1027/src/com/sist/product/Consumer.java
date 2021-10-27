package com.sist.product;
//소비자를 위한 클래스
public class Consumer extends Thread {
	//"제품"객체는 생산자가 갖고 있는 "제품"과 동일한 객체
	//서로 "제품"을 공유자원으로 공유하고 있음
	private Product product;
	
	public Consumer(Product product) {
		this.product = product;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			product.getNumber(); 
			try{
				Thread.sleep(300);
			}catch (Exception e) {
			}
		}// end for
	}
}
