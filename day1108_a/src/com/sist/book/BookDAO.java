package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	String dirver = "oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "c##madang";
	String passWord ="madang";
	
	//���ǻ���� �Ű������� ���޹޾� �ش� ���ǻ��� ��� ��������� �˻��Ͽ� ArrayList�� ��ȯ�ϴ� �޼ҵ�
	public ArrayList<BookVO> searchBook(String keyword){
		
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where publisher=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(dirver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				
				BookVO v = new BookVO(bookid, bookname, publisher, price);
				
				list.add(v);
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
}
