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
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ��� ���� byte�� �迭
		byte[] data = new byte[100];
		
		try {
			DatagramSocket socket = new DatagramSocket(9003);
			DatagramPacket packet = new DatagramPacket(data, data.length);

				
			//������ �� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ� �ޱ� ���Ͽ� �ݺ��� ���
			while(true) {
				socket.receive(packet);
				
				String msg = new String(data);
				System.out.println("���ŵ� ������: " + msg.trim());
				
				Arrays.fill(data, (byte)0);
			}
				
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		
	}

}
