package com.sist.gui;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02(){
		//��ư�� �����Ͽ� â �ȿ� ��ư�� �߰�
		JButton btn01 = new JButton("��ư1");
		JButton btn02 = new JButton("��ư2");
		
		add(btn01);
		add(btn02);
		
		// �����ÿ� �ڵ����� �����ϵ��� ��
		// ��ü�� �������ָ� �ڵ����� â�� ����� �����ְ�, â�� �����ִ� 
		// �����̸��� ���� �� �ʿ� ���� ��ü������ �ص� �ȴ�.
		setSize(400, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		new JButtonTest02();
		
	}

}
