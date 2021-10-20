package com.sist.exam02;

import java.util.Date;
import java.util.Scanner;

public class CancerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, jumin;
		char gender = '0';
		System.out.print("이름을 입력하세요: ");
		name = sc.next();
		System.out.print("주민번호를 입력하세요('-' 사용): ");
		jumin = sc.next();
		
		Date today = new Date();
		int thisYear = today.getYear() + 1900;
		int userYear = Integer.parseInt(jumin.substring(0, 2)) + 1900;
		int age = thisYear - userYear;
		
		String result = "위암, 간암";
		if(age >= 40 && thisYear % 2 == userYear % 2) {
			if(age >= 50) {
				result += ", 대장암";
			}
			if(gender == '2') {
				result += ", 유방암, 자궁암";
			}
			System.out.printf("%s님, %s년도에 무료암검진대상자입니다.", name, thisYear);
			System.out.printf("검진항목은 %s 입니다.", result);
		}
		
	}

}
