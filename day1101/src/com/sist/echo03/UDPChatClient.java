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
		
		JButton btn = new JButton("전송");
		
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
		
			// 통신을 위하여 서버에 접속을 요청
			socket = new DatagramSocket(9005);
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// 서버가 보내오는 데이터를 계속하여 받기 위한 쓰레드 클래스 생성
		class ClientThread extends Thread{
			byte[] data = new byte[100];
			
			public void run() {
				while(true) {
					try {
						InetAddress addr = InetAddress.getByName("localhost");
						// 서버가 보내온 데이터 수신
						packet = new DatagramPacket(data, data.length, addr, 9003);
						socket.receive(packet);
						
						// 수신한 데이터를 문자열로 만듦
						String msg = new String(data);
						
						//수신한 문자열을 텍스트에리어에 추가
						jta.append(msg.trim() + "\n");
						
						Arrays.fill(data, (byte)0);
						
					}catch (Exception e) {
						System.out.println("예외발생: " + e.getMessage());
					}
				}// end while
			}// end run
		}// end innerClass ClientThread
		
		//서버로부터 계속하여 수신된 메세지를 받기위한 쓰레드 객체 생성 후 가동
		ClientThread ct = new ClientThread();
		ct.start();
		
	}//end 생성자
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
			
			//계속 내보내야하니깐 close하지 않음
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}
	}

}
