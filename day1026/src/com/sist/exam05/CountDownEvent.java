package com.sist.exam05;

public class CountDownEvent extends Thread{
	private int count;
	private String msg;
	
	public CountDownEvent(int count, String msg) {
		this.count = count * 1000;
		this.msg = msg;
	}
	
	@Override
	public void run() {
			try {
				Thread.sleep(count);
			}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(msg);
	}
}
