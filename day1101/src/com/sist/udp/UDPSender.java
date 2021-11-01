// java UDPSender localhost 안녕

package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		String ip = args[0];
		String msg = args[1];
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			InetAddress addr = InetAddress.getByName(ip);
			byte[] data = msg.getBytes();
			
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 9002);
			socket.send(packet);
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
