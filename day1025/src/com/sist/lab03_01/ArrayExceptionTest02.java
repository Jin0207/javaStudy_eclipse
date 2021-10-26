package com.sist.lab03_01;

public class ArrayExceptionTest02 {

	public static void main(String[] args) {
		try {
			MyArray array = new MyArray();
			System.out.println("배열의 평균: " + array.getAverage());
		}catch (NegativeArraySizeException e) {
			System.out.println("예외발생: 배열의 크기는 음수가 될 수 없어요.");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생: 배열의 인덱스 범위를 넘었습니다.");
		}catch (NullPointerException e) {
			System.out.println("예외발생: 배열이 생성되지 않았습니다.");
		}catch(ArithmeticException e) {
			System.out.println("예외발생: 배열의 데이터가 하나도 없어요.");
		}
	}

}
/*
	ArithmeticException 발생은?
		배열의 크기가 0일 때
	NegativeArraySizeException?
		배열의 크기가 음수일 때
	ArrayIndexOutOfBoundsException?
	 배열의 크기보다 더 많은 인덱스요소를 넣을려고 할때	
	NullPointerException?
	 배열 벼수를 선언하기만 하고 배열을 생성하지않고 사용하려고할 때 - -배열의 크기가 마이너스이거나 배열을 선언만했을때
*/