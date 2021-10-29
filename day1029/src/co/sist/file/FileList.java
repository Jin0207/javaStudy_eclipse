package co.sist.file;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FileList extends JFrame {
	JList<String> list;
	
	public FileList() {
		//JList에 목록으로 사용할 배열을 미리 만듦
		String[] arr = {"사과", "포도", "딸기", "수박", "포도", "딸기", "포도", "딸기", "수박", "포도", "딸기", "수박", "포도", "딸기", "수박", "포도", "딸기", "수박", "수박", "포도", "딸기", "수박"};
		list = new JList<String>(arr);
		
		//JList도 JTextArea와 마찬가지로 프레임에 바로 담지않고 
		//JScrollPane으로 감싸서 담아야 한다.
		JScrollPane jsp_list = new JScrollPane(list);
		
		add(jsp_list);
		
		setSize(400, 300);
		setVisible(true);
		
	}
}
