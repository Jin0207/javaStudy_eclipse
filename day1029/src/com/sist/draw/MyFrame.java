package com.sist.draw;

import javax.swing.JColorChooser;

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
import java.awt.Color;
public class MyFrame extends JFrame implements ActionListener{
	private LinePanel lp;
	JFileChooser jfc;
	//������ �����ϱ� ���� ���̾�α� JColorChooser ���� ����
	JColorChooser jcc;
	
	public MyFrame() {
		
		lp = new LinePanel();	
		add(lp);
		
		jfc = new JFileChooser("c:/myData");
		jcc = new JColorChooser();
		
		//�޴��� ����
		JMenuBar jmb = new JMenuBar();
		
		//�ָ޴� ����
		JMenu mn_file = new JMenu("����");
		JMenu mn_draw = new JMenu("�׸��⵵��");
		JMenu mn_color = new JMenu("���� ����");
		
		//"����"�� �θ޴� ����
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		//"�׸��⵵��"�� �θ޴� ����
		JMenuItem draw_line = new JMenuItem("��");
		JMenuItem draw_rect = new JMenuItem("�簢��");
		JMenuItem draw_oval = new JMenuItem("��");
		
		//"����"�� �θ޴� ����
		JMenuItem color_black = new JMenuItem("����"); 
		JMenuItem color_blue = new JMenuItem("�Ķ�"); 
		JMenuItem color_red = new JMenuItem("����"); 
		JMenuItem color_other = new JMenuItem("�ٸ�����"); 
		
		//�θ޴����� �ָ޴��� ���
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//�ָ޴� "�׸��⵵��"�� �θ޴��� �߰�
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);
		
		// �ָ޴� "����"�� �θ޴� �߰�
		mn_color.add(color_black);
		mn_color.add(color_blue);
		mn_color.add(color_red);
		mn_color.add(color_other);
		
		//�ָ޴��� �޴��ٿ� ���
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		//�޴��ٸ� �����ӿ� ����
		setJMenuBar(jmb);
		
		//������ JMenuItem�� ���Ͽ� �̺�Ʈ�� ���
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		color_black.addActionListener(this);
		color_blue.addActionListener(this);
		color_red.addActionListener(this);
		color_other.addActionListener(this);
		
		setTitle("�� �׸���");
		setSize(500, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("����")) {
			
			try {
				int re = jfc.showSaveDialog(this);

				if(re == 0) {
					
					File file = jfc.getSelectedFile();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					
					oos.writeObject(lp.list);
					oos.close();
				}//end if
			}catch (Exception ex) {
				System.out.println("���ܹ߻�: " + ex.getMessage());
			}//end catch			
		}else if(cmd.equals("����")) {
			
			int re = jfc.showOpenDialog(this);
			if(re == 0) {
				try {
				File file = jfc.getSelectedFile();
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				lp.repaint();
				ois.close();
				}catch (Exception ex) {
					System.out.println("���ܹ߻�: " + ex.getMessage());
				}//end catch
			}
		}else if(cmd.equals("������")) {
			
			lp.list.clear();
			lp.repaint();
		}else if(cmd.equals("��")) {
			lp.drawType = 0;
		}else if(cmd.equals("�簢��")) {
			lp.drawType = 1;
		}else if(cmd.equals("��")) {
			lp.drawType = 2;
		}else if(cmd.equals("����")){
			lp.drawColor = Color.BLACK;
		}else if(cmd.equals("�Ķ�")){
			lp.drawColor = Color.BLUE;
		}else if(cmd.equals("����")){
			lp.drawColor = Color.RED;
		}else if(cmd.equals("�ٸ�����")){
			//�ٸ� ������ �����ϵ��� JColorChooser ���̾�α׸� ���
			// ( �θ�������, Ÿ��Ʋ�ٿ���Ÿ������, �⺻����)
			Color color = jcc.showDialog(this, "�׸������", Color.BLACK);
			if(color != null) {
				lp.drawColor = color;
			}
		
		}
	}
}
