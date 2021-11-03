package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ��ư�� ���� �̺�Ʈ ó���� ���ؼ��� ACtionListener �������̽��� �����ؾ��Ѵ�.
// ����, MyFrame�ڽ��� ActionListener �������̽��� �����ϰԵǸ�,
// �ϳ��� actionPerformed�޼ҵ忡�� ��� ��ư�� �̺�Ʈó���� �ؾ��Ѵ�.
// ������ ����(����) ���������� �Ǵ��ؾ��ϱ⿡ ��ư�� ������ �Ǵ��ϴ� if�� ������ �� �� �ִ�.
// �׷��� ��ư�ϳ��� ��ó�� ��簴ü�� �̸����� inner Ŭ������ ����� ó���Ѵ�.
public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		JButton btn01 = new JButton("����");
		JButton btn02 = new JButton("����");
		
		setLayout(new FlowLayout());
		
		add(btn01);
		add(btn02);
		
		//btn-1.addActionListener(this); �� this�� ActionListener �������̽��� ������ ��簴ü������
		
		btn01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����Դϴ�.");
			}
		});
		
		btn02.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����Դϴ�.");
			}
		});
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
