package com.sist.exam05;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DAY_OF_MONTH);
		System.out.printf("������ %d�� %d�� %d���Դϴ�.", year, month+1, date);
	}

}