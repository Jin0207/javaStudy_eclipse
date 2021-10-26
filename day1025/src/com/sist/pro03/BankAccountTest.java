package com.sist.pro03;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount account = new BankAccount(80000);
			account.deposit(5000);
			account.withdraw(800);
			account.withdraw(90000);

		}catch(NegativeBalanceException e) {
			//System.out.println("���ܹ߻�: " + ne.getMessage());
			e.printStackTrace();
		}
	}
}
/*
 * com.sist.pro03.NegativeBalanceException: �ܾ��� �����մϴ�. �ܾ�: 84200
	at com.sist.pro03.BankAccount.withdraw(BankAccount.java:31) - ���⼭ ���ܹ߻�
	at com.sist.pro03.BankAccountTest.main(BankAccountTest.java:10)
*/