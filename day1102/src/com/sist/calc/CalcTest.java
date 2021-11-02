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
	
	// ������� ����� �ؽ�Ʈ�ʵ带 ��������� ����
	JTextField result;
	
	//������ ���� ���� ����
	int num1;
	int num2;
	String op;
	
	
	public CalcTest() {
		result = new JTextField();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		//16���� ��ư�� ǥ�õ� ���ڿ��� �迭�� ����
		String[] data = { "7", "8", "9", "+", 
						  "4", "5", "6", "-", 
						  "1", "2", "3", "*", 
						  "0", "C", "=", "/"
						 };
		
		// ��ư �迭�� ����
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
		//������ ��ư�� ���ڸ� �о�´�.
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num1)�� �����Ѵ�.
			num1 = Integer.parseInt(result.getText());
			
			// �׸��� � ������ �ؾ������� ����(op)�� �����Ѵ�.
			op = cmd;
			
			// �׸��� ȭ���� �����ϰ� �����ش�.
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num2)�� ����
			num2 = Integer.parseInt(result.getText());
			// �׸��� op�� ������ ������ ���� num1 �� num2�� ������ �����Ѵ�.
			result.setText("");
			
			int tot = 0;
			
			switch(op) {
				case "+": tot = num1 + num2; break;
				case "-": tot = num1 - num2; break;
				case "*": tot = num1 * num2; break;
				case "/": tot = num1 / num2; break;
			}
			
			// result�� ����Ѵ�.
			result.setText(tot + "");
			
		}else if(cmd.equals("C")) {
			//����ȭ�鿡 ���̰� �ִ� ���ڸ� �����.
			result.setText("");
		}else {
			//������ ��ư�� ���ڸ� �ؽ�Ʈ�ʵ忡 ��� �����Ͽ� ���
			result.setText(result.getText() + cmd);
		}
		
	}// end actionPerformed(ActionEvent e)

}
