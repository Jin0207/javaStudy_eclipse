package com.sist.pro04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDateTest {
	
	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		int data;
		String d = null;
		StringBuffer str = new StringBuffer();
		
		data = today.get(Calendar.YEAR);
		str.append(Integer.toString(data) + "/");
		data = today.get(Calendar.MONTH) + 1;
		str.append(Integer.toString(data) + "/");
		data = today.get(Calendar.DATE);
		str.append(Integer.toString(data));

		try {
			MyDate md = new MyDate(str.toString());
			int year = md.getYear();
			int month = md.getMonth();
			int date = md.getDate();
			System.out.printf("오늘은 %d년 %d월 %d일 입니다.%n", year, month, date);
		}catch (IllegalArgumentException i) {
			System.out.println("예외발생: " + i.getMessage());
		}

	}
}
