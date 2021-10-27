package com.sist.ars;


public class TVArsTest {

	public static void main(String[] args) {
		Account account = new Account();
		
		Donor d1 = new Donor("±è¼ö¿æ", account);
		Donor d2 = new Donor("±è½Ãa", account);
		Donor d3 = new Donor("ÀÓ»óÀÌ", account);
		Donor d4 = new Donor("À±ÅÂ2", account);
		Donor d5 = new Donor("Á¤ÀÚ0", account);
		
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
		
		System.out.println("ÀüÃ¼¸ð±Ý¾×: " + account.getBalance());
	}

}
