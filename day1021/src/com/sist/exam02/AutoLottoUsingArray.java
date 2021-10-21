/*
 * 배열 : 중복제거를 위해서 내가 프로그램해야함
 * set : 중복을 허용하지 않으니 따로 중복제거를위한 프로그램작성안해도됨
 * 로또: 1~45까지 6개의 숫자를 뽑음(중복x)
 */
package com.sist.exam02;

import java.util.Random;

public class AutoLottoUsingArray {
	
	public static void printArray(int[] data) {
		for(int n : data) {
			System.out.print(n + "\t");
		}
		System.out.println();
	}
	
	public static boolean isAlready(int value, int last, int[] arr) {
		boolean flag = false;
		for(int i = 0; i <= last; i++) {
			if(arr[i] == value) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static void sortArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] n = new int[6];
		Random r = new Random();
		/*
		for(int i = 0; i < n.length; i++) {
			n[i] = r.nextInt(); //정수의 표현범위 안의 난수값
		}
		printArray(n);
		*/
		for(int i = 0; i < n.length;) {
			int tmp = r.nextInt(45) + 1; //1~45
			if(!isAlready(tmp, i, n)) {
				n[i] = tmp; 
				i++;
			}
		}
		sortArray(n);
		printArray(n);
	}

}
