package com.sist.exam03;

import java.util.Scanner;

public class StringStartsWithTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		
		System.out.print("�̸��� �Է��ϼ���");
		name = sc.next();
		if(name.startsWith("��")) {
			System.out.println("�达�Դϴ�.");
		}else {
			System.out.println("�达�� �ƴմϴ�.");
		}
		if(name.endsWith("��")) {
			System.out.println("�̸��� �������� '��' ����");
		}else {
			System.out.println("�̸��� �������� '��'�� �ƴϳ׿�.");
		}
	}

}
