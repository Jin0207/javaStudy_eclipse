package com.sist.exam04;

public class StringBufferInsert {

	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello java");
		int year = 2021;
		String msg = "hi ";
		boolean flag = true;
		
		data.insert(5, year);
		System.out.println(data);
		
		data.insert(0, msg);
		System.out.println(data);
		
		data.append(flag);
		//data.insert(data.length(), flag);
		System.out.println(data);
	}

}
