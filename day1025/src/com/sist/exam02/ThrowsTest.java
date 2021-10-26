package com.sist.exam02;

public class ThrowsTest {
	
	public static void div(int a, int b) throws ArithmeticException {
		int r = a / b;
		System.out.println("나누기 결과: " + r);
	}
	
	public static void main(String[] args) {
		try {
			div(4,0); //메서드를 호출했는데 예외가 발생했네? 내가 예외처리해야지
		}catch(ArithmeticException a) {
			System.out.println("0으로 나눌 수 없어요");
		}
	}
}
