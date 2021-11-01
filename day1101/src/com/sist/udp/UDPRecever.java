package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPRecever {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			byte[] data = new byte[100];
			
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			while(true) {
				socket.receive(packet);
				
				String msg = new String(data);
				System.out.println(data);
				System.out.println("수신된 데이터: " + msg);
				
				Arrays.fill(data, (byte)0);
				
				socket.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
