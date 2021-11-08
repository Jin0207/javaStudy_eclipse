package com.sist.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "c##sist";
	private String pwd = "sist";
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ�(�ڷ� �ϳ��ϳ�)�� �߰��ϴ� �޼ҵ� ����
	public int insert( DeptVO d ) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDlo());
			
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ� ����
	public int update( DeptVO d ) {
		int re = -1;
		String sql = "update dept set dname=?,dloc=? where dno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDlo());
			pstmt.setInt(3, d.getDno());
			
			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;	
	}
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �����ϴ� �޼ҵ� ����
	public int delete( int dno ) {
		int re = -1;
		String sql = "delete dept where dno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);

			re = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	
	//�����ͺ��̽� ���̺�(dept)�� ���ڵ带 �о���� �޼ҵ�
	public ArrayList< DeptVO > listAll(){
		ArrayList< DeptVO > list = new ArrayList< DeptVO >();
		String sql = "select * from dept";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//ResultSet�� �о��(�˻���) ��� ���ڵ���� list�� ��´�.
			while(rs.next()) {
				/*
				int don = rs.getInt(1);
				String dname = rs.getString(2);
				String dloc = rs.getString(3);
				
				DeptVO v = new DeptVO(don, dname, dloc);
				list.add(v);
				*/
				
				list.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
	
}
