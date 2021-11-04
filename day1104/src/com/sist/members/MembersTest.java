package com.sist.members;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.BorderLayout;
//회원번호, 회원이름, 주소, 나이, 전화번호를 관리하기 위한 데이터베이스 테이블을 생성하고
//CURD가 가능한 프로그램을 작성해보자
public class MembersTest extends JFrame{
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_addr;
	JTextField jtf_age;
	JTextField jtf_phone;
	
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	public MembersTest() {
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_addr = new JTextField();
		jtf_age = new JTextField();
		jtf_phone = new JTextField();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 2));
		p.add(new JLabel("회원번호"));
		p.add(jtf_no);
		p.add(new JLabel("회원이름"));
		p.add(jtf_name);
		p.add(new JLabel("주소"));
		p.add(jtf_addr);
		p.add(new JLabel("나이"));
		p.add(jtf_age);
		p.add(new JLabel("전화번호"));
		p.add(jtf_phone);
		
		JButton btn_search =new JButton("조회");
		JButton btn_add =new JButton("추가");
		JButton btn_update =new JButton("수정");
		JButton btn_delete =new JButton("삭제");
		
		JPanel p2 = new JPanel();
		p2.add(btn_search);
		p2.add(btn_add);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);
		
		colNames = new Vector<String>();
		
		colNames.add("회원번호");
		colNames.add("회원이름");
		colNames.add("주소");
		colNames.add("나이");
		colNames.add("전화번호");
		
		rowData = new Vector<Vector>();
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);
		
		setSize(800, 600);
		setTitle("회원정보조회");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MembersTest();
	}

}
