package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class GridLayoutTest03 extends JFrame {
	
	public GridLayoutTest03() {
		//�������� 5�� 3���� �׸��巹�̾ƿ����� ����
		setLayout(new GridLayout(5,3));
		
		//�ݺ����� �̿��Ͽ� 14���� ��ư�� �����Ͽ� �����ӿ� ���
		for(int i = 1; i <= 14; i++) {
			add(new JButton("��ư" + i));
		}
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new GridLayoutTest03();
	}

}
