package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterMessageFromOperator;

//사용자한테 고객번호를 입력받아 그 고객이 주문한 모든 주문내역을 출력하는 프로그램

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
			System.out.println("예외발생:" + e.getMessage());
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
		System.out.println("고객번호를 입력하세요: ");
		int search = sc.nextInt();
		printOrderList(search);
	}

}
