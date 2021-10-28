package com.sist.homework_newfile;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.Color;
public class MyFrame extends JFrame implements ActionListener{
	private LinePanel lp;
	
	JFileChooser jfc;
	
	public MyFrame() {
		
		lp = new LinePanel();	
		add(lp);
		
		jfc = new JFileChooser("c:/myData");
		//메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		
		//주메뉴 생성
		JMenu mn_file = new JMenu("파일");
		JMenu mn_draw = new JMenu("그리기도구");
		JMenu mn_color = new JMenu("색상");
		
		//"파일"의 부메뉴 생성
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		//"그리기도구"의 부메뉴 생성
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		JMenuItem color_color = new JMenuItem("색상"); 
		//부메뉴들을 주메뉴에 담기
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//주메뉴 "그리기도구"에 부메뉴를 추가
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);
		
		mn_color.add(color_color);
		//주메뉴를 메뉴바에 담기
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		//메뉴바를 프레임에 설정
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대하여 이벤트를 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		color_color.addActionListener(this);
		
		setTitle("대각선 그리기");
		setSize(500, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("저장")) {
			
			try {
				int re = jfc.showSaveDialog(this);

				if(re == 0) {
					File file = jfc.getSelectedFile();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					
					oos.writeObject(lp.list);
					oos.close();
				}
			}catch (Exception ex) {
				System.out.println("예외발생: " + ex.getMessage());
			}//end catch
			
		}else if(cmd.equals("열기")) {
			
				try {
					int re = jfc.showOpenDialog(this);
					if(re == 0) {
						File file = jfc.getSelectedFile();
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
						
						lp.list = (ArrayList<GraphicInfo>)ois.readObject();
						
						lp.repaint();
						ois.close();
					}
				}catch (Exception ex) {
					System.out.println("예외발생: " + ex.getMessage());
				}
			}else if(cmd.equals("새파일")) {
				System.out.println("새파일의 처리입니다.");
				lp.list.clear();
				lp.repaint();
				
			}else if(cmd.equals("선")) {
				System.out.println("선그리기 처리입니다.");
				lp.drawType = 0;
			}else if(cmd.equals("사각형")) {
				System.out.println("사각형그리기 처리입니다.");			
				lp.drawType = 1;
			}else if(cmd.equals("원")) {
				System.out.println("원그리기 처리입니다.");
				lp.drawType = 2;
			}else if(cmd.equals("색상"));{
				System.out.println("색상");
				lp.jcc = new JColorChooser();
				lp.cr = lp.jcc.showDialog(null, "색상", Color.YELLOW);
				
			}
	}
}
