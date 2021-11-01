package com.sist.echo02;

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
public class TCPChatClient extends JFrame implements ActionListener, Runnable{
	
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
			Socket socket = new Socket("localhost", 9003);
			
			//입출력을 위한 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//Runnable은 쓰레드로 포장해야해 바로, start할 수 없어
		Thread t = new Thread(this);
		t.start();
		
	}//end 생성자
	
	public static void main(String[] args) {
		new TCPChatClient();
		
		//main에서 쓰레드를 가동할 수 있고, 생성자에서 쓰레드를 가동할 수 있다.
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
	
	//서버로부터 수신된 데이터를 계속 받도록 합니다.
	@Override
	public void run() {
		
		byte[] data = new byte[100];
		while(true) {
			try {
				is.read(data);
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg + "\n");
				
			}catch (Exception e) {
				
			}// end catch
		}// end while
	}// end run()

}
