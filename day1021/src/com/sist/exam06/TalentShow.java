package com.sist.exam06;

import java.util.ArrayList;
import java.util.Scanner;

public class TalentShow {
	public static void main(String[] args) {
		
		ArrayList<Double> list = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("������ �Է����ּ���");
			list.add(sc.nextDouble());
			while(list.get(i) < 0 || list.get(i) > 10) {
				list.remove(i);
				System.out.println("������ �Է����ּ���");
				list.add(sc.nextDouble());
			}
		}
		
		double max = list.get(0);
		double min = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) > max) {
				max = list.get(i);
			}
			if(list.get(i) < min) {
				min = list.get(i);
			}
		}
		System.out.println("�ְ�����: " + max + "�� ��������: " + min + "�� ������");
		for(int i = 0; i < list.size(); i++) {
			if(max == list.get(i)) {
				list.remove(i);
			}
			if(min == list.get(i)) {
				list.remove(i);
			}
			
		}

		double tot = 0.0;
		for(double d : list) {
			tot += d;
		}
		System.out.println("�ɻ��������� ���� �հ�: " + tot);
	}
}
