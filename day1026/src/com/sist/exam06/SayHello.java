package com.sist.exam06;

import java.util.Date;

public class SayHello extends Thread {
	public void getNow() {
		Date today = new Date();
		int hour = today.getHours();
		int minute = today.getMinutes();
		int second = today.getSeconds();
		
		String now = hour + ":" + minute + ":" + second;
		System.out.print(now);
	}
	@Override
	public void run() {
		for(; ;) {
			getNow();
			System.out.println(", æ»≥Á«œººø‰");
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
