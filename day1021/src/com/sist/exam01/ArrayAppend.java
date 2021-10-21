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
		// �迭�� �� �ڿ� 50�� �߰��ϰ� ����
		// 1.data�迭 ���������� �����迭�� ���� +1��ŭ �ٽ� �޸𸮸� Ȯ���ؾ���
		// 2.data�迭�� ��Ҹ� ��� ���� Ȯ���� �迭�� �̵���Ų �� �������� 50����
		
		int[] tmp = new int[data.length + 1];
		
		for(int i = 0; i < data.length; i++) {
			tmp[i] = data[i];
		}
		tmp[data.length] = 50;
		data = tmp;
		
		printArray(data);
		
	}

}
