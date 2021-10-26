package com.sist.exam02;

public class ThrowTest {
	public static void main(String[] args) {
		//예외상황이 되면 자동으로 예외 객체가 생성됨
		//int a = 4 / 0;
		
		//강제로 예외 발생시키기
		throw new ArithmeticException();
	}
}
