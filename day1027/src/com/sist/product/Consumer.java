package com.sist.product;
//�Һ��ڸ� ���� Ŭ����
public class Consumer extends Thread {
	//"��ǰ"��ü�� �����ڰ� ���� �ִ� "��ǰ"�� ������ ��ü
	//���� "��ǰ"�� �����ڿ����� �����ϰ� ����
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
