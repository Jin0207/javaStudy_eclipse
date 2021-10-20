package com.sist.exam04;

public class StringBufferDelete {

	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("Hello Java");
		
		data.deleteCharAt(5);
		System.out.println(data); //HelloJava
		data.delete(3, 5);
		System.out.println(data); //HelJava
		
	}

}
