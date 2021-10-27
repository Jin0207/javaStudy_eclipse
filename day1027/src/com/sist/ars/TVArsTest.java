package com.sist.ars;


public class TVArsTest {

	public static void main(String[] args) {
		Account account = new Account();
		
		Donor d1 = new Donor("�����", account);
		Donor d2 = new Donor("���a", account);
		Donor d3 = new Donor("�ӻ���", account);
		Donor d4 = new Donor("����2", account);
		Donor d5 = new Donor("����0", account);
		
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch (Exception e) {
		}
		
		System.out.println("��ü��ݾ�: " + account.getBalance());
	}

}
