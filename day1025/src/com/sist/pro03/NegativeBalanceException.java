package com.sist.pro03;
//����ݾ��� �ܾ׺��� ������ ��� �߻���Ű�� ���� ��������ǿ���

public class NegativeBalanceException extends Exception {
	public NegativeBalanceException(String msg) {
		super(msg);
	}
}
