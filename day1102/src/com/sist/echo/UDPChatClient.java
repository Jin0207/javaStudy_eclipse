package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener{
	
	//��ȭ������ ǥ���ϱ� ���� �ؽ�Ʈ����� ��������� ����
	JTextArea jta;
	//��ȭ������ �Է��ϱ� ���� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	//UDP������� �����͸� �ְ� �ޱ����� DatagramSocket�� DatagramPacket�� ��������� ����
	DatagramSocket socket;
	DatagramPacket packet;
		
	public UDPChatClient() {
		//����������� ��ü����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư ����
		JButton btn = new JButton("����");
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ���� �гλ���
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ���� ǥ���ϴ� ��ũ���� ��ü����
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ ��´�.
		add(jsp, BorderLayout.CENTER);
		//�������� �Ʒ��� �ؽ�Ʈ�ʵ�� ��ư�� ����ִ� �г��� ��´�.
		add(p, BorderLayout.SOUTH);
		
		//������ ũ�� ����
		setSize(800, 600);
		//ȭ�鿡 ǥ��
		setVisible(true);
		
		try {
			//�����͸� ���� ��, ������ ��Ʈ��ȣ�� �Է��Ͽ� ���� �Ŷ� ��Ʈ��ȣ ���� ��ü������
			socket = new DatagramSocket();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
		
		// "����" ��ư�� �̺�Ʈ�� ����Ͽ� �ؽ�Ʈ�ʵ忡 �Է��� ������ ������ �����ϵ��� �Ѵ�.
		btn.addActionListener(this);
		
		//�����κ��� �����͸� ����Ͽ� �����ϱ� ���� ������Ŭ������ innerŬ������ ����
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte[] data = new byte[100];
			
			public void run() {
				// �����͸� �����ϱ� ���� ��Ŷ�� ���� ����
				packet = new DatagramPacket(data, data.length);
				
				// ��� �����κ��� �����͸� ����
				while(true) {
					try {
						//�����͸� �����ϱ� ���ؼ�, DatagramSocket�� �ִ� receive
						socket.receive(packet);
						
						//�����κ��� ���ŵ� �����Ͱ� �ִ� �迭�� ������ ���ڿ��� ����
						String msg = new String(data);
						
						//���ŵ� ���ڿ��� �ؽ�Ʈ����� �߰�
						jta.append(msg.trim() + "\n");
						
						// ���������� ������ ���� �迭�� �����
						Arrays.fill(data, (byte)0);
					
					}catch (Exception e) {
						System.out.println("���ܹ߻�: " + e.getMessage());
					}// end catch
				}// end while
			}// end run()
		}// end innerŬ����
		
		// ������ ��ü�� �����ϰ� �����带 ����
		new Thread(new ClientThread()).start();
				
	}// end ������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� ��ȭ������ �ִ� �ؽ�Ʈ�ʵ��� ���ڿ��� ���� �´�.
			String msg = jtf.getText();
			
			//UDP������� �����͸� ��������, ��Ŷ�� �����ؾ��Ѵ�.
			// �׷��� ���ؼ��� ���ڿ��� byte[] �迭�� �����
			byte[] data = msg.getBytes();
			
			// �������� �ּҸ� ���� InetAddress ��ü�� �ʿ� -- ���ܸ� ������ ����
			InetAddress addr = InetAddress.getByName("localhost");
			
			int port = 9005;
			
			// �����͸� ���� ��Ŷ ����
			packet = new DatagramPacket(data, data.length, addr, port);
			
			//������ �����͸� ����
			socket.send(packet);
			
		}catch (Exception ex) {
			System.out.println("���ܹ߻�: " + ex.getMessage());
		}
		
	} // end actionPerformed()
	
	public static void main(String[] args) {
		new UDPChatClient();
	}


}
