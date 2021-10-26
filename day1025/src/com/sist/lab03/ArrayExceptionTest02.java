package com.sist.lab03;

public class ArrayExceptionTest02 {

	public static void main(String[] args) {
		MyArray array = new MyArray();
		System.out.println("배열의 평균: " + array.getAverage());
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