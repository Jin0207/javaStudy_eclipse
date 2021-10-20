package com.sist.exam05;

import java.util.Date;

public class System_CurrentTime {

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		
		System.out.println(millis);
		
		Date today = new Date(millis);
		System.out.printf("%dΩ√ %d∫– %d√ ", today.getHours(), today.getMinutes(), today.getSeconds());
	}

}
