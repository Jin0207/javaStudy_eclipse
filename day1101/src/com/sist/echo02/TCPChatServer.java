package com.sist.echo02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatServer {

	public static void main(String[] args) {
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ��� ���� byte�� �迭
		byte[] data = new byte[100];
		
		try {
			// 1. SeverSocket�� ���� ���� ����
			ServerSocket server = new ServerSocket(9003);
			
			//���Ѵ����·� Ŭ���̾�Ʈ�� ���� ��ٸ�
			while(true) {
				//Ŭ���̾�Ʈ�� ��û ����
				Socket socket = server.accept();
				
				//���ϰ�ü�� ���ؼ� �����͸� �ְ���� ��Ʈ�� ����
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				//������ �� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ� �ޱ� ���Ͽ� �ݺ��� ���
				while(true) {
					//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�.
					//	read(byte[] b)
					is.read(data);
					String msg = new String(data);
					System.out.println("���ŵ� ������: " + msg.trim());
					
					//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�.
					os.write(data);
					
					//������ ���ŵ� �����͸� ���Ͽ� �迭�� ����ش�
					Arrays.fill(data,  (byte)0);
				}
				
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		
	}

}
