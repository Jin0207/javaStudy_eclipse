package com.sist.net;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		
		try {
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com"); 
			
			for(InetAddress i : naver) {
				System.out.println(i);
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
