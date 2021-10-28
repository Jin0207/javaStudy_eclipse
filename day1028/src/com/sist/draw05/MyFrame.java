package com.sist.draw05;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// MyFrameŬ���� �ڽ��� "JMenuItem"�� ������ ��, �̺�Ʈó�� ����ڰ� �ǵ����ϱ����Ͽ� ActionLustener�������̽��� �����ϵ�����
// �Ǵ� �̳�Ŭ������ �� �� �ִ�.
public class MyFrame extends JFrame implements ActionListener{
	private LinePanel lp;
	
	public MyFrame() {
		
		lp = new LinePanel();	
		add(lp);

		
		
		//�޴��ٸ� �����մϴ�
		JMenuBar jmb = new JMenuBar();
		
		//�ָ޴� "����"�� ����
		JMenu mn_file = new JMenu("����");
		
		//�θ޴� "������"�� ����
		JMenuItem file_new = new JMenuItem("������");
		
		//�θ޴� "����" ����
		JMenuItem file_open = new JMenuItem("����");
		
		//�θ޴� "����" ����
		JMenuItem file_save = new JMenuItem("����");
		
		//�θ޴����� �ָ޴��� ���
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//�ָ޴��� �޴��ٿ� ���
		jmb.add(mn_file);
		
		//�޴��ٸ� �����ӿ� ����
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���Ͽ� �̺�Ʈ�� ���
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		setTitle("�밢�� �׸���");
		setSize(500, 500);
		setVisible(true);
	}
	
	
	//������ JMenuItem�� ������ actionPerformed�޼ҵ尡 ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem �߿� � �޴��� ���������� �ľ��ϱ� ���Ͽ� �Ű����� ActionEvent�� getActionCommand()�� �̿�
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "�� ������");
		if(cmd.equals("����")) {
			try {
				// ���� ȭ�鿡 �׷��� ��� �׷���(��)���� ���Ϸ� ����("c:/myData/data.pan")
				// ���� ȭ�鿡 �׷��� ��� ������ ������ LinePanel��ü�� lp�� list�� ������ִ�.
				//list��ü�� �뤊�� ���Ϸ� ����ϱ� ���Ͽ� ObjectOutputStram�� �̿�
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				oos.writeObject(lp.list);
				
				oos.close();
			}catch (Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}//end catch
			
		}else if(cmd.equals("����")) {
			//"c:/myData/data.pan"������ ������ �о�鿩
			//LinePanel ��ü�� lp�� list�� �����ϵ��� �Ѵ�.
			//ȭ���� �ٽñ׸������ؼ� LinePanel ��ü lp�� repaint�� ȣ��
			try {
				//��ü������ ������ ������ �о���̱����Ͽ� ObjectInputStream��ü����
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				//���Ϸ� �����͸� �о�鿩 Linpanel ��ü�� lp�� list�� ��´�
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ����Ͽ� repaint�� ȣ��
				lp.repaint();
				
				ois.close();
			}catch (Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}
		}else if(cmd.equals("������")) {
			System.out.println("�������� ó���Դϴ�.");
		}
	}
}
