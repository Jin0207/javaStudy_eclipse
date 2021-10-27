package com.sist.game;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		setTitle("My Game");
		add(new MyPanel());
		setSize(700, 700);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}
