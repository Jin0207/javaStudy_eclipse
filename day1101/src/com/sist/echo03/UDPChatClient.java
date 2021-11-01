package com.sist.echo03;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
public class UDPChatClient extends JFrame implements ActionListener{
	
	JTextArea jta;
	JTextField jtf;
	
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatClient() {
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		JButton btn = new JButton("����");
		
		btn.addActionListener(this);
		
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		JScrollPane jsp = new JScrollPane(jta);
		
		add(jsp,BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
		
			// ����� ���Ͽ� ������ ������ ��û
			socket = new DatagramSocket(9005);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// ������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ���� ����
		class ClientThread extends Thread{
			byte[] data = new byte[100];
			
			public void run() {
				while(true) {
					try {
						InetAddress addr = InetAddress.getByName("localhost");
						// ������ ������ ������ ����
						packet = new DatagramPacket(data, data.length, addr, 9003);
						socket.receive(packet);
						
						// ������ �����͸� ���ڿ��� ����
						String msg = new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰�
						jta.append(msg.trim() + "\n");
						
						Arrays.fill(data, (byte)0);
						
					}catch (Exception e) {
						System.out.println("���ܹ߻�: " + e.getMessage());
					}
				}// end while
			}// end run
		}// end innerClass ClientThread
		
		//�����κ��� ����Ͽ� ���ŵ� �޼����� �ޱ����� ������ ��ü ���� �� ����
		ClientThread ct = new ClientThread();
		ct.start();
		
	}//end ������
	public static void main(String[] args) {
		new UDPChatClient();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			InetAddress addr = InetAddress.getByName("localhost");
			byte[] data = jtf.getText().getBytes();
			packet = new DatagramPacket(data, data.length, addr, 9003);
			socket.send(packet);
			jtf.setText("");
			
			//��� ���������ϴϱ� close���� ����
		}catch (Exception ex) {
			System.out.println("���ܹ߻�: " + ex.getMessage());
		}
	}

}
