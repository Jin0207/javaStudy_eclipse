package com.sist.goods;
//JTable을 추가하여 상품목록이 보이도록 구현해보자

import javax.swing.JButton;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class GoodsTestDB extends JFrame {
	
	JTextField jtf_no;		//상품번호를 입력받기 위한 입력상자
	JTextField jtf_item;	//상품명을 입력받기 위한 입력상자
	JTextField jtf_qty;		//수량을 입력받기 위한 입력상자
	JTextField jtf_price;	//가격을 입력받기 위한 입력상자
	
	JTable table; 			//모든 상품목록을 엑셀과 같은 모양으로 보여주기 위한 테이블 선언
	Vector colNames; //테이블의 칼럼이름을 위한 벡터선언
	Vector<Vector> rowData;  //테이블의 데이터를 위한 벡터를 선언
	
	//데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서(검색하여, 조회하여)
	// JTable에 출력하는 메소드
	public void printGoods() {
		//새로운 상품을 등록하여 계속하여 호출도리 수 있으니,
		//rowData를 먼저 깨끗이 비워준다.
		rowData.clear();
		
		//데이터베이스에 연결하여 실행할 명령어
		String sql = "select * from goods";
		
		//데이터베이스 연결과 필요한 변수들 선언
		Connection conn = null;		//DB서버에 연결을 위한 변수
		Statement stmt = null; 	 	// 데이터베이스 명령을 실행하기 위한 변수
		ResultSet rs = null;	 	//읽어온 자료를 담기위한 변수
		
		try {
			//1. jdbc드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db서버에 연결한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			//3. statement객체를 생성한다.
			stmt = conn.createStatement();
			
			//4. 데이터베이스 명령을 실행한다.
			// 사용하는 메소드 두가지 
			//executeUpdate : 자료를 추가, 수정, 삭제하고 int를 반환 
			//executeQuery : 자료를 읽어와서 ResultSet으로 반환
			rs = stmt.executeQuery(sql);
			
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
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (Exception e) {
			}
		}// end finally
	}
	
	
	
	public GoodsTestDB() {
		
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
		
		// 버튼들을 담는 JPanel
		JPanel p2 = new JPanel();
		//패널의 기본은 FlowLayout
		
		p2.add(btn_add);
		p2.add(btn_list);
		
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
				
				String sql = "insert into goods values("+ no +",'" + item + "'," + qty +"," + price + ")";
				
				// finally 에서도 접근할 수 있도록 Connection 변수와 Statement 변수를 try문 바깥에 선언
				Connection conn = null;
				Statement stmt = null;
				
				
				try {
					// 1. jdbc드라이버를 메모리로 로드한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. DB서버에 연결한다.
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					
					// 3. 데이터베이스 명령을 실행할 수 있는 Statement 객체생성
					stmt = conn.createStatement();
					
					// 4. 데이터베이스 명령 실행
					int re = stmt.executeUpdate(sql);
					
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
						if(stmt != null) stmt.close();
						
						if(conn != null) conn.close();
						
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}//end finally
			}//end actionPerformed
		});// end actionPerformed()
	}//end 생성자
	
	public static void main(String[] args) {
		new GoodsTestDB();
	}

}
