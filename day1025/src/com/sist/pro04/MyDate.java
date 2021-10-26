package com.sist.pro04;

import java.util.StringTokenizer;

public class MyDate {
		private int year, month, date;

		public MyDate(String data) throws IllegalArgumentException{ // "��/��/��"
			
			if(data == null) {
				throw new IllegalArgumentException("YEAR/MONTH/DATE������ ���ڿ��� �ۼ����ּ���.");
			}
			
			StringTokenizer st = new StringTokenizer(data, "/");
			year = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			date = Integer.parseInt(st.nextToken());
					
		}
		
		public int getYear() {
			return year;
		}

		public int getMonth() {
			return month;
		}

		public int getDate() {
			return date;
		}


}
