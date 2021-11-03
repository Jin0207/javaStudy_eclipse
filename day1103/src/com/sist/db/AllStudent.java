package com.sist.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
//��� �л� ����� TextArea�� ���
//������ ȭ�� ������ �����Ӱ�
public class AllStudent {

	public static void main(String[] args) {
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
			
			// ���ڵ尡 �ִ� ��ŭ Ŀ���� �� �྿ �Ű����
			while(rs.next()) {
				String name = rs.getString(1);
				int kor = rs.getInt(2);
				int eng = rs.getInt(3);
				int math = rs.getInt(4);
				
				System.out.println(name + "," + kor + "," + eng + "," + math);
			}
			
			//5. ����ߴ� �ڿ��� �ݾ��ش�
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
