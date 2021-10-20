package com.sist.exam03;

public class StringTestValue {

	public static void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		int data = 2021;
		
		pro(String.valueOf(data));
		pro(data+"");
	}

}
