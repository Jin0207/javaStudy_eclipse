package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersDAO {
	//DriverŬ���� �̸�
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	//������ DB������ �ּ�
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//DB�� ������ ������̸�
	String userName = "c##madang";
	String passWord = "madang";
	
	//����ȣ�� �Ű������� ���޹޾� �� ���� ��� �ֹ������� ArrayList�� ��ȯ�ϴ� �޼ҵ� ����
	public ArrayList<OrdersVO> searchOrders(int custid){
		
		ArrayList<OrdersVO> list = new ArrayList<OrdersVO>();
		String sql = "select * from orders where custid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		//�˻��� ����� ���� ����
		ResultSet rs = null;
		
		try {
			// driver�� �޸𸮿� �ε�
			Class.forName(driver);
			// DB������ �������� Connection ��ü ����
			conn = DriverManager.getConnection(url, userName, passWord);
			//�����ͺ��̽������ ��������ִ� ����������� �ִ� ��ü ����
			pstmt = conn.prepareStatement(sql);
			// ? �� �����ϰ����ϴ� ���� ����
			//   ?�� ��ġ, ������ ��
			pstmt.setInt(1, custid);
			//���ڵ��� ����� ����Ű�� �ִ�. --> rowNames
			rs = pstmt.executeQuery();
			//���ڵ��� Ŀ���� ���྿ ������ ����Ű���ִ�
			while(rs.next()) {
				//���� Ŀ���� ����Ű���ִ� �� �÷��� ������ �����ͼ� OrdersVO�� �����ؼ� ArrayList�� �߰������ش�
				list.add(new OrdersVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5)));
			}
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}finally {
			try {
				//���࿡ ������ �߻��ϸ� rs�� ������ �� ���⶧���� ������ ������ ���� ���� ������
				// null�� �ƴ϶�� �ݾ��ش�.
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		
		return list;
	}
}
