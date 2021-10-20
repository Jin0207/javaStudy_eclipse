package com.sist.exam03;

import java.util.Scanner;

public class StringStartsWithTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		
		System.out.print("이름을 입력하세요");
		name = sc.next();
		if(name.startsWith("김")) {
			System.out.println("김씨입니다.");
		}else {
			System.out.println("김씨가 아닙니다.");
		}
		if(name.endsWith("이")) {
			System.out.println("이름의 마지막이 '이' 군요");
		}else {
			System.out.println("이름의 마지막이 '이'가 아니네요.");
		}
	}

}
