package com.sist.note;

import java.awt.HeadlessException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//부메뉴를 클릭했을 때, event 처리를 위하여 ActionListener 인터페이스를 구현하도록 한다.
public class SistNote extends JFrame implements ActionListener{
	//파일이름에대한 변수선언
	String fileName = "제목 없음";
	// 메모장의 입력 및 출력을 위하여 "여러줄"의 문장을 입력할 수 있는 JTextArea를 멤버변수로 선언
	JTextArea jta;
	// 저장할 파일이름과 열기를 실행할 파일이름을 선택하도록 JFileChooser를 멤버변수로 선언
	JFileChooser jfc;
	
	//생성자에서 JTextArea객체를 생성하여 프레임에 담는다.
	public SistNote() {
		
		//텍스트를 쓸수있는 JTextArea 생성 후 추가
		jta = new JTextArea();
		
			
		jfc = new JFileChooser("c:/myData");
		//add(jta);
		//텍스트에리어를 바로 프레임에 담으면 화면에서 벗어나는 텍스트는 볼 수 가없다
		//그렇기 때문에 스크롤을 자동 생성해주는 JScrollPane에 텍스트에리어를 감싸서 프레임에 추가해준다.
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		//메뉴 만들고 프레임에 추가
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("파일");
		
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		jmb.add(mn_file);
		
		setJMenuBar(jmb);
		
		//부메뉴에 대하여 메뉴를 눌렀을 때, 어떤 일을 하도록 이벤트를 등록한다.
		//매개변수로 이벤트처리담당객체를 전달해야한다
		//현재 있는 클래스가 이벤트를 처리하도록하기위해 "this"를 매개변수로 전달한다.
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//프레임 설정
		setSize(800, 600);
		setVisible(true);
		setTitle(fileName);
		
		/*
		//창이 다 만들어지고 아래의 텍스트를 띄운다.
		//3초뒤에 다시 지워준다.
		jta.setText("안녕하세요");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
		}
		jta.setText("");
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//메뉴 중 무엇이 눌러졌는지 파악하기 위하여
		//ActionEvent의 getActionCommand()를 호출한다.
		//getActionCommand()는 눌러진 메뉴의 이름(글자)를 가져온다 -> String으로 반환한다.
		String cmd = e.getActionCommand();
		if(cmd.equals("새파일")) {
			jta.setText("");
			fileName = "제목없음";
			setTitle(fileName);
		}else if(cmd.equals("열기")) {
			
			try {
				int re = jfc.showOpenDialog(this);
				if(re == 0) {
					File file = jfc.getSelectedFile();
					//파일의 내용을 컴퓨터메모리로 읽어들이기 위한 스트림 생성
					FileReader fr = new FileReader(file);
					
					//파일의 모든 내용을 담기 위한 문자열 변수를 만든다.
					// 파일로부터 한글자씩 읽어와 누적하기 위하여 "" 으로 초기화
					String data = "";
					
					//파일로부터 한글자씩 읽기위한 변수
					int ch;
					
					while(true) {
						ch = fr.read();
						
						//파일로부터 더이상 읽어들일 내용이 없으면 반복문 탈출
						if(ch == -1) {
							break;
						}
						//파일의 끝이 아니라면 읽어들인 문자으 ㅣ숫자를 다시 문자로 변환하여
						//문자열 변수 data에 누적
						data += (char)ch;
					}
					//파일의 내용을 모두 읽어들인 다음에는 while문을 탈출
					//while문을 탈출했을 때 파일의 모든내용은 String변수 data에 담김
					//data의 내용을 텍스트에리어에 설정
					jta.setText(data);
					JOptionPane.showMessageDialog(this, "파일을 읽어왔습니다.");
					
					fileName = file.getName();
					String result = fileName.substring(0, fileName.lastIndexOf("."));
					fileName = result;
					setTitle(fileName);
					
					fr.close();
				}
			}catch (Exception ex) {
				System.out.println("예외발생: " + ex.getMessage());
			}
			
		}else if(cmd.equals("저장")) {
			//저장 메뉴를 누르면 어디에 어떤파일을 저장할 것인지 선택하도록
			//다이어로그를 보여줍니다
			//매개변수 this는 이 다이얼로그를 어떤 프레임위에서 띄울것인지를 전달
			//현재 프레임인 SistNote에서 띄우라는 의미로 객체자신을 의미하는 this를 전달
			//showSaveDialog에서 사용자는 "저장"을 누를 수도 있고 "취소"를 누를 수 도있다.
			//showSaveDialog는 이를 정수값으로 반환한다. ( 0: 저장 , 1: 취소)
			//그렇기에, "취소"를 눌렀을때에는 파일저장 명령어를 처리하지 않도록 조건문을 작성한다.
			int re = jfc.showSaveDialog(jfc);
			
			if(re == 0) {
				//다이얼로그에서 선택한 파일의 정보를 읽어온다, 반환은 File타입
				File file = jfc.getSelectedFile();

				//선택한 파일의 텍스트에리어에 쓰여진 내용을 출력한다
				//그러기위해서는 내용출력을 위한 스트림을 생성한다.
				//문자단위의 출력을 위한 Wirter의 후손인 FileWriter를 이용
				//입출력과 관련된 모든 생성자와 메소드들은 예외를 포함하고 있다.
				// 그 예외들은 RuntimeException의 후손이 아니기에 반드시 예외처리를 해주어야한다
				try {
					FileWriter fw = new FileWriter(file);
					
					// 파일로 텍스트에리어의 내용을 출력한다
					// 텍스트에리어에 써진 내용을 읽어오는 메소드 getText()를 사용해
					// 파일로 출력한다.
					fw.write( jta.getText() );
					
					fw.close();
					//사용자에게 알려줄 내용을 콘솔에 출력하는 것이 아니라,
					// 다이얼로그를 띄우도록 JOptionPane의 showMessageDialog()를 사용
					JOptionPane.showMessageDialog(this, "파일로 저장하였습니다.");
					
					fileName = file.getName();
					String result = fileName.substring(0, fileName.lastIndexOf("."));
					fileName = result;
					setTitle(fileName);
					
				}catch (Exception ex) { // 메소드의 매개변수이름이 e이기때문에 이벤트변수이름을 다른 걸로 변경
					System.out.println("예외발생: " + ex.getMessage());
				}
			}
			
		}
		
	}
	
}
