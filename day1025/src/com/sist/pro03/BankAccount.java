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
		System.out.printf("%d원을 입금하였습니다.%n 잔액: %d원%n",money, balance);
	}
	
	public void withdraw(int money) throws NegativeBalanceException{
		
		if(money > balance) {
			throw new NegativeBalanceException("잔액이 부족합니다. 잔액: " + balance);
		}
		balance -= money;
		System.out.printf("%d원을 인출하였습니다.%n잔액: %d원%n", money, balance);
		
	}
	
}
