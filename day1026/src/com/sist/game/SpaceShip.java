package com.sist.game;

import java.awt.event.KeyEvent;
// 우주선을 위한 클래스
public class SpaceShip extends GraphicObject {
	
	// 생성 시, 이미지파일명을 매개변수로 전달받아 부모생성자에 전달
	public SpaceShip(String name) {
		super(name);
		
		//맨처음 시작할때의 우주선 위치 설정
		x = 150;
		y = 350;
	}
	
	//우주선에 눌러진 방향키에 따라 우주선 위치를 이동시킬 메소드
	//매개변수로 전달받은 KeyEvent클래스의 event를 통해서 어떤키가 눌러졌는지 알 수 있음.
	public void keyPressed(KeyEvent event) {
		
		// 왼쪽 방향키가 눌러지면 x좌표를 왼쪽으로 이동시킬거임
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}
		
		// 오른쪽 방향키가 눌러지면 x좌표를 오른쪽으로 이동시킬거임
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		// 위쪽 방향키가 눌러지면 y좌표를 -10 위쪽으로 이동시킬거임
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}
		// 아래쪽 방향키가 눌러지면 y좌표를 아래쪽으로 이동시킬거임
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}
		
		
	}
}
