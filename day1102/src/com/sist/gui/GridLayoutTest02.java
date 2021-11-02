package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
public class GridLayoutTest02 extends JFrame {
	
	public GridLayoutTest02() {
		//�������� 5�� 3���� �׸��巹�̾ƿ����� ����
		setLayout(new GridLayout(5,3));
		
		//�������� ĭ�� 15���ε�
		//�ݺ����� �̿��Ͽ� 18���� ��ư�� �����Ͽ� �����ӿ� ���
		for(int i = 1; i <= 18; i++) {
			add(new JButton("��ư" + i));
		}
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new GridLayoutTest02();
	}

}
