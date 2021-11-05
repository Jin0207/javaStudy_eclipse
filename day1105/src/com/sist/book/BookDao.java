package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracl:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	
	
	public int deleteBook(int no) {
		int re = -1;
		String sql = "delete book where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}//end delete
}
