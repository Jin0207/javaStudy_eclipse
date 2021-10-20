package com.sist.exam02;

import java.util.Scanner;

public class ValidJuminNumber {
	public static void main(String[] args) {
		String jumin;
		int[] n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		Scanner sc =new Scanner(System.in);
		
		System.out.println("주민번호를 입력하시오('-'): ");
		jumin = sc.next();
		
		int sum = 0;
		for(int i = 0; i < jumin.length()-1; i++) {
			if(i != 6) {
				sum += Integer.parseInt(jumin.charAt(i) + "") * n[i];
			}
		}
		sum %= 11;
		sum = 11 - sum;
		if(sum == 10) {
			sum = 0;
		}
		if(sum == 11) {
			sum = 1;
		}
		int check = Integer.parseInt(jumin.charAt(13) + "");
		
		if(sum == check) {
			System.out.println("올바른 주민등록번호입니다.");
		}else {
			System.out.println("올바른 주민등록번호가 아닙니다.");			
		}
	}
}
