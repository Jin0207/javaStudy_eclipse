package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
//FlowLayout �����ϱ�
public class FlowLayoutTest extends JFrame {
	
	public FlowLayoutTest() {
		
		//�����ӿ� FlowLayout ����
		setLayout(new FlowLayout());
		
		//�ݺ����� �̿��Ͽ� ��ư 15���� �����Ͽ� �����ӿ� �߰��غ���
		for(int i = 1; i <= 15; i++) {
			add(new JButton("��ư " + i));
		} 
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}

}
