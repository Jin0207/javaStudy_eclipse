package co.sist.file03;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;

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
	//데이터를 유연하게하여 리스트의 파일을 삭제하면 갱신되게할려고
	JList<Vector<String>> list;
	//JList의 데이터를 위한 벡터를 선언
	Vector vector;
	
	JTextArea jta;
	String path = "c:/myData";
	
	public FileList() {
		//벡터 생성
		vector = new Vector<String>();
		
		File dir = new File(path);
		
		String[] arr = dir.list();
		
		//디렉토리의 파일 목록을 벡터에 담음
		for(String str : arr) {
			vector.add(str);
		}
		
		//리스트를 생성할때 벡터의 내용으로 JList만듦
		list = new JList<Vector<String>>(vector);
		
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		JButton btn_delete = new JButton("삭제");
		
		btn_delete.addActionListener(this);
		
		add(jsp_list, BorderLayout.WEST);
		add(jsp_area, BorderLayout.CENTER);
		
		add(btn_delete, BorderLayout.SOUTH);
		
		setSize(800, 500);
		setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		try {
			FileReader fr = new FileReader(path + "/" + fileName);
			
			String data = "";
			
			int ch;
			
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
		
		//c:/myData 폴더의 파일목록을 다시읽어와서 Vector의 내용을 바꾸고
		//JList를 다시 그리도록 요청합니다.
		File dir = new File(path);
		String[] arr = dir.list();
		
		//벡터를 깨끗이 지우고 다시 읽어온 파일목록을 담아준다.
		vector.clear();
		for(String f : arr) {
			vector.add(f);
		}
		
		//JList의 모양을 바뀐 벡터의 내용으로 다시 그려주도록 요청해야합니다.
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다.");
		
	}
}
