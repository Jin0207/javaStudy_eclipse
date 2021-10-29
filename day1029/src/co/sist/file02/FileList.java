package co.sist.file02;

import java.io.File;
import java.io.FileReader;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
public class FileList extends JFrame implements MouseListener, ActionListener{
	JList<String> list;
	JTextArea jta;
	String path = "c:/myData";
	public FileList() {
		//C:\javaStudy\day1005 경로의 모든 파일의 목록을 JList로 만들어
		// 디렉토리(폴더)도 File 객체로 만들 수 있다.
		File dir = new File(path);
		
		//디렉토리 안에 있는 모든 파일 이름과 디렉토리 이름의 목록을 배열로 가져옴
		String[] arr = dir.list();
		
		//배열안의 내용으로 JList를 만듦
		list = new JList<String>(arr);
		
		//JList에 이벤트를등록한다
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//'삭제'를 위한 버튼
		JButton btn_delete = new JButton("삭제");
		
		btn_delete.addActionListener(this);
		
		//JList를 담고 있는 jsp_list는 프레임의 왼쪽에,
		//JTextArea를 담고있는 jsp_area는 프레임의 가운데에 담는다
		add(jsp_list, BorderLayout.WEST);
		add(jsp_area, BorderLayout.CENTER);
		
		//삭제를 위한 버튼을 프레임의 아래쪽에 담는다
		add(btn_delete, BorderLayout.SOUTH);
		
		setSize(800, 500);
		setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		//JList에서 선택한 File이름을 가져오기
		String fileName = list.getSelectedValue();
		
		try {
			//선택한 파일이름과 파일이 있는 경로를 합쳐서 File객체를 생성하거나 String으로 경로를 만들어 파일을 읽기위한 스트림을 생성 
			FileReader fr = new FileReader(path + "/" + fileName);
			
			//파일의 내용을 모두 읽어와 누적하기 위한 문자열 변수를 만들고 ""으로 초기화한다
			String data = "";
			
			//파일로부터 한 글자씩 읽어들이기 위한 변수 선언
			int ch;
			
			//파일의 모든 내용을 반복문을 이용하여 읽어들인다
			while(true) {
				//파일로부터 한 글자 씩 정수값으로 읽어옴
				ch = fr.read();
				
				//파일의 끝에 도달하면 -1을 반환, 그때 반복문 종료
				if(ch == -1) {
					break;
				}
				
				data += (char)ch;
			}
			//현재 JList에서 선택한 파일의 내용을 다 읽어들이면 while을 탈출합니다.
			//현재 선택한 파일의 모든 내용은 문자열 변수 data에 저장되어 있음
			//이것을 텍스트에리어에 출력한다
			jta.setText(data);
			
			//사용한 파일은 닫아준다
			fr.close();
		}catch (Exception ex) {
			System.out.println("예외발생: " + ex.getMessage());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//삭제하기 위하여 삭제할 파일의 File 객체
		File file = new File(path + "/" + list.getSelectedValue());
		file.delete();
		
		//텍스트에리어를 깨끗하게 비워준다.
		jta.setText("");
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다.");
		
	}
}
