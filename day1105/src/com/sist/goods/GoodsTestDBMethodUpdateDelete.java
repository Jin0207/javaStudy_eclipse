package com.sist.goods;
//JTable을 추가하여 상품목록이 보이도록 구현해보자

import javax.swing.JButton;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class GoodsTestDBMethodUpdateDelete extends JFrame {
	
	JTextField jtf_no;		//상품번호를 입력받기 위한 입력상자
	JTextField jtf_item;	//상품명을 입력받기 위한 입력상자
	JTextField jtf_qty;		//수량을 입력받기 위한 입력상자
	JTextField jtf_price;	//가격을 입력받기 위한 입력상자
	
	JTable table; 			//모든 상품목록을 엑셀과 같은 모양으로 보여주기 위한 테이블 선언
	Vector colNames; //테이블의 칼럼이름을 위한 벡터선언
	Vector<Vector> rowData;  //테이블의 데이터를 위한 벡터를 선언
	
	public GoodsTestDBMethodUpdateDelete() {
		
		//테이블에 들어갈 칼럼이름을 위한 벡터를 생성하고 자료를 추가
		colNames = new Vector<String>();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("수량");
		colNames.add("단가");
		
		//테이블에 들어갈 실제데이터를 담기위한 벡터를 생성하고 자료를 추가
		rowData = new Vector<Vector>();
		
		// 컬럼이름이 있는 colNames 벡터와 실제 데이터가 있는 rowData 벡터를 갖고 테이블 생성(엑셀과 같은 화면을 보여줌)
		table = new JTable(rowData, colNames);
		
		//테이블에 자료가 너무 많아, 한 화면에서 보이지 않을 때에 자동으로 스크롤을 만들어주는 JScrollPane
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();
		
		//입력상자들과 무엇을 입력해야하는 지 설명하는 라벨들을 담기 위한 패널 생성
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 2));
		
		//라벨과 입력상자들을 패널에 차례로 담아요
		p.add(new JLabel("상품번호:"));
		p.add(jtf_no);
		p.add(new JLabel("상품이름:"));
		p.add(jtf_item);
		p.add(new JLabel("상품수량:"));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가:"));
		p.add(jtf_price);
		
		// "추가" 글씨가 쓰여진 버튼을 만들어요
		JButton btn_add = new JButton("추가");
		
		// "목록" 글씨가 쓰여진 버튼을 만들어요
		JButton btn_list = new JButton("목록");
		
		// "목록" 글씨가 쓰여진 버튼을 만들어요
		JButton btn_update = new JButton("수정");
		
		// "목록" 글씨가 쓰여진 버튼을 만들어요
		JButton btn_delete = new JButton("삭제");
		
		// 버튼들을 담는 JPanel
		//패널의 기본은 FlowLayout
		JPanel p2 = new JPanel();
		
		p2.add(btn_add);
		p2.add(btn_list);
		p2.add(btn_update);
		p2.add(btn_delete);
		
		// 입력상자들의 패널과 버튼들의 패널을 담기위한 JPanel
		JPanel p_center = new JPanel();
		
		p_center.setLayout(new BorderLayout());
		
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);
		
		//프레임의 가운데에 입력상자와 버튼을 담고있는 p_center패널을 담음
		add(p_center, BorderLayout.CENTER);
		
		//테이블을 담고있는 ScrollPane을 프레임의 아래쪽에 담아요
		add(jsp, BorderLayout.SOUTH);
		
		//프레임의 가로,세로 길이 설정, 화면에 보여주도록 설정
		setSize(800, 600);
		setVisible(true);
		
		//창을 닫으면 프로그램도 종료하도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//"수정" 버튼을 누르면 수정할 상품의 정보들을 텍스트필드로 가지고 옴
		//그것을 메소드에게 전달하여 수정하도록
		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				updateGoods(no, item, qty, price);
			}
		});
		
		//"삭제" 버튼을 누르면 텍스트필드의 상품번호를 갖고와서, 삭제를하는메소드호출
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				deleteGoods(no);
			}
		});
		
		//"목록" 버튼을 누르면
		//데이터베이스 연결하여 모든 상품목록을 읽어와서 테이블에 출력하는 메소드를 호출
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printGoods();
			}
			
		});
		
		//추가버튼을 누르면 사용자가 입력한 상품번호, 상품이름, 상품수량, 상품가격으로 
		//데이터테이블에 자료를 추가하도록 한다.
		btn_add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				insertGoods(no, item, qty, price);
				
			}//end actionPerformed
		});
		
		//테이블에 마우스 이벤트 등록하여 선택한 행의 상품정보를
		// 각각의 입력상자에 출력
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				
				//rowData의 index번째의 벡터를 꺼집어내어온다.
				Vector data = rowData.get(index);
				
				//그 벡터의 요소를 차례로 입력상자에 출력한다.
				jtf_no.setText(data.get(0) + "");
				jtf_item.setText(data.get(1) + "");
				jtf_qty.setText(data.get(2) + "");
				jtf_price.setText(data.get(3) + "");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});

	}//end 생성자
	
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
				printGoods();
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
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");
				
				//상품등록을 성공하면 테이블의 내용을 다시 읽어오도록 메소드를 호출합니다.
				printGoods();
				
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
	
	//데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서(검색하여, 조회하여)
	// JTable에 출력하는 메소드
	public void printGoods() {
		//새로운 상품을 등록하여 계속하여 호출도리 수 있으니,
		//rowData를 먼저 깨끗이 비워준다.
		rowData.clear();
		
		//데이터베이스에 연결하여 실행할 명령어
		String sql = "select * from goods order by no";
		
		//데이터베이스 연결과 필요한 변수들 선언
		Connection conn = null;		//DB서버에 연결을 위한 변수
		//Statement stmt = null; 	 	// 데이터베이스 명령을 실행하기 위한 변수
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;	 	//읽어온 자료를 담기위한 변수
		
		try {
			//1. jdbc드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db서버에 연결한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			//3. statement객체를 생성한다.
			pstmt = conn.prepareStatement(sql);
			
			//4. 데이터베이스 명령을 실행한다.
			// 사용하는 메소드 두가지 
			//executeUpdate : 자료를 추가, 수정, 삭제하고 int를 반환 
			//executeQuery : 자료를 읽어와서 ResultSet으로 반환
			rs = pstmt.executeQuery();
			
			//5. 일처리를 한다.
			// 검색한 자료가 있는 만큼 반복실행하여 한 행씩 읽어와서 그것을 벡터로 만들어
			// 그 벡터를 테이블의 자료를 위한 rowData에 담아요
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);
				
				//벡터를 하나 만들고 그 벡터에 no,item,qty,price를 담는다.
				Vector v = new Vector();
				v.add(no);
				v.add(name);
				v.add(qty);
				v.add(price);
				
				// 그 벡터를 rowData에 담는다.
				rowData.add(v);
				
				//바뀐 내용으로 테이블을 다시그려요
				//처음 테이블을 만들 때에는 rowData벡터가 비어있었음
				// 나중에 테이블의 데이터인 rowData에 바뀐자료를 적용하기 위해서는 
				// updateUI 호출해야한다.
				table.updateUI();
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
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");
			
				printGoods();
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
	
	public static void main(String[] args) {
		new GoodsTestDBMethodUpdateDelete();
	}

}
