package com.sist.pro03;

public class BankAccount {
	private int balance;

	public BankAccount() {
		super();
	}

	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int money) {
		balance += money;
		System.out.printf("%d���� �Ա��Ͽ����ϴ�.%n �ܾ�: %d��%n",money, balance);
	}
	
	public void withdraw(int money) throws NegativeBalanceException{
		
		if(money > balance) {
			throw new NegativeBalanceException("�ܾ��� �����մϴ�. �ܾ�: " + balance);
		}
		balance -= money;
		System.out.printf("%d���� �����Ͽ����ϴ�.%n�ܾ�: %d��%n", money, balance);
		
	}
	
}
