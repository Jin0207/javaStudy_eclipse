package com.sist.exam02;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("¾È³ç, " + name +"--" + i);
			
			try {
				Thread.sleep(100);
			}catch (Exception e) {
			}
		}
	}
}
/*
 * ThreadÅ¬·¡½º
 * .sleep(long millis, int nanos)
 * public static void sleep(long millis, int nanos) throws InterruptedException
 */
