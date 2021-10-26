package com.sist.pro03;
//인출금액이 잔액보다 부족한 경우 발생시키기 위한 사용자정의예외

public class NegativeBalanceException extends Exception {
	public NegativeBalanceException(String msg) {
		super(msg);
	}
}
