package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	
	public int addBook(BookVo vo) {
		
		String sql = "insert into book values (?,?,?,?)";
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setInt(4, vo.getPrice());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}//end finally
		return re;
	}//end addBook
	
	public int updateBook(BookVo vo) {
		int re = -1;
		String sql = "update book set name=?,publisher=?,price=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPublisher());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getNo());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}//end update()
	
	public ArrayList<BookVo> listBook() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book order by no";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				
				list.add(new BookVo(no, name, publisher, price));
			}
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			} catch (Exception ex) {
				// TODO: handle exception
			}
		}
		return list;
	}//end list()
	
	public int deleteBook(int no) {
		int re = -1;
		String sql = "delete book where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}//end finally
		
		return re;
	}//end delete
}
