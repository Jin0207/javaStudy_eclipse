package com.sist.draw02;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		DiagonalPanel dp = new DiagonalPanel();	
		add(dp);

		setTitle("�밢�� �׸���");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
