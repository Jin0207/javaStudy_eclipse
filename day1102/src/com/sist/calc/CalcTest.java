package com.sist.calc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalcTest extends JFrame implements ActionListener{
	
	// 계산결과를 출력할 텍스트필드를 멤버변수로 만듦
	JTextField result;
	
	//연산을 위한 변수 선언
	int num1;
	int num2;
	String op;
	
	
	public CalcTest() {
		result = new JTextField();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16개의 버튼에 표시될 문자열을 배열에 담음
		String[] data = { "7", "8", "9", "+", 
						  "4", "5", "6", "-", 
						  "1", "2", "3", "*", 
						  "0", "C", "=", "/"
						 };
		
		// 버튼 배열을 선언
		JButton[] btn = new JButton[data.length];
		
		for(int i = 0; i < btn.length; i++ ) {
			btn[i] = new JButton(data[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		add(result, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CalcTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 글자를 읽어온다.
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			//지금화면에 보이고 있는 숫자를 변수(num1)에 저장한다.
			num1 = Integer.parseInt(result.getText());
			
			// 그리고 어떤 연산을 해야할지를 변수(op)에 저장한다.
			op = cmd;
			
			// 그리고 화면을 깨끗하게 지워준다.
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//지금화면에 보이고 있는 숫자를 변수(num2)에 저장
			num2 = Integer.parseInt(result.getText());
			// 그리고 op의 연산자 종류에 따라 num1 과 num2를 연산을 수행한다.
			result.setText("");
			
			int tot = 0;
			
			switch(op) {
				case "+": tot = num1 + num2; break;
				case "-": tot = num1 - num2; break;
				case "*": tot = num1 * num2; break;
				case "/": tot = num1 / num2; break;
			}
			
			// result에 출력한다.
			result.setText(tot + "");
			
		}else if(cmd.equals("C")) {
			//지금화면에 보이고 있는 숫자를 지운다.
			result.setText("");
		}else {
			//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력
			result.setText(result.getText() + cmd);
		}
		
	}// end actionPerformed(ActionEvent e)

}
