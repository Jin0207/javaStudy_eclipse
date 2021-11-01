package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;

public class URLTestFrame extends JFrame implements ActionListener{
	JTextField jtf;
	JTextArea jta;
	
	public URLTestFrame() {
		
		jtf = new JTextField(50);
		JButton btn = new JButton("읽어오기");
		JPanel p = new JPanel();
		
		p.add(jtf);
		p.add(btn);
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btn.addActionListener(this);
		
		setSize(800, 600);
		setTitle("페이지소스코드읽어오기");
		setVisible(true);
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			URL url = new URL(jtf.getText());
			
			InputStream is = url.openStream();
			
			byte[] data = new byte[100];
			String str = "";
			
			while(is.read(data) != -1) {
				str += new String(data, "utf-8");
				
				Arrays.fill(data, (byte)0);
			}
			
			jta.setText(str);
			
			is.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new URLTestFrame();
	}


}
