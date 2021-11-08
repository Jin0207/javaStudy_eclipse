package com.sist.book;
/*
 * 	����_ ��������� ���ǻ� �̸��� �Է¹޾�
		�� ���ǻ翡 �Ⱓ�ϴ� ��� ���������� ���
		��, ������ ������ ���������� ���
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchBook {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sql = "select * from book where publisher = ? order by price desc";
		String dirver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "c##madang";
		String passWord ="madang";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(dirver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			
			String keyword = "";
			System.out.println("�˻��� ���ǻ���� �Է��ϼ���: ");
			keyword = sc.next();
			
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			int bookID = 0;
			String bookName = "";
			String publisher = "";
			int price = 0;
			
			while(rs.next()) {
				bookID = rs.getInt(1);
				bookName = rs.getString(2);
				publisher = rs.getString(3);
				price = rs.getInt(4);
				
				System.out.println(bookID + "\t" + bookName + "\t" + publisher + "\t" + price );
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
