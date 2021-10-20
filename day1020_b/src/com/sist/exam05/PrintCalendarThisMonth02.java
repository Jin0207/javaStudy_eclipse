package com.sist.exam05;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrintCalendarThisMonth02 {

	public static void main(String[] args) {
		
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		
		GregorianCalendar startDate = new GregorianCalendar(year,month,1);
		int day = startDate.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		System.out.printf("%d년 %d월\n", year, month+1);
		System.out.print("일\t월\t화\t수\t목\t금\t토\n");
		
		for(int i = 1; i < day; i++) {
			System.out.print("\t");
		}
		
		int[] lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i = 1; i <= lastDate[month]; i++) {
			System.out.print(i + "\t");
			if((i + day - 1) % 7 == 0) {
				System.out.println();
			}
			
		}

	}

}
