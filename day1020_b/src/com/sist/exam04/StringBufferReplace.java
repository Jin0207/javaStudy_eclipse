package com.sist.exam04;

public class StringBufferReplace {

	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello korea");
		
		//data.replace(0, 5, "Welcome");
		//System.out.println(data);
		
		String oldString = "hello";
		String newString = "hi";
		
		int start = data.indexOf(oldString);
		int end = start + oldString.length();
		
		data.replace(start, end, newString);
		System.out.println(data);
	}

}
