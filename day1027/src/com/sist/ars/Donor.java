package com.sist.ars;
//�����ڸ� ���� Ŭ������ �����带 ��ӹ޾� ����
public class Donor extends Thread {
	private String name;
	//�����ڵ��� ��ݾ��� �����ϱ� ���Ͽ� ��������� ����
	private Account account;
	
	public Donor(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	public void run() {
		for(int i = 1; ; i++) {
			
			if(account.getBalance() >= 100000) {
				break;
			}
			
			account.deposit(1000);
			System.out.println(name + "��(��) " + i + "��° �Ա��Ͽ����ϴ�.");
			try {
				Thread.sleep(200);
			}catch (Exception e) {
			}
		}
	}
	
}
