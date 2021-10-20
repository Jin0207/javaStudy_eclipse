package com.sist.exam05;

import java.util.Date;

public class PrintCalendarThisMonth {

	public static void main(String[] args) {
		Date today = new Date();
		int year = today.getYear();
		int month = today.getMonth();
		
		Date startDate = new Date(year,month,1);
		int day = startDate.getDay();
		
		System.out.printf("%d�� %d��\n", year+1900, month+1);
		System.out.print("��\t��\tȭ\t��\t��\t��\t��\n");
		
		for(int i = 1; i <= day; i++) {
			System.out.print("\t");
		}
		
		int[] lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i = 1; i <= lastDate[month]; i++) {
			System.out.print(i + "\t");
			if((i + day) % 7 == 0) {
				System.out.println();
			}
			
		}
	}

}
