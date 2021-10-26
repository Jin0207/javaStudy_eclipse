package com.sist.pro04;
//사용자정의예외: MyDate 객체 생성시 "년/월/일"형태의 문자열을 전달받지못하여 null이 오면 발생시킬 예외
public class IllegalArgumentException extends Exception {
	public IllegalArgumentException(String msg) {
		super(msg);
	}
}
