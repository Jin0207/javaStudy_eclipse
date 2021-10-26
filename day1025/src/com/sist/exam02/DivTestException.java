package com.sist.exam02;
//프로그램 실행 시 두개의 정수를 전달받아 나누기 한 결과를 출력하는 프로그램 작성
public class DivTestException {

	public static void main(String[] args) {
			try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a / b;
			System.out.println("결과: " + div);
		}catch(ArithmeticException a) {
			System.out.println("0으로 나눌 수 없어요.");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("나누기할 두개의 수를 입력하세요");
		}catch(NumberFormatException n) {
			System.out.println("정수값을 입력해주세요.");
		}
	}

}
