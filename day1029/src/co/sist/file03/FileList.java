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
	//�����͸� �����ϰ��Ͽ� ����Ʈ�� ������ �����ϸ� ���ŵǰ��ҷ���
	JList<Vector<String>> list;
	//JList�� �����͸� ���� ���͸� ����
	Vector vector;
	
	JTextArea jta;
	String path = "c:/myData";
	
	public FileList() {
		//���� ����
		vector = new Vector<String>();
		
		File dir = new File(path);
		
		String[] arr = dir.list();
		
		//���丮�� ���� ����� ���Ϳ� ����
		for(String str : arr) {
			vector.add(str);
		}
		
		//����Ʈ�� �����Ҷ� ������ �������� JList����
		list = new JList<Vector<String>>(vector);
		
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		JButton btn_delete = new JButton("����");
		
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
				//���Ϸκ��� �� ���� �� ���������� �о��
				ch = fr.read();
				
				//������ ���� �����ϸ� -1�� ��ȯ, �׶� �ݺ��� ����
				if(ch == -1) {
					break;
				}
				
				data += (char)ch;
			}
			//���� JList���� ������ ������ ������ �� �о���̸� while�� Ż���մϴ�.
			//���� ������ ������ ��� ������ ���ڿ� ���� data�� ����Ǿ� ����
			//�̰��� �ؽ�Ʈ����� ����Ѵ�
			jta.setText(data);
			
			//����� ������ �ݾ��ش�
			fr.close();
		}catch (Exception ex) {
			System.out.println("���ܹ߻�: " + ex.getMessage());
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
		//�����ϱ� ���Ͽ� ������ ������ File ��ü
		File file = new File(path + "/" + list.getSelectedValue());
		file.delete();
		
		//�ؽ�Ʈ����� �����ϰ� ����ش�.
		jta.setText("");
		
		//c:/myData ������ ���ϸ���� �ٽ��о�ͼ� Vector�� ������ �ٲٰ�
		//JList�� �ٽ� �׸����� ��û�մϴ�.
		File dir = new File(path);
		String[] arr = dir.list();
		
		//���͸� ������ ����� �ٽ� �о�� ���ϸ���� ����ش�.
		vector.clear();
		for(String f : arr) {
			vector.add(f);
		}
		
		//JList�� ����� �ٲ� ������ �������� �ٽ� �׷��ֵ��� ��û�ؾ��մϴ�.
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�.");
		
	}
}
