package com.sist.draw07;

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

// MyFrame클래스 자신이 "JMenuItem"을 눌렀을 떄, 이벤트처리 담당자가 되도록하기위하여 ActionLustener인터페이스를 구현하도록함
// 또는 이너클래스로 할 수 있다.
public class MyFrame extends JFrame implements ActionListener{
	private LinePanel lp;
	
	//저장할 파일명과 열어올 파일명을 선택할 수 있도록하는 JFileChooser를 멤버변수로 선언
	JFileChooser jfc;
	
	public MyFrame() {
		
		lp = new LinePanel();	
		add(lp);
		
		//JFileChooser 객체를 생성
		jfc = new JFileChooser("c:/myData");
		
		//메뉴바를 생성합니다
		JMenuBar jmb = new JMenuBar();
		
		//주메뉴 "파일"을 생성
		JMenu mn_file = new JMenu("파일");
		
		//주메뉴 "그리기도구" 생성
		JMenu mn_draw = new JMenu("그리기도구");
				
		//부메뉴 "새파일"을 생성
		JMenuItem file_new = new JMenuItem("새파일");
		
		//부메뉴 "열기" 생성
		JMenuItem file_open = new JMenuItem("열기");
		
		//부메뉴 "저장" 생성
		JMenuItem file_save = new JMenuItem("저장");
		
		//"그리기도구"의 부메뉴 생성
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		//부메뉴들을 주메뉴에 담기
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//주메뉴 "그리기도구"에 부메뉴를 추가
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);
		
		//주메뉴를 메뉴바에 담기
		jmb.add(mn_file);
		jmb.add(mn_draw);
		
		//메뉴바를 프레임에 설정
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대하여 이벤트를 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		setTitle("대각선 그리기");
		setSize(500, 500);
		setVisible(true);
	}
	
	
	//각각의 JMenuItem을 누르면 actionPerformed메소드가 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem 중에 어떤 메뉴가 눌러졌는지 파악하기 위하여 매개변수 ActionEvent의 getActionCommand()를 이용
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "가 눌러짐");
		if(cmd.equals("저장")) {
			//어디에 어떤 이름으로 저장할지 선택하도록 JFileChooser 다이얼로그를 띄운다.
			
			try {
				int re = jfc.showSaveDialog(this);
				
				//저장하기 다이얼로그에서 저장을 누를수도있고, 취소를 누를수도 있다.
				//저장을 누르면 0을 반환, 취소를 누르면 1을 반환
				if(re == 0) {
					//다이얼로그에서 선택한 파일을 가져옴
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
						
						//파일로 데이터를 읽어들여 Linpanel 객체인 lp의 list에 담는다
						lp.list = (ArrayList<GraphicInfo>)ois.readObject();
						//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기위하여 repaint를 호출
						lp.repaint();
						
						ois.close();
					}
				}catch (Exception ex) {
					System.out.println("예외발생: " + ex.getMessage());
				}
			}else if(cmd.equals("새파일")) {
				System.out.println("새파일의 처리입니다.");
				
				
			}else if(cmd.equals("선")) {
				System.out.println("선그리기 처리입니다.");
				lp.drawType = 0;
			}else if(cmd.equals("사각형")) {
				System.out.println("사각형그리기 처리입니다.");			
				lp.drawType = 1;
			}else if(cmd.equals("원")) {
				System.out.println("원그리기 처리입니다.");
				lp.drawType = 2;
			}
	}
}
