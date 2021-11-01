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
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.KeyListener;

public class SistNote extends JFrame implements ActionListener, KeyListener{
	String fileName = "���� ����";
	//�̹� ���ϸ��� ���� ��� ����� �ʰ� �ش� ���Ͽ� �����ϵ��� �ϱ� ���Ͽ� File��ü�� ��������� ����
	File file;
	
	JTextArea jta;
	JFileChooser jfc;
	// �޸����� ������ ����� ������ �ִ� �� ���¸� �����ϱ� ���� ����
	boolean isNew;
	
	public SistNote() {
		
		jta = new JTextArea();
		//isNew �� �⺻���� false�� ����
		isNew = false;
		
		jfc = new JFileChooser("c:/myData");
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		//�޴� ����� �����ӿ� �߰�
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("����");
		
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		jmb.add(mn_file);
		
		setJMenuBar(jmb);
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//�ؽ�Ʈ����� Ű�̺�Ʈ ���
		jta.addKeyListener(this);
		
		//������ ����
		setSize(800, 600);
		setVisible(true);
		setTitle(fileName);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("������")) {
			if(isNew == true) {
				int re = JOptionPane.showConfirmDialog(this,"�����Ͻðڽ��ϱ�?");
				System.out.println("re: " + re);
				switch(re) {
					case 0: saveFile();
					case 1:
						jta.setText("");
						fileName = "�������";
						setTitle(fileName);
						isNew = false;
						file = null;
						break;
					case 2 : case -1: return;
				
				}
			}else {
				jta.setText("");
				fileName = "�������";
				setTitle(fileName);
				isNew = false;
				file = null;
			}
			
		}else if(cmd.equals("����")) {
			
			try {
				int re = jfc.showOpenDialog(this);
				if(re == 0) {
					//����� ������ ������� ���Ͽ� ����
					file = jfc.getSelectedFile();
					FileReader fr = new FileReader(file);
					
					String data = "";
					
					int ch;
					
					while(true) {
						ch = fr.read();
						
						if(ch == -1) {
							break;
						}

						data += (char)ch;
					}

					jta.setText(data);
					JOptionPane.showMessageDialog(this, "������ �о�Խ��ϴ�.");
					
					fileName = file.getName();
					String result = fileName.substring(0, fileName.lastIndexOf("."));
					fileName = result;
					setTitle(fileName);
					
					fr.close();
				}
			}catch (Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}
			
			isNew = false;
			
		}else if(cmd.equals("����")) {
			saveFile();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isNew = true;
	}
	
	public void saveFile() {
		//�̹� ������ ���ٸ� ������ �����ϱ� ���� ���̾�α׸� ����
		//�̹� ������ �ִٸ� �ش� �̸����� �����ϵ��� �Ѵ�.
		
		//�̹� �����̸��� �ִ� ���¿��� File = null�� �ƴ� ���¿���
		// ������ ������ ������ ����
		// file�� null�� ���� (���Ӱ� �ؽ�Ʈ�� �Է��� ����)���� ������ ������
		// ������ �����ϴ� ���̾�α׸� ��� "���"�� �������ʰ� "����"�� ������ ���� �����ϵ���ó���ؾ��Ѵ�
		//�̰��� ���ÿ� ó���ϱ� ���Ͽ� re�� �⺻�� 0�� ����
		// �׷��� �̹� ������ ������ ������ if�� ������ �ʾƼ� re = 0�� ����
		// ���� file�� ���� ���¸� ���� if���� ������ ���̾�α׸� ���
		// ����� ���̾�α׿��� ������ ���� re�� ������
		int re = 0;
		
		if(file == null) {
			re = jfc.showSaveDialog(jfc);
			if(re == 0) {
				file = jfc.getSelectedFile();
			}
		}
		
		if(re == 0) {
			File file = jfc.getSelectedFile();

			try {
				FileWriter fw = new FileWriter(file);
				
				fw.write( jta.getText() );
				
				fw.close();

				JOptionPane.showMessageDialog(this, "���Ϸ� �����Ͽ����ϴ�.");
				
				fileName = file.getName();
				String result = fileName.substring(0, fileName.lastIndexOf("."));
				fileName = result;
				setTitle(fileName);
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}
			isNew = false;
		}
	}
}
