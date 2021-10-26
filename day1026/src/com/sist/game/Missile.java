package com.sist.game;
import java.awt.event.KeyEvent;
public class Missile extends GraphicObject {
	//스페이스바를 눌렀을 때, 미사일이 발사되니 미사일이 발사되었는지 알려주는 변수
	boolean launched = false;
	
	//생성 시 이미지 파일이름을 매개변수로 전달받아 부모의 생성자에게 전달
	public Missile(String name) {
		super(name);
		y = -150;
	}
	
	public void update() {
		//만약에 미사일이 발사 되었다면 y좌표를 1씩 감소
		if(launched) {
			y -= 30;
		}
		
		//미사일의 y좌표가 화면 밖 영역이면 launched에 false설정
		if(y < -100) {
			launched = false;
			y = -150;
			x = -1000;
		}
				
	}
	// 키보드가 눌러지면, 현재 우주선이 있는 위치 x,y좌표에서
	// 미사일을 발사시키기위한 메서드 keyPressed메서드 오버라이딩
	// 매개변수로 전달받는 KeyEvent의 event를 통해서 어떤 key가 눌러졌는지 알수있다
	// 또, 매개변수 x,y는 우주선의 위치 x,y를 전달받음
	public void keyPressed(KeyEvent event, int x, int y) {
		
		//눌러진 키가 스페이스바라면 미사일 발사
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			
			//미사일의 x,y좌표를 우주선의 x,y로 설정
			this.x = x;
			this.y = y;
		}
	}
}
