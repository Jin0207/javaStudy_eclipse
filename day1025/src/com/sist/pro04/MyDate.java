package com.sist.pro04;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class MyDate {
	public MyDate(String str) throws IllegalArgumentException{
		String year, month, date;
		StringTokenizer st = new StringTokenizer(str, "/");
		year = st.nextToken();
		month = st.nextToken();
		date = st.nextToken();
		
		if(year.equals("null") || month.equals("null")|| date.equals("null")) {
			throw new IllegalArgumentException("���ܹ߻�: YEAR/MONTH/DATE������ ���ڿ��� �ۼ����ּ���.");
		}else {
			System.out.printf("������ %s�� %s�� %s�� �Դϴ�", year, month, date);
		}
	}


}
