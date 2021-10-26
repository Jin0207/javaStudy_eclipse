package com.sist.exam03;

public class Person extends Thread {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		//super.run();
		for(int i = 1; i <= 10; i++) {
			System.out.println("¾È³ç, " + name + "--" + i);
			
			try {
				Thread.sleep(100);
			}catch (Exception e) {
			}
		}
	}
	
	
}
