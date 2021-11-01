package com.sist.net;

import java.net.InetAddress;

public class InetAddressTest2 {

	public static void main(String[] args) {
		
		try {
			InetAddress naver = InetAddress.getByName("www.naver.com");
			
			System.out.println(naver);

		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
