package com.sist.exam05;

import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		//���ó�¥�� ����ð��� ����غ���
		Date today = new Date();
		//��¥
		String[] weeks = {"��", "��", "ȭ", "��", "��", "��", "��"};
		int year = today.getYear() + 1900;
		int month = today.getMonth() + 1;
		int date = today.getDate();
		int week = today.getDay();
		//�ð�
		int hour = today.getHours();
		int minute = today.getMinutes();
		int seconds = today.getSeconds();
		
		System.out.printf("%d�� %d�� %d�� %s����%n", year, month, date, weeks[week]);
		System.out.printf("%2d�� %2d�� %2d��%n", hour, minute, seconds);
		
		//���� ��������� �Է��ؼ� �������Ͽ� �¾�� �˾ƺ���
		Date myweek = new Date(95, 1, 7);
		int myDay = myweek.getDay();
		System.out.printf("���̴� 1995�� 2�� 7�� %s���Ͽ� �¾���ϴ�.",weeks[myDay]);
	}

}
