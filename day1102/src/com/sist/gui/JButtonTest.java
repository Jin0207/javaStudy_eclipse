package com.sist.gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {
	
	public JButtonTest(){
		
	}

	public static void main(String[] args) {
		
		//�츮�� ���� JButtonTest�� �� JFrame
		// JButtonTest�� JFrame�� ��ӹ޾ұ� ������
		// �Ʒ� �ڵ�� â�� �����Ͽ����� â�� ������ �������� ����
		// ���� â�� ���̰� �Ϸ���, â�� ����, ���� ���̸� ������ ȭ�鿡 ���̵��� �����ؾ��Ѵ�.
		JButtonTest f = new JButtonTest();
		
		// �ؿ� �ڵ带 �Է��ؼ� â�� ���μ��θ� �����ְ�
		// â�̺��̵��� �������ش�.
		f.setSize(400, 300);
		f.setVisible(true);
		
		//â�� �ݾ��� ��, ���α׷��� ���� ����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
