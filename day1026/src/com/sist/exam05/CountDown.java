package com.sist.exam05;
//1�ʿ� �ѹ��� ī��Ʈ �ٿ��� ���� �޽����� ����ϴ� ���α׷�
public class CountDown extends Thread {
	private int count;
	
	public CountDown(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = count; i >= 0; i--) {
			System.out.println(i + "�� ���Դϴ�.");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
			}
		}
	}
	
	
}
