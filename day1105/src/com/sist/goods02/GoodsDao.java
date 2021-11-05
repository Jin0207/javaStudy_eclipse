package com.sist.goods02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GoodsDao {
	//수정할 상품번호, 상품이름, 수량, 가격을 매개변수로 전달받아 데이터베이스를 수정하는 메소드 정의
		public void updateGoods(int no, String item, int qty, int price) {
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
				pstmt.setString(1, item);
				pstmt.setInt(2, qty);
				pstmt.setInt(3, price);
				pstmt.setInt(4, no);
				
				//4. 데이터베이스 명령을 실행한다.
				//PreparedStatement 객체 생성시에 이미 sql이 전달되었고
				// 위에서 각각의 ?에 값이 연결된 상태이기 때문에
				//executeUpdate메소드를 호출할 때 sql을 전달하지 않음.
				//만약 여기서 매개변수로 sql을 전달하게 되면, ?값이 정해지지 않은 상태로 명령을 실행함
				int re = pstmt.executeUpdate();
				//나머지 일처리를 한다.
				if(re == 1) {
					System.out.println("수정을 완료하였습니다.");
				}else {
					System.out.println("수정을 실패하였습니다.");
				}
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
		}
		
		
		public void insertGoods(int no, String item, int qty, int price) {
			
			//String sql = "insert into goods values("+ no +",'" + item + "'," + qty +"," + price + ")";
			String sql = "insert into goods values(?,?,?,?)";
			// finally 에서도 접근할 수 있도록 Connection 변수와 Statement 변수를 try문 바깥에 선언
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement pstmt = null;
			try {
				// 1. jdbc드라이버를 메모리로 로드한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// 2. DB서버에 연결한다.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				
				// 3. 데이터베이스 명령을 실행할 수 있는 Statement 객체생성
				//stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				pstmt.setString(2, item);
				pstmt.setInt(3, qty);
				pstmt.setInt(4, price);
				
				// 4. 데이터베이스 명령 실행
				int re = pstmt.executeUpdate();
				
				if(re == 1) {
					System.out.println("상품등록에 성공하였습니다.");
					
				}else {
					System.out.println("상품등록에 실패하였습니다.");
				}
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
		}

		//상품번호를 매개변수로 전달받아 데이터베이스에서 삭제를 하는 메소드를 만들어요
		public void deleteGoods(int no) {
			String sql = "delete goods where no=?";
			
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				
				int re = pstmt.executeUpdate();
				if(re == 1) {
					System.out.println("상품을 삭제하였습니다..");
				}else {
					System.out.println("상품 삭제에 실패하였습니다");
				}
				
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
		}
}
