package com.sist.exam02;

public class ThrowsTest {
	
	public static void div(int a, int b) throws ArithmeticException {
		int r = a / b;
		System.out.println("������ ���: " + r);
	}
	
	public static void main(String[] args) {
		try {
			div(4,0); //�޼��带 ȣ���ߴµ� ���ܰ� �߻��߳�? ���� ����ó���ؾ���
		}catch(ArithmeticException a) {
			System.out.println("0���� ���� �� �����");
		}
	}
}
