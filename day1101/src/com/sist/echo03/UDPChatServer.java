package com.sist.echo03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class UDPChatServer {

	public static void main(String[] args) {
		//클라이언트로부터 수신된 데이터를 담기 위한 byte의 배열
		byte[] data = new byte[100];
		
		try {
			DatagramSocket socket = new DatagramSocket(9003);
			DatagramPacket packet = new DatagramPacket(data, data.length);

				
			//연결이 된 클라이언트와 계속하여 데이터를 주고 받기 위하여 반복문 사용
			while(true) {
				socket.receive(packet);
				
				String msg = new String(data);
				System.out.println("수신된 데이터: " + msg.trim());
				
				Arrays.fill(data, (byte)0);
			}
				
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
	}

}
