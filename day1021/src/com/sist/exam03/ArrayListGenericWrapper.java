package com.sist.exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListGenericWrapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		double avg;
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d��° �л��� ������ �Է��ϼ���: ", i+1);
			list.add(sc.nextInt());
		}
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		avg = (double)sum / list.size();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d�� �л��� ���� : %d%n", i+1, list.get(i));
		}
		System.out.println();
		System.out.println("����: " + sum);
		System.out.println("���: " + avg);
	}

}
