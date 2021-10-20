package com.sist.exam03;

public class StringTestToLowerCase {

	public static void main(String[] args) {
		String data = "ABcde";
		String data2 = data.toLowerCase();
		String data3 = data.toUpperCase();
		
		System.out.println(data); // data는 변동없음, 새로운문자열을 반환하는 것임
		System.out.println(data2);
		System.out.println(data3);
	}

}
