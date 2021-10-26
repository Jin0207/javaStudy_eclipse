package com.sist.exam05;

public class CountDown02 implements Runnable {
	private int count;
	
	public CountDown02(int count) {
		this.count = count * 1000;
	}
	@Override
	public void run() {
		for(int i = count/1000; i > 0; i--) {
			System.out.println(i + "초 전입니다.");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
			}
		}	
		System.out.println("발사");
	}

}
