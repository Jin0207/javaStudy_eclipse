package com.sist.lab03;

import java.util.Scanner;

public class MyArray {
	public int[] data;
	
	public MyArray() {
		try {
			//data = new int[10];
			data = new int[0];
			Scanner sc = new Scanner(System.in);
			
			//for(int i = 0; i <= data.length; i++) 
			for(int i = 0; i < data.length; i++){
				System.out.printf("%d번째의 데이터를 입력하세요-->", i+1);
				data[i] = sc.nextInt();
			}
		}catch (NegativeArraySizeException e) {
			System.out.println("예외발생: 배열의 크기는 음수가 될 수 없어요.");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생: 배열의 인덱스 범위를 넘었습니다.");
		}catch (NullPointerException e) {
			System.out.println("예외발생: 배열이 생성되지 않았습니다.");
		}
	}
	
	public double getAverage() {
		double avg = 0;
		int tot = 0;
		try {
			//for(int i = 0; i <= data.length; i++)
			for(int i = 0; i < data.length; i++) {
				tot += data[i];
			}
			
			//avg = (double)tot / data.length;
			avg = tot / data.length;
			
		}catch(ArithmeticException e) {
			System.out.println("예외발생: 배열의 데이터가 하나도 없어요.");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생: 배열의 인덱스 범위를 넘었습니다.");
		}catch (NullPointerException e) {
			System.out.println("예외발생: 배열이 생성되지 않았습니다.");
		}
		
		return avg; 
	}
}
