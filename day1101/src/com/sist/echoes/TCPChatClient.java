package com.sist.echoes;

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
	
	JTextArea jta;
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	public TCPChatClient() {
		
		jta = new JTextArea();
		jtf = new JTextField(50);
		
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
			Socket socket = new Socket("localhost", 9008);
			Socket socket2 = new Socket("localhost", 9009);
			
			//������� ���� ��Ʈ�� ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
			is = socket2.getInputStream();
			os = socket2.getOutputStream();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		// ������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ���� ����
		class ClientThread extends Thread{
			byte[] data = new byte[100];
			
			public void run() {
				while(true) {
					try {
						// ������ ������ ������ ����
						is.read(data);
						
						// ������ �����͸� ���ڿ��� ����
						String msg = new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰�
						jta.append(msg.trim() + "\n");
						
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
		new TCPChatClient();
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

}
