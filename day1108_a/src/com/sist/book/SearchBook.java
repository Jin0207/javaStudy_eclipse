package com.sist.book;
/*
 * 	연습_ 사용자한테 출판사 이름을 입력받아
		그 출판사에 출간하는 모든 도서정보를 출력
		단, 도서의 가격이 높은수으로 출력
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
			System.out.println("검색할 출판사명을 입력하세요: ");
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
			System.out.println("예외발생:" + e.getMessage());
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
