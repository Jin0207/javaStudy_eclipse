package com.sist.product;

public class Producer extends Thread {
	//��ǰ�� ���� Ŭ������ ��������� ����
	private Product product;
	
	public Producer(Product product) {
		this.product = product;
	}
	
	//������ Ŭ������ ����Ͽ� ���ο� ��ǰ�� �����ϱ� ���� �޼ҵ带 ȣ���Ű�����Ͽ�
	//�����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵��Ͽ� �ۼ��Ѵ�.
	public void run() {
		
		//10���� ���ο� ��ǰ ����
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
