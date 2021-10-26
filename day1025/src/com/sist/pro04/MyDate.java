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
			throw new IllegalArgumentException("예외발생: YEAR/MONTH/DATE형태의 문자열을 작성해주세요.");
		}else {
			System.out.printf("오늘은 %s년 %s월 %s일 입니다", year, month, date);
		}
	}


}
