package com.sist.chat;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class TCPChatClient extends JFrame implements ActionListener{
	
	//대화내용을 출력할 텍스트에리어를 멤버변수로 만듦
	JTextArea jta;
	
	//대화내용을 입력할 텍스트필드를 멤버변수로 만듦
	JTextField jtf;
	
	//입출력스트림을 멤버변수로 만ㄷ듦
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//멤버변수 텍스트에리어와 텍스트필드를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼을 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트를 등록
		btn.addActionListener(this);
		
		//텍스트필드와 버튼을 담기위한 패널을 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//텍스트에리어를 스크롤패널로 감싼다
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 텍스트에리어를 감싸고 있는 스크롤팬을 담아요
		add(jsp,BorderLayout.CENTER);
		
		//텍스트필드와 버튼을 담고 있는 패널을 프레임 아래에 담는다.
		add(p, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
		
			// 통신을 위하여 서버에 접속을 요청
			Socket socket = new Socket("localhost", 9007);
			
			//입출력을 위한 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

		
		// inner 클래스를 만들 땐 위에처럼 클래스이름을 정식으로 정해주고 만들 수 도 있지만
		// 대부분의 경우 클래스 이름을 안 정해주고 이름없는 클래스를 정의하면서 바로 객체를 생성한다.
		// new 인터페이스이름(){ 오버라이딩할 메소드(){} } 
		// 인터페이스를 구현한 클래스를 정의하자마자 객체를 생성해라라는 의미
		
		//new Thread(new ClientThread()).start();
		new Thread(new Runnable() {
			
			byte[] data = new byte[100];
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						// 서버가 보내온 데이터 수신
						is.read(data);
						
						// 수신한 데이터를 문자열로 만듦
						String msg = new String(data);
						
						//수신한 문자열을 텍스트에리어에 추가
						jta.append(msg.trim() + "\n");
						
					}catch (Exception e) {
						System.out.println("예외발생: " + e.getMessage());
					}
				}// end while
				
			}// end run()
		}).start();
		
	}//end 생성자
	public static void main(String[] args) {
		new TCPChatClient();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 텍스트필드의 내용을 서버로 보내도록한다.
			//OutputStream 	write(byte[] b)메소드 이용
			byte[] data = jtf.getText().getBytes();
			os.write(data);
			
			//메세지를 전송하고 난 후, 다음 메세지 입력을 위하여 텍스트 필드를 지운다.
			jtf.setText("");
			
			//계속 내보내야하니깐 close하지 않음
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}
	}

}
