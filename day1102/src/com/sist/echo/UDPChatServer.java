package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {
	
	//UDP������� �����͸� �ְ� �ޱ����� DatagramSocket�� DatagramPacket�� ��������� ����
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//Ŭ���̾�Ʈ�κ��� ���ŵǴ� �����͸� ������� byte�� �迭�� ��Ŷ ����
			byte[] data = new byte[100];
			//��Ŷ�� �̸� �����ص� �ǰ�, while�� �ȿ��� �����ص� �������
			packet = new DatagramPacket(data, data.length);
			
			// ���Ѵ����·� Ŭ���̾�Ʈ�� ������ �����͸� �״�� �޾Ƹ� �ϵ����Ѵ�.
			while(true) {
				
				//Ŭ���̾�Ʈ�κ��� �����͸� ����
				//�޾ƿ� ��, �������� InetAddress�� ����ִ�.
				//receive()�� �������� InetAddress�� �޾��ش�.
				socket.receive(packet);
				
				// Ŭ���̾�Ʈ�� ������ ������ ���
				String msg = new String(data);
				System.out.println("���ŵ� ������: " + msg.trim());
				
				// ��Ŷ �ȿ� ��� ������ ���� InetAddress Ȯ���غ���
				InetAddress addr = packet.getAddress();
				System.out.println("������ ���� �ּ�: " + addr);
				
				//�� ��Ŷ�� �״�� �޾Ƹ�
				//packet�ȿ� �����͵��հ� �ּҵ� �հ� �� ����ִ�, �׷��� �״�� ������ȴ�.
				socket.send(packet);
				
				// ���� ������ ������ ���� �迭�� ������ ����ش�.
				Arrays.fill(data, (byte)0);
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		new UDPChatServer();
	}

}
