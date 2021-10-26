package com.sist.lab03_01;

import java.util.Scanner;

public class MyArray {
	public int[] data;
	
	public MyArray() {

			//data = new int[10];
			data = new int[0];
			Scanner sc = new Scanner(System.in);
			
			//for(int i = 0; i <= data.length; i++) 
			for(int i = 0; i < data.length; i++){
				System.out.printf("%d번째의 데이터를 입력하세요-->", i+1);
				data[i] = sc.nextInt();
			}

	}
	
	public double getAverage() {
		double avg = 0;
		int tot = 0;
			//for(int i = 0; i <= data.length; i++)
			for(int i = 0; i < data.length; i++) {
				tot += data[i];
			}
			
			avg = (double)tot / data.length;
			//avg = tot / data.length;

		return avg; 
	}
}
