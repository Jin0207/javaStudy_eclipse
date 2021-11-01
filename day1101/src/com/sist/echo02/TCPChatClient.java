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
	
	//��ȭ������ ����� �ؽ�Ʈ����� ��������� ����
	JTextArea jta;
	
	//��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField jtf;
	
	//����½�Ʈ���� ��������� ������
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		//������� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư�� ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� ���
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//�ؽ�Ʈ����� ��ũ���гη� ���Ѵ�
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ ��ƿ�
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� ������ �Ʒ��� ��´�.
		add(p, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		try {
		
			// ����� ���Ͽ� ������ ������ ��û
			Socket socket = new Socket("localhost", 9003);
			
			//������� ���� ��Ʈ�� ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//Runnable�� ������� �����ؾ��� �ٷ�, start�� �� ����
		Thread t = new Thread(this);
		t.start();
		
	}//end ������
	
	public static void main(String[] args) {
		new TCPChatClient();
		
		//main���� �����带 ������ �� �ְ�, �����ڿ��� �����带 ������ �� �ִ�.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ ���������Ѵ�.
			//OutputStream 	write(byte[] b)�޼ҵ� �̿�
			byte[] data = jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� �� ��, ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ �ʵ带 �����.
			jtf.setText("");
			
			//��� ���������ϴϱ� close���� ����
		}catch (Exception ex) {
			System.out.println("���ܹ߻�: " + ex.getMessage());
		}
	}
	
	//�����κ��� ���ŵ� �����͸� ��� �޵��� �մϴ�.
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
