package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalcTest extends JFrame implements ActionListener{
	
	// 두 수를 입력받기 위한, 결과를 출력하기 위한 텍스트필드를 멤버변수로 선언
	JTextField jtf01;
	JTextField jtf02;
	JTextField jtf03;
	
	public CalcTest() {
		// 텍스트필드 객체생성
		// 매개변수의 값은 한번에 보여줄 수 있는 글자의 수
		jtf01 = new JTextField(10);
		jtf02 = new JTextField(10);
		jtf03 = new JTextField(10);
		
		// 프레임의 레이아웃 방식을 FlowLayout으로 설정
		setLayout(new FlowLayout());
		
		// 차례대로 버튼과 라벨을 생성하여 프레임에 담아준다.
		// label은 변수이름을 정해줄 필요가없다, 보여주는 용도이기때문에
		add(new JLabel("수1:"));
		add(jtf01);
		
		add(new JLabel("수2:"));
		add(jtf02);
		
		JButton btnAdd = new JButton("더하기");
		add(btnAdd);
		
		add(new JLabel("결과:"));
		add(jtf03);
		
		setSize(600, 200);
		setVisible(true);
		
		//버튼에 이벤트 등록
		//매개변수로 전달하는 것은, 버튼이 눌러졌을 때, 일처리를 담당하는 객체를 전달
		// CalcTest 자기자신이 이벤트를 담당하는 객체
		btnAdd.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new CalcTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 텍스트 필드 jtf01, jtf02의 값을 먼저 읽어와야한다.
		int num1 = Integer.parseInt(jtf01.getText());
		int num2 = Integer.parseInt(jtf02.getText());
		
		int sum = num1 + num2;
		//jtf03.setText(Integer.toString(sum));
		jtf03.setText(sum + "");
	}

}
