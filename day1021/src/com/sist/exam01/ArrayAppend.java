package com.sist.exam01;

public class ArrayAppend {
	
	public static void printArray(int[] data) {
		for(int n:data) {
			System.out.printf("%5d", n);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] data = {10, 20, 30, 40};
		
		printArray(data);
		// 배열의 맨 뒤에 50을 추가하고 싶음
		// 1.data배열 참조변수가 원래배열의 길이 +1만큼 다시 메모리를 확보해야함
		// 2.data배열의 요소를 모두 새로 확보한 배열로 이동시킨 후 마지막에 50대입
		
		int[] tmp = new int[data.length + 1];
		
		for(int i = 0; i < data.length; i++) {
			tmp[i] = data[i];
		}
		tmp[data.length] = 50;
		data = tmp;
		
		printArray(data);
		
	}

}
