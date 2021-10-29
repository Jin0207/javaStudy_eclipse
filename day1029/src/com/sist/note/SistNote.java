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

//�θ޴��� Ŭ������ ��, event ó���� ���Ͽ� ActionListener �������̽��� �����ϵ��� �Ѵ�.
public class SistNote extends JFrame implements ActionListener{
	//�����̸������� ��������
	String fileName = "���� ����";
	// �޸����� �Է� �� ����� ���Ͽ� "������"�� ������ �Է��� �� �ִ� JTextArea�� ��������� ����
	JTextArea jta;
	// ������ �����̸��� ���⸦ ������ �����̸��� �����ϵ��� JFileChooser�� ��������� ����
	JFileChooser jfc;
	
	//�����ڿ��� JTextArea��ü�� �����Ͽ� �����ӿ� ��´�.
	public SistNote() {
		
		//�ؽ�Ʈ�� �����ִ� JTextArea ���� �� �߰�
		jta = new JTextArea();
		
			
		jfc = new JFileChooser("c:/myData");
		//add(jta);
		//�ؽ�Ʈ����� �ٷ� �����ӿ� ������ ȭ�鿡�� ����� �ؽ�Ʈ�� �� �� ������
		//�׷��� ������ ��ũ���� �ڵ� �������ִ� JScrollPane�� �ؽ�Ʈ����� ���μ� �����ӿ� �߰����ش�.
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
		
		//�θ޴��� ���Ͽ� �޴��� ������ ��, � ���� �ϵ��� �̺�Ʈ�� ����Ѵ�.
		//�Ű������� �̺�Ʈó����簴ü�� �����ؾ��Ѵ�
		//���� �ִ� Ŭ������ �̺�Ʈ�� ó���ϵ����ϱ����� "this"�� �Ű������� �����Ѵ�.
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//������ ����
		setSize(800, 600);
		setVisible(true);
		setTitle(fileName);
		
		/*
		//â�� �� ��������� �Ʒ��� �ؽ�Ʈ�� ����.
		//3�ʵڿ� �ٽ� �����ش�.
		jta.setText("�ȳ��ϼ���");
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
		}
		jta.setText("");
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�޴� �� ������ ���������� �ľ��ϱ� ���Ͽ�
		//ActionEvent�� getActionCommand()�� ȣ���Ѵ�.
		//getActionCommand()�� ������ �޴��� �̸�(����)�� �����´� -> String���� ��ȯ�Ѵ�.
		String cmd = e.getActionCommand();
		if(cmd.equals("������")) {
			jta.setText("");
			fileName = "�������";
			setTitle(fileName);
		}else if(cmd.equals("����")) {
			
			try {
				int re = jfc.showOpenDialog(this);
				if(re == 0) {
					File file = jfc.getSelectedFile();
					//������ ������ ��ǻ�͸޸𸮷� �о���̱� ���� ��Ʈ�� ����
					FileReader fr = new FileReader(file);
					
					//������ ��� ������ ��� ���� ���ڿ� ������ �����.
					// ���Ϸκ��� �ѱ��ھ� �о�� �����ϱ� ���Ͽ� "" ���� �ʱ�ȭ
					String data = "";
					
					//���Ϸκ��� �ѱ��ھ� �б����� ����
					int ch;
					
					while(true) {
						ch = fr.read();
						
						//���Ϸκ��� ���̻� �о���� ������ ������ �ݺ��� Ż��
						if(ch == -1) {
							break;
						}
						//������ ���� �ƴ϶�� �о���� ������ �Ӽ��ڸ� �ٽ� ���ڷ� ��ȯ�Ͽ�
						//���ڿ� ���� data�� ����
						data += (char)ch;
					}
					//������ ������ ��� �о���� �������� while���� Ż��
					//while���� Ż������ �� ������ ��系���� String���� data�� ���
					//data�� ������ �ؽ�Ʈ����� ����
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
			
		}else if(cmd.equals("����")) {
			//���� �޴��� ������ ��� ������� ������ ������ �����ϵ���
			//���̾�α׸� �����ݴϴ�
			//�Ű����� this�� �� ���̾�α׸� � ������������ ���������� ����
			//���� �������� SistNote���� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this�� ����
			//showSaveDialog���� ����ڴ� "����"�� ���� ���� �ְ� "���"�� ���� �� ���ִ�.
			//showSaveDialog�� �̸� ���������� ��ȯ�Ѵ�. ( 0: ���� , 1: ���)
			//�׷��⿡, "���"�� ������������ �������� ��ɾ ó������ �ʵ��� ���ǹ��� �ۼ��Ѵ�.
			int re = jfc.showSaveDialog(jfc);
			
			if(re == 0) {
				//���̾�α׿��� ������ ������ ������ �о�´�, ��ȯ�� FileŸ��
				File file = jfc.getSelectedFile();

				//������ ������ �ؽ�Ʈ����� ������ ������ ����Ѵ�
				//�׷������ؼ��� ��������� ���� ��Ʈ���� �����Ѵ�.
				//���ڴ����� ����� ���� Wirter�� �ļ��� FileWriter�� �̿�
				//����°� ���õ� ��� �����ڿ� �޼ҵ���� ���ܸ� �����ϰ� �ִ�.
				// �� ���ܵ��� RuntimeException�� �ļ��� �ƴϱ⿡ �ݵ�� ����ó���� ���־���Ѵ�
				try {
					FileWriter fw = new FileWriter(file);
					
					// ���Ϸ� �ؽ�Ʈ�������� ������ ����Ѵ�
					// �ؽ�Ʈ����� ���� ������ �о���� �޼ҵ� getText()�� �����
					// ���Ϸ� ����Ѵ�.
					fw.write( jta.getText() );
					
					fw.close();
					//����ڿ��� �˷��� ������ �ֿܼ� ����ϴ� ���� �ƴ϶�,
					// ���̾�α׸� ��쵵�� JOptionPane�� showMessageDialog()�� ���
					JOptionPane.showMessageDialog(this, "���Ϸ� �����Ͽ����ϴ�.");
					
					fileName = file.getName();
					String result = fileName.substring(0, fileName.lastIndexOf("."));
					fileName = result;
					setTitle(fileName);
					
				}catch (Exception ex) { // �޼ҵ��� �Ű������̸��� e�̱⶧���� �̺�Ʈ�����̸��� �ٸ� �ɷ� ����
					System.out.println("���ܹ߻�: " + ex.getMessage());
				}
			}
			
		}
		
	}
	
}
