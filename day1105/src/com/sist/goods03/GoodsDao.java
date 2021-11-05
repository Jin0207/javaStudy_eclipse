package com.sist.goods03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

public class GoodsDao {
	
	//데이터베이스에 접근하여 모든 상품목록을 읽어와서 반환하는 메소드를 정의
	//select * from goods
	// 상품레코드를 하나하나를 GoodsVo로 포장하고
	// 이것들을 모두 ArrayList에 담아서 반환
	public ArrayList<GoodsVo> listGoods(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods order by no";
		
		Connection conn = null;		//DB서버에 연결을 위한 변수
		//Statement stmt = null; 	 	// 데이터베이스 명령을 실행하기 위한 변수
		PreparedStatement pstmt = null;
		ResultSet rs = null;	 	//읽어온 자료를 담기위한 변수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//레코드의 내용을 GoodsVo객체로 만들어 list에 담음
				list.add(new GoodsVo(no, name, qty, price));
				
			}
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			
			try {
				
				//사용했던 자원을 닫아줍니다. 무조건x
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
			}
		}// end finally
		return list;
	}
	
	//수정할 상품번호, 상품이름, 수량, 가격을 매개변수로 전달받아 데이터베이스를 수정하는 메소드 정의
	public int updateGoods( GoodsVo g ) {
		int re = -1;
		//String sql = "update goods set item='" + item + "', qty=" + qty + ", price=" + price + "where no=" +  no;
		String sql = "update goods set item=?,qty=?,price=? where no=?";
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. jdbc드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB 서버에 연결한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			//3. Statement 객체를 생성한다.
			//stmt = conn.createStatement();
			//PreparedStatement 생성시에 ?가 있는 미리 만들어놓은 명령어를 매개변수로 전달해야함
			pstmt = conn.prepareStatement(sql);
			
			//PreparedStatement 객체에 결정되지 않은 ?에 차례대로 값을 설정
			pstmt.setString(1, g.getItem());
			pstmt.setInt(2, g.getQty());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getNo());
			
			//4. 데이터베이스 명령을 실행한다.
			//PreparedStatement 객체 생성시에 이미 sql이 전달되었고
			// 위에서 각각의 ?에 값이 연결된 상태이기 때문에
			//executeUpdate메소드를 호출할 때 sql을 전달하지 않음.
			//만약 여기서 매개변수로 sql을 전달하게 되면, ?값이 정해지지 않은 상태로 명령을 실행함
			re = pstmt.executeUpdate();
			//나머지 일처리를 한다.
			
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
	}
	
	
	public int insertGoods( GoodsVo g ) {
		
		int re = -1;
		String sql = "insert into goods values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. jdbc드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB서버에 연결한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			// 3. 데이터베이스 명령을 실행할 수 있는 Statement 객체생성
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getItem());
			pstmt.setInt(3, g.getQty());
			pstmt.setInt(4, g.getPrice());
			
			// 4. 데이터베이스 명령 실행
			re = pstmt.executeUpdate();
			
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}finally {
			//close() 예외를 안고 있음
			try {
				// 5. 사용했던 자원들을 닫아준다
				if(pstmt != null) pstmt.close();
				
				if(conn != null) conn.close();
				
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}//end finally
		return re;
	}

	//상품번호를 매개변수로 전달받아 데이터베이스에서 삭제를 하는 메소드를 만들어요
	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete goods where no=?";
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
		
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}finally {
			try {
				//사용했던 자원을 닫아줍니다. 무조건x
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
			}//end catch
		}//end finally
		return re;
	}
}
