package com.sist.pro03;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount account = new BankAccount(80000);
			account.deposit(5000);
			account.withdraw(800);
			account.withdraw(90000);

		}catch(NegativeBalanceException e) {
			//System.out.println("예외발생: " + ne.getMessage());
			e.printStackTrace();
		}
	}
}
/*
 * com.sist.pro03.NegativeBalanceException: 잔액이 부족합니다. 잔액: 84200
	at com.sist.pro03.BankAccount.withdraw(BankAccount.java:31) - 여기서 예외발생
	at com.sist.pro03.BankAccountTest.main(BankAccountTest.java:10)
*/