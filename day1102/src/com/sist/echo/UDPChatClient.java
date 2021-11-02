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
	
	//대화내용을 표시하기 위한 텍스트에리어를 멤버변수로 선언
	JTextArea jta;
	//대화내용을 입력하기 위한 텍스트필드를 멤버변수로 선언
	JTextField jtf;
	
	//UDP방식으로 데이터를 주고 받기위한 DatagramSocket과 DatagramPacket을 멤버변수로 선언
	DatagramSocket socket;
	DatagramPacket packet;
		
	public UDPChatClient() {
		//멤버변수들의 객체생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//텍스트필드와 버튼을 담을 패널생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어에 스크롤을 표현하는 스크롤팬 객체생성
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에리어를 감싸고 있는 스크롤펜을 담는다.
		add(jsp, BorderLayout.CENTER);
		//프레임의 아래에 텍스트필드와 버튼을 담고있는 패널을 담는다.
		add(p, BorderLayout.SOUTH);
		
		//프레임 크기 설정
		setSize(800, 600);
		//화면에 표시
		setVisible(true);
		
		try {
			//데이터를 보낼 때, 서버의 포트번호를 입력하여 보낼 거라 포트번호 없이 객체생성함
			socket = new DatagramSocket();
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
		// "전송" 버튼에 이벤트를 등록하여 텍스트필드에 입력한 내용을 서버로 전송하도록 한다.
		btn.addActionListener(this);
		
		//서버로부터 데이터를 계속하여 수신하기 위한 쓰레드클래스를 inner클래스로 만듦
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte[] data = new byte[100];
			
			public void run() {
				// 데이터를 수신하기 위한 패킷을 따로 생성
				packet = new DatagramPacket(data, data.length);
				
				// 계속 서버로부터 데이터를 수신
				while(true) {
					try {
						//데이터를 수신하기 위해서, DatagramSocket에 있는 receive
						socket.receive(packet);
						
						//서버로부터 수신된 데이터가 있는 배열의 내용을 문자열로 만듦
						String msg = new String(data);
						
						//수신된 문자열을 텍스트에리어에 추가
						jta.append(msg.trim() + "\n");
						
						// 다음데이터 수신을 위해 배열을 비워줌
						Arrays.fill(data, (byte)0);
					
					}catch (Exception e) {
						System.out.println("예외발생: " + e.getMessage());
					}// end catch
				}// end while
			}// end run()
		}// end inner클래스
		
		// 쓰레드 객체를 생성하고 쓰레드를 가동
		new Thread(new ClientThread()).start();
				
	}// end 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 대화내용이 있는 텍스트필드의 문자열을 갖고 온다.
			String msg = jtf.getText();
			
			//UDP방식으로 데이터를 보낼려면, 패킷을 생성해야한다.
			// 그러기 위해서는 문자열을 byte[] 배열로 만든다
			byte[] data = msg.getBytes();
			
			// 목적지의 주소를 갖는 InetAddress 객체가 필요 -- 예외를 가지고 있음
			InetAddress addr = InetAddress.getByName("localhost");
			
			int port = 9005;
			
			// 데이터를 보낼 패킷 생성
			packet = new DatagramPacket(data, data.length, addr, port);
			
			//서버로 데이터를 전송
			socket.send(packet);
			
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}
		
	} // end actionPerformed()
	
	public static void main(String[] args) {
		new UDPChatClient();
	}


}
