package com.sist.draw07;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class LinePanel extends JPanel implements MouseListener{
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//"선", "원", "사각형" 중 무엇을 그릴것인지에 대한 멤버변수 선언
	//선:0, 원:1, 사각형:2
	int drawType;
	
	//사용자가 그린"선들을 담기 위한 리스트를 선언
	ArrayList<GraphicInfo> list;
	
	//생성자에서 "마우스 이벤트"를 등록해준다
	public LinePanel() {
		
		list = new ArrayList<GraphicInfo>();
		//this는 마우스이벤트가 발생하였을 때 이벤트처리 담당객체가 LinePanel클래스 자신입니다라고 알려주는것
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//부모의 paintComponet를 호출하여 화면을 깨끗이 해준다.
		super.paintComponent(g);
		/*
		System.out.println("다시 그려줍니다.");
		g.drawLine(x1,y1,x2,y2);
		*/
		
		//리스트에 담긴 모든 "선"을 그려줍니다.
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
	public void mouseClicked(MouseEvent e) {

		
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
		//하나의 "선이 완성될 때, ArrayList객체를 참조하는 list에
		//GraphicInfo를 매개변수를 가진 생성자를 통하여 객체를 생성하고 list에 담는다.
		list.add(new GraphicInfo(x1,y1,x2,y2, drawType));
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
