package com.sist.exam05;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		String[] arr = {"��","��","ȭ","��","��","��","��"};
		//���ÿ� ���� �ð��� ��¥
		Date today = new Date();
		
		//Ư�� ��¥�� �ð�
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
			case 0: yoil = "��"; break;
			case 1: yoil = "��"; break;
			case 2: yoil = "ȭ"; break;
			case 3: yoil = "��"; break;
			case 4: yoil = "��"; break;
			case 5: yoil = "��"; break;
			case 6: yoil = "��"; break;
		}
		*/
		System.out.printf("%d.%d.%d(%s) %d:%d:%d%n", year, month, date, yoil, hours, minutes, seconds);
		System.out.println("================================================");
		//1995.07.29 �� ���� �����ϱ��?
		//Ư�� ��¥
		Date d2 = new Date(95,1,7);
		//year = -1900�ؼ� ��
		//month�� �������� ������ -1
		System.out.println(arr[d2.getDay()]);
		
	}

}
