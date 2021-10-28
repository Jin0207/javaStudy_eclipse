package com.sist.draw03;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		LinePanel dp = new LinePanel();	
		add(dp);

		setTitle("대각선 그리기");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
