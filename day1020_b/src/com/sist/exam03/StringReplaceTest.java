package com.sist.exam03;

import java.util.Scanner;

public class StringReplaceTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("문자열을 입력해주세요: ");
		str = sc.next();
		
		str = str.replace("hello", "안녕");
		System.out.println(str);
	}

}
