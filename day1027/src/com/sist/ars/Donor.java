package com.sist.ars;
//성금자를 위한 클래스를 쓰레드를 상속받아 구현
public class Donor extends Thread {
	private String name;
	//성금자들이 모금액을 공유하기 위하여 멤버변수로 선언
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
			System.out.println(name + "이(가) " + i + "번째 입금하였습니다.");
			try {
				Thread.sleep(200);
			}catch (Exception e) {
			}
		}
	}
	
}
