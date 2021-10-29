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
		//C:\javaStudy\day1005 ����� ��� ������ ����� JList�� �����
		// ���丮(����)�� File ��ü�� ���� �� �ִ�.
		File dir = new File(path);
		
		//���丮 �ȿ� �ִ� ��� ���� �̸��� ���丮 �̸��� ����� �迭�� ������
		String[] arr = dir.list();
		
		//�迭���� �������� JList�� ����
		list = new JList<String>(arr);
		
		//JList�� �̺�Ʈ������Ѵ�
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//'����'�� ���� ��ư
		JButton btn_delete = new JButton("����");
		
		btn_delete.addActionListener(this);
		
		//JList�� ��� �ִ� jsp_list�� �������� ���ʿ�,
		//JTextArea�� ����ִ� jsp_area�� �������� ����� ��´�
		add(jsp_list, BorderLayout.WEST);
		add(jsp_area, BorderLayout.CENTER);
		
		//������ ���� ��ư�� �������� �Ʒ��ʿ� ��´�
		add(btn_delete, BorderLayout.SOUTH);
		
		setSize(800, 500);
		setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		//JList���� ������ File�̸��� ��������
		String fileName = list.getSelectedValue();
		
		try {
			//������ �����̸��� ������ �ִ� ��θ� ���ļ� File��ü�� �����ϰų� String���� ��θ� ����� ������ �б����� ��Ʈ���� ���� 
			FileReader fr = new FileReader(path + "/" + fileName);
			
			//������ ������ ��� �о�� �����ϱ� ���� ���ڿ� ������ ����� ""���� �ʱ�ȭ�Ѵ�
			String data = "";
			
			//���Ϸκ��� �� ���ھ� �о���̱� ���� ���� ����
			int ch;
			
			//������ ��� ������ �ݺ����� �̿��Ͽ� �о���δ�
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
		
		JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�.");
		
	}
}
