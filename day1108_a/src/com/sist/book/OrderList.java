package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterMessageFromOperator;

//��������� ����ȣ�� �Է¹޾� �� ���� �ֹ��� ��� �ֹ������� ����ϴ� ���α׷�

public class OrderList {
	
	static public void printOrderList(int id) {
		String sql = "select * from orders where custid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "madang");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2)+ "\t" + rs.getInt(3)+ "\t" + rs.getInt(4)+ "\t" + rs.getString(5));
				
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����ȣ�� �Է��ϼ���: ");
		int search = sc.nextInt();
		printOrderList(search);
	}

}
