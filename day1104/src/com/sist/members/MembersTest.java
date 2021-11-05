package com.sist.members;

import javax.swing.JButton;
import java.awt.event.MouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
		
		setSize(500, 800);
		setTitle("회원정보조회");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				int age = Integer.parseInt(jtf_age.getText());
				String phone = jtf_phone.getText();
				System.out.println("전화번호:"+phone);
				insertMember(no, name, addr, age, phone);
			}
		});
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printMembers();
			}
		});
		
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				int age = Integer.parseInt(jtf_age.getText());
				String phone = jtf_phone.getText();
				
				updateMember(no, name, addr, age, phone);
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String addr = jtf_addr.getText();
				int age = Integer.parseInt(jtf_age.getText());
				String phone = jtf_phone.getText();
				
				deleteMember(no, name, addr, age, phone);
			}
		});
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				
				Vector data = rowData.get(index);
				
				jtf_no.setText(data.get(0) + "");
				jtf_name.setText(data.get(1) + "");
				jtf_addr.setText(data.get(2) + "");
				jtf_age.setText(data.get(3) + "");
				jtf_phone.setText(data.get(4)+"");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}// end 생성자
	
	public void deleteMember(int no, String name, String addr, int age, String phone) {
		String sql = "delete members where no=" + no;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("삭제를 완료하였습니다.");
				printMembers();
				jtfClear();
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void updateMember(int no, String name, String addr, int age, String phone) {
		
		String sql = "update members set name='" + name +"', addr='" + addr + "', age=" + age + ", phone=" + phone + "where no="+no;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			
			if(re == 1) {
				System.out.println("수정을 완료하였습니다.");
				printMembers();
				jtfClear();
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}//end finally
		
	}
	
	
	public void printMembers() {
		rowData.clear();
		
		String sql = "select * from members";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet re = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist", "sist");
			stmt = conn.createStatement();
			re = stmt.executeQuery(sql);
			
			while(re.next()) {
				int no = re.getInt(1);
				String name = re.getString(2);
				String addr = re.getString(3);
				int age = re.getInt(4);
				String phone = re.getString(5);
				
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(addr);
				v.add(age);
				v.add(phone);
				
				rowData.add(v);
				table.updateUI();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(re != null) re.close();
			}catch (Exception e) {
				// TODO: handle exception
			}//end catch
		}//end finally
	}
	
	public void insertMember(int no, String name, String addr, int age, String phone) {
		System.out.println("전화번호:" + phone);
		String sql = "insert into members values(" + no + ",'" + name + "','" + addr + "'," + age + ",'" + phone + "')";
		//System.out.println(phone);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist", "sist");
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			
			if(rs == 1) {
				System.out.println("정상 등록하였습니다.");
				jtfClear();
				
				printMembers();
			}else {
				System.out.println("등록 실패하였습니다.");
			}
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			}catch (Exception e) {
			}
			
		}//end finally
	
	}//end addMember()
	
	public void jtfClear() {
		
		jtf_no.setText("");
		jtf_name.setText("");
		jtf_addr.setText("");
		jtf_age.setText("");
		jtf_phone.setText("");

	}
	public static void main(String[] args) {
		new MembersTest();
	}

}
