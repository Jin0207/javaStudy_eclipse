package com.sist.goods03;
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
import java.util.ArrayList;
import java.util.Vector;
public class GoodsTest extends JFrame {
	
	JTextField jtf_no;		//상품번호를 입력받기 위한 입력상자
	JTextField jtf_item;	//상품명을 입력받기 위한 입력상자
	JTextField jtf_qty;		//수량을 입력받기 위한 입력상자
	JTextField jtf_price;	//가격을 입력받기 위한 입력상자
	
	JTable table; 			//모든 상품목록을 엑셀과 같은 모양으로 보여주기 위한 테이블 선언
	Vector colNames; //테이블의 칼럼이름을 위한 벡터선언
	Vector<Vector> rowData;  //테이블의 데이터를 위한 벡터를 선언
	
	// 데이터베이스에 접근하여 추가, 목록, 수정, 삭제 기능을 갖고 있는 
	// dao를 멤버로 선언
	GoodsDao dao;
	public void printGoods() {
		
		rowData.clear();
		
		ArrayList<GoodsVo> list = dao.listGoods();
		//list에 담긴 GoodsVo를 하나씩 꺼내와서 테이블에 데이터를 표현하기위한 roewData에담아요
		for(GoodsVo g : list) {
			Vector v = new Vector();
			v.add(g.getNo());
			v.add(g.getItem());
			v.add(g.getQty());
			v.add(g.getPrice());
			
			rowData.add(v);
		}
		//테이블을 다시 그려주세요
		table.updateUI();
	}
	
	public GoodsTest() {
		
		//dao를 생성
		dao = new GoodsDao();
		
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
				
				GoodsVo g = new GoodsVo(no, item, qty, price);
				
				int re = dao.updateGoods(g);
				//그 VO를 dao의 insertGoods에 전달한다.
				if(re == 1) {
					System.out.println("상품수정에 성공하였습니다.");
					printGoods();
				}else {
					System.out.println("상품수정에 실패하였습니다.");
				}
			}
		});
		
		//"삭제" 버튼을 누르면 텍스트필드의 상품번호를 갖고와서, 삭제를하는메소드호출
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				int re = dao.deleteGoods(no);
				if(re == 1) {
					System.out.println("상품을 삭제하였습니다..");
					printGoods();
				}else {
					System.out.println("상품 삭제에 실패하였습니다");
				}
				
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
				
				//사용자가 입력한 상품번호, 상품명, 수량, 가격을 갖고 Vo를 생성
				GoodsVo g = new GoodsVo(no, item, qty, price);
				
				int re = dao.insertGoods(g);
				//그 VO를 dao의 insertGoods에 전달한다.
				if(re == 1) {
					System.out.println("상품등록에 성공하였습니다.");
					printGoods();
				}else {
					System.out.println("상품등록에 실패하였습니다.");
				}
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
	
	public static void main(String[] args) {
		new GoodsTest();
	}

}
