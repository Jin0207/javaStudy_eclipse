package com.sist.exam02;

import java.util.Date;
import java.util.Scanner;

public class CancerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, jumin;
		char gender = '0';
		System.out.print("�̸��� �Է��ϼ���: ");
		name = sc.next();
		System.out.print("�ֹι�ȣ�� �Է��ϼ���('-' ���): ");
		jumin = sc.next();
		
		Date today = new Date();
		int thisYear = today.getYear() + 1900;
		int userYear = Integer.parseInt(jumin.substring(0, 2)) + 1900;
		int age = thisYear - userYear;
		
		String result = "����, ����";
		if(age >= 40 && thisYear % 2 == userYear % 2) {
			if(age >= 50) {
				result += ", �����";
			}
			if(gender == '2') {
				result += ", �����, �ڱþ�";
			}
			System.out.printf("%s��, %s�⵵�� ����ϰ���������Դϴ�.", name, thisYear);
			System.out.printf("�����׸��� %s �Դϴ�.", result);
		}
		
	}

}
