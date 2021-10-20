package com.sist.exam05;

import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		//오늘날짜와 현재시간을 출력해보자
		Date today = new Date();
		//날짜
		String[] weeks = {"일", "월", "화", "수", "목", "금", "토"};
		int year = today.getYear() + 1900;
		int month = today.getMonth() + 1;
		int date = today.getDate();
		int week = today.getDay();
		//시간
		int hour = today.getHours();
		int minute = today.getMinutes();
		int seconds = today.getSeconds();
		
		System.out.printf("%d년 %d월 %d일 %s요일%n", year, month, date, weeks[week]);
		System.out.printf("%2d시 %2d분 %2d초%n", hour, minute, seconds);
		
		//나의 생년월일을 입력해서 무슨요일에 태어난지 알아보기
		Date myweek = new Date(95, 1, 7);
		int myDay = myweek.getDay();
		System.out.printf("상이는 1995년 2월 7일 %s요일에 태어났습니다.",weeks[myDay]);
	}

}
