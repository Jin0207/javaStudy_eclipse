package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {
	
	//UDP방식으로 데이터를 주고 받기위한 DatagramSocket과 DatagramPacket을 멤버변수로 선언
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//클라이언트로부터 수신되는 데이터를 담기위한 byte의 배열과 패킷 생성
			byte[] data = new byte[100];
			//패킷을 미리 생성해도 되고, while문 안에서 생성해도 상관없다
			packet = new DatagramPacket(data, data.length);
			
			// 무한대기상태로 클라이언트가 보내온 데이터를 그대로 메아리 하도록한다.
			while(true) {
				
				//클라이언트로부터 데이터를 수신
				//받아올 땐, 보낸측의 InetAddress가 담겨있다.
				//receive()가 보낸측의 InetAddress를 받아준다.
				socket.receive(packet);
				
				// 클라이언트가 보내온 데이터 출력
				String msg = new String(data);
				System.out.println("수신된 데이터: " + msg.trim());
				
				// 패킷 안에 담긴 보내온 측의 InetAddress 확인해보기
				InetAddress addr = packet.getAddress();
				System.out.println("보내온 측의 주소: " + addr);
				
				//그 패킷을 그대로 메아리
				//packet안에 데이터도잇고 주소도 잇고 다 담겨있다, 그래서 그대로 보내면된다.
				socket.send(packet);
				
				// 다음 데이터 수신을 위해 배열을 깨끗이 비워준다.
				Arrays.fill(data, (byte)0);
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		new UDPChatServer();
	}

}
