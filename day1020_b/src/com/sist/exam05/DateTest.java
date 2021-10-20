package com.sist.exam05;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		String[] arr = {"일","월","화","수","목","금","토"};
		//오늘에 대한 시간과 날짜
		Date today = new Date();
		
		//특정 날짜와 시간
		Date d3 = new Date(1995,2,7,14,30,00);
		int year = today.getYear() + 1900;
		int month = today.getMonth() + 1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		
		String yoil = arr[day];
		/*
		switch(day) {
			case 0: yoil = "일"; break;
			case 1: yoil = "월"; break;
			case 2: yoil = "화"; break;
			case 3: yoil = "수"; break;
			case 4: yoil = "목"; break;
			case 5: yoil = "금"; break;
			case 6: yoil = "토"; break;
		}
		*/
		System.out.printf("%d.%d.%d(%s) %d:%d:%d%n", year, month, date, yoil, hours, minutes, seconds);
		System.out.println("================================================");
		//1995.07.29 은 무슨 요일일까요?
		//특정 날짜
		Date d2 = new Date(95,1,7);
		//year = -1900해서 줌
		//month도 마찬가지 이유로 -1
		System.out.println(arr[d2.getDay()]);
		
	}

}
