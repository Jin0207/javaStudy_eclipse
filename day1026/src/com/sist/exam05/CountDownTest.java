package com.sist.exam05;

public class CountDownTest {

	public static void main(String[] args) {
		//CountDown c = new CountDown(10);
		//c.start
		
		CountDown02 cd = new CountDown02(5);
		CountDownEvent c = new CountDownEvent(2, "������ġ�и�!!");
		
		new Thread(cd).start();
		c.start();
	}

}
