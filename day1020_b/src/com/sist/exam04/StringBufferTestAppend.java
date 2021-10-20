package com.sist.exam04;

public class StringBufferTestAppend {

	public void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello");
		String msg = "java";
		int year = 2021;
		boolean flag = true;
		
		data.append("/"); //data 자신의 값이 변경됨
		data.append(msg);
		data.append("/");
		data.append(year);
		data.append("/");
		data.append(flag);
		System.out.println(data);
		
	}

}
