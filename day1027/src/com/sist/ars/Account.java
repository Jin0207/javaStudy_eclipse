package com.sist.ars;

public class Account {
	//��ü ��ݾ��� ���� ����
	private int balance;
	
	//�Ա��� �ϴ� �޼ҵ�
	public synchronized void deposit(int amount) {
		balance += amount;
	}
	
	//���� ��ݾ��� ��ȯ�ϴ� �޼ҵ�
	public int getBalance(){
		return balance;
	}
	
}