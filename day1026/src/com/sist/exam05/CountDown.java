package com.sist.exam05;
//1초에 한번씩 카운트 다운을 위한 메시지를 출력하는 프로그램
public class CountDown extends Thread {
	private int count;
	
	public CountDown(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = count; i >= 0; i--) {
			System.out.println(i + "초 전입니다.");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
			}
		}
	}
	
	
}
