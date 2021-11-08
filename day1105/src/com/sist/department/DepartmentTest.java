package com.sist.department;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DepartmentTest extends JFrame{
	
	JTextField jtf_no;
	JTextField jtf_name;
	JTextField jtf_location;
	
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	DepartmentDao dao;
	
	public DepartmentTest(){
		dao = new DepartmentDao();
		
		JPanel p = new JPanel();
		JPanel p_btn = new JPanel();
		JPanel p_list = new JPanel();
		
		p.setLayout(new GridLayout(3,2));
		p_list.setLayout(new BorderLayout());
		
		colNames = new Vector();
		rowData = new Vector<Vector>();
		
		colNames.add("부서번호");
		colNames.add("부서명");
		colNames.add("위치");
		
		table = new JTable(rowData, colNames);
		JScrollPane jsp = new JScrollPane(table);
		
		jtf_no = new JTextField();
		jtf_name = new JTextField();
		jtf_location = new JTextField();
		
		JButton btn_list = new JButton("조회");
		JButton btn_add = new JButton("추가");
		JButton btn_update = new JButton("수정");
		JButton btn_delete = new JButton("삭제");
		
		p.add(new JLabel("부서번호"));
		p.add(jtf_no);
		p.add(new JLabel("부서명"));
		p.add(jtf_name);
		p.add(new JLabel("위치"));
		p.add(jtf_location);
		
		p_btn.add(btn_list);
		p_btn.add(btn_add);
		p_btn.add(btn_update);
		p_btn.add(btn_delete);
		
		p_list.add(new JLabel("부서목록"), BorderLayout.NORTH);
		p_list.add(jsp, BorderLayout.CENTER);
		
		add(p, BorderLayout.CENTER);
		add(p_btn, BorderLayout.SOUTH);
		add(p_list, BorderLayout.EAST);
		
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String location = jtf_location.getText();
				
				DepartmentVo vo = new DepartmentVo(no, name, location);
				
				int re = dao.addDepartment(vo);
				
				if(re == 1) {
					System.out.println("추가 성공");
					printlist();
					clearJtf();
				}else {
					System.out.println("추가 실패");
				}
			}
		});//end btn_add
		
		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				
				int re = dao.deleteDepartment(no);
				
				if(re == 1) {
					System.out.println("삭제 성공");
					printlist();
					clearJtf();
				}else {
					System.out.println("삭제 실패");
				}
			}
		});// btn_delete
		
		btn_update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String name = jtf_name.getText();
				String location = jtf_location.getText();
				
				DepartmentVo vo = new DepartmentVo(no, name, location);
				
				int re = dao.updateDepartment(vo);
				
				if(re == 1) {
					System.out.println("수정 성공");
					printlist();
					clearJtf();
				}else {
					System.out.println("수정 실패");
				}//end else
			}
		});
		
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printlist();
			}
		});//end btn_list
		
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
				
				Vector data = rowData.get(index);
				
				jtf_no.setText(data.get(0) + "");
				jtf_name.setText(data.get(1) + "");
				jtf_location.setText(data.get(2) + "");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
	}
	
	public void printlist() {
		rowData.clear();
		
		ArrayList<DepartmentVo> list = dao.listDepartment();
		
		for(DepartmentVo vo : list) {
			int no = vo.getNo();
			String name = vo.getName();
			String location = vo.getLocation();
			
			Vector v = new Vector();
			v.add(no);
			v.add(name);
			v.add(location);
			
			rowData.add(v);
		}
		
		table.updateUI();
	}
	
	public void clearJtf() {
		jtf_no.setText("");
		jtf_name.setText("");
		jtf_location.setText("");
	}
	public static void main(String[] args) {
		new DepartmentTest();
	}

}
