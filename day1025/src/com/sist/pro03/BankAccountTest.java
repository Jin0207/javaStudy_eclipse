package com.sist.pro03;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount account = new BankAccount(80000);
			account.deposit(5000);
			account.withdraw(800);
			account.withdraw(90000);

		}catch(NegativeBalanceException ne) {
			System.out.println("예외발생: " + ne.getMessage());
		}
	}

}
