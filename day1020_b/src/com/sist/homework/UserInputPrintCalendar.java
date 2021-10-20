package com.sist.homework;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UserInputPrintCalendar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year, month, startDay;
		
		System.out.print("�⵵�� �Է��ϼ���: ");
		year = sc.nextInt();
		System.out.print("���� �Է��ϼ���: ");
		month = sc.nextInt() - 1;
		GregorianCalendar printMonth = new GregorianCalendar(year, month, 1);
		startDay = printMonth.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("----------------------------------------------------");
		System.out.printf(" %4d�� %2d��%n", year, month+1);
		System.out.printf(" ��\t ��\t ȭ\t ��\t ��\t ��\t ��%n");
		System.out.println("----------------------------------------------------");
		
		for(int i = 1; i < startDay; i++) {
			System.out.print("\t");
		}
		
		for(int i = 1; i <= lastDate[month]; i++) {
			System.out.printf("%2d\t", i);
			if((i + startDay - 1) % 7 == 0) {
				System.out.println();
			}
		}
		
	}
}
