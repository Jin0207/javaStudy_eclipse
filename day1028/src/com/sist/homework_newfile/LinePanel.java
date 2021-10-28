package com.sist.homework_newfile;

import java.awt.Graphics;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;

public class LinePanel extends JPanel implements MouseListener{
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	int drawType;
	Color cr = Color.blue;
	
	JColorChooser jcc;
	ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		
		list = new ArrayList<GraphicInfo>();
		addMouseListener(this);
	}
	


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(GraphicInfo info : list) {
			x1 = info.getX1();
			y1 = info.getY1();
			x2 = info.getX2();
			y2 = info.getY2();
			int width = x2 - x1;
			int height = y2 - y1;
			
			switch(info.getDrawType()) {
				case 0 : g.drawLine(x1, y1, x2, y2); break;
				case 1 : g.drawRect(x1, y1, width, height); break;
				case 2 : g.drawOval(x1, y1, width, height); break;
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		list.add(new GraphicInfo(x1,y1,x2,y2, drawType, cr));
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
}
