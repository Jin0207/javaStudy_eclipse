package com.sist.exam03;

import java.util.Scanner;

public class StringReplaceTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("���ڿ��� �Է����ּ���: ");
		str = sc.next();
		
		str = str.replace("hello", "�ȳ�");
		System.out.println(str);
	}

}
