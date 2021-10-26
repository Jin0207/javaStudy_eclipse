package com.sist.exam03;

import java.util.Scanner;

public class ValidJuminNumber {
	public static void main(String[] args) {
		String jumin;
		int[] n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		Scanner sc =new Scanner(System.in);
		
		System.out.println("�ֹι�ȣ�� �Է��Ͻÿ�('-' �Է�): ");
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
			System.out.println("�ùٸ� �ֹε�Ϲ�ȣ�Դϴ�.");
		}else {
			try {
				throw new InvalidJuminNumberException("�ùٸ� �ֹι�ȣ ������ �ƴմϴ�.");
				//��������ǿ����� InvalidJuminNumberException��
				//RuntimeException�� �ļ��� �ƴ�
				//�׷��� ����ó���� �ؾ��Ѵ�.
			}catch (InvalidJuminNumberException e) {
				System.out.println("���ܹ߻�: " + e.getMessage());
			}
		}
	}
}
