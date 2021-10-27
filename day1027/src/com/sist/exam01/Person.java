package com.sist.exam01;

public class Person extends Thread {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 1; i<=10; i++) {
			System.out.println("¾È³ç, " + name + "-->" + i);
			
			try {
				Thread.sleep(200);
			}catch (Exception e) {
			}
		}
	}
	
	
	
}
