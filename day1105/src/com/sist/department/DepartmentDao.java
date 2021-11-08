package com.sist.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	public ArrayList< DepartmentVo > listDepartment(){
		ArrayList<DepartmentVo> list = new ArrayList<DepartmentVo>();
		String sql = "select * from departments";
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
				String location = rs.getString(3);
				
				list.add(new DepartmentVo(no,name,location));
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}//end list;
	
	public int addDepartment( DepartmentVo vo ) {
		int re = -1;
		String sql = "insert into departments values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC 서버를 메모리에 로드
			Class.forName(driver);
			// 2. Db서버에 연결
			conn = DriverManager.getConnection(url, user, pwd);
			// 3. sql 명령어를 전달할 객체생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getLocation());
			// 4. 데이터베이스 명령 실행
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
		}
		return re;
	}//end add();
	
	public int deleteDepartment( int no ) {
		int re = -1;
		String sql = "delete departments where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
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
		}
		return re;
	}//end delete
	
	public int updateDepartment( DepartmentVo vo ) {
		int re = -1;
		String sql = "update departments set name=?, location=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getLocation());
			pstmt.setInt(3, vo.getNo());
			
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
		}
		return re;
	}//end update
	
}
