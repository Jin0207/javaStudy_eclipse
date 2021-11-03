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
//모든 학생 목록을 TextArea에 출력
//나머지 화면 구성은 자유롭게
public class GuiAllStudent extends JFrame{
	JTextArea jta;
	JButton btn;
	
	public GuiAllStudent(){
		jta = new JTextArea();
		btn = new JButton("출력");
		
		JScrollPane jsp = new JScrollPane(jta);
		
		
		add(btn, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		btn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String sql = "select * from student";
				
				//1. jdbc 드라이버를 메모리로 로드한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2, DB서버에 연결한다.
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				
				//3. Statement 객체 생성한다.
				Statement stmt = conn.createStatement();
				
				//4. 데이터베이스 명령을 실행한다
				ResultSet rs = stmt.executeQuery(sql);
				
				//출력버튼이 누르면 기존에 출력된 내용을 지워줌
				jta.setText("");
				
				jta.append("이름\t국어\t영어\t수학\n");
				// 레코드가 있는 만큼 커서를 한 행씩 옮겨줘요
				while(rs.next()) {
					String name = rs.getString(1);
					int kor = rs.getInt(2);
					int eng = rs.getInt(3);
					int math = rs.getInt(4);
					
					String msg = name + "\t" + kor + "\t" + eng + "\t" + math;
					jta.append(msg.trim() + "\n");
				}
				
				//5. 사용했던 자원을 닫아준다
				rs.close();
				stmt.close();
				conn.close();
				
			}catch(Exception ex) {
				System.out.println("예외발생: " + ex.getMessage());
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
