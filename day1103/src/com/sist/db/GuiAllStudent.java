package com.sist.db;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//��� �л� ����� TextArea�� ���
//������ ȭ�� ������ �����Ӱ�
public class GuiAllStudent extends JFrame{
	JTextArea jta;
	JButton btn;
	
	public GuiAllStudent(){
		jta = new JTextArea();
		btn = new JButton("���");
		
		JScrollPane jsp = new JScrollPane(jta);
		
		
		add(btn, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String sql = "select * from student";
				
				//1. jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2, DB������ �����Ѵ�.
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				
				//3. Statement ��ü �����Ѵ�.
				Statement stmt = conn.createStatement();
				
				//4. �����ͺ��̽� ����� �����Ѵ�
				ResultSet rs = stmt.executeQuery(sql);
				
				//��¹�ư�� ������ ������ ��µ� ������ ������
				jta.setText("");
				
				jta.append("�̸�\t����\t����\t����\n");
				// ���ڵ尡 �ִ� ��ŭ Ŀ���� �� �྿ �Ű����
				while(rs.next()) {
					String name = rs.getString(1);
					int kor = rs.getInt(2);
					int eng = rs.getInt(3);
					int math = rs.getInt(4);
					
					String msg = name + "\t" + kor + "\t" + eng + "\t" + math;
					jta.append(msg.trim() + "\n");
				}
				
				//5. ����ߴ� �ڿ��� �ݾ��ش�
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}
		}
	});
		
		setSize(400, 600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GuiAllStudent();
		
	}

}
