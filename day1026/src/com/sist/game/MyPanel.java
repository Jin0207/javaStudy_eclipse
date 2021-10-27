package com.sist.game;

import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Random;
import java.awt.Graphics;
// 적, 미사일, 우주선 을 동시에(한꺼번에) 담을 수 있는 "패널"클래스
// "패널"에 키보드가 눌러지는 이벤트를 처리하기위하여 "KeyListener" 인터페이스 구현
public class MyPanel extends JPanel implements KeyListener{
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	Explosion explosion;
	
	//패널이 생성됨과 동시에 동작
	public MyPanel() {
		super();
		//패널의 키보드 이벤트를 등록
		addKeyListener(this);
		//패널의 키보드 요청을 설정 A
		requestFocus();
		//패널에 포커스를 설정 B
		setFocusable(true);
		//패널은 화면구성요소 중 키보드를 입력받는 용도가 아니기에
		//A,B를 사용하여 키보드로부터 입력을 받아들이게 함 -- "패널"에 "포커스"를 설정
		
		//이미지 파일명을 가지고 객체 생성
		enermy = new Enermy("enermy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		//explosion = new Explosion("explosion.png");
		
		//"패널"의 구성요소인 "적", "미사일", "우주선"이 서로 독립적으로(가능하면 공평하게) 움직이도록 하기 위하여
		//"멀티 쓰레드"로 구현
		// "적", "미사일", "우주선"이 동시에 움직이게 하는 기능은 다른 곳에서는 필요가 없기때문에
		// 이곳 "패널"에서만 필요하니
		// 클래스를 클래스 안에 만듦
		// 이러한 클래스를 inner class라고 함
		class MyThread extends Thread{
			
			public void run() {
				while(true) {
					
					//위치를 변경하는 메소드 호출
					enermy.update();
					//spaceship.update(); -- 우주선은 키보드가 눌러진 방향으로 한번에 한번 움직이도록 되어 있어 호출하지 않아도됨
					missile.update();
					
					//"적"이 "미사일"에 맞았는지 판별하여 없애는 메소드호출
					enermy.crush(missile);
					
					//"적", "미사일", "우주선"의 변경된 위치에 다시 그리라는 요청을 하는 메소드로 
					//repaint를 호출하면 paintComponent메소드가 동작
					//paintComponent메소드는 그래픽을 화면에 그려주는 메소드
					repaint();
					/*
					if(enermy.x == missile.x) {
						explosion.update(enermy.x);
						enermy.x = -150;
						missile.x = -150;
					}//end if
					*/
					
					try {
						Thread.sleep(20);
					}catch (Exception e) {
					}//end try,catch
				}//end while
				
				
			}//end run()
		}//end MyThread
		
		//멀티쓰레드 객체 MyThread 생성
		//is a 관계이기에 Thread가 MyThread를 참조할 수 있다.
		Thread t = new MyThread();
		
		//쓰레드를 가동
		t.start();
	}// end MyPanel 생성자
		
		//"적", "미사일", "우주선"의 변경된 위치에 그래픽을 다시 그려줌
		//"패널"에 그래픽을 표현하기 위해서는 paintComponent 오버라이딩
		//이때 매개변수로 전달받은 Graphics에는 그래픽을 표현하기위한 다양한 메소드들이 있다
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//그래픽을 그리기 위한 그래픽스의 g를 전달하여 다시 변경된 위치에 그리도록 한다.
			enermy.draw(g);
			spaceship.draw(g);
			missile.draw(g);
			//explosion.draw(g);
		}
		
		//KeyListener 인터페이스의 메소드 오버라이딩
		public void keyPressed(KeyEvent event) {
			
			//눌러진 키보드이벤트의 정보를 전달
			spaceship.keyPressed(event);
			missile.keyPressed(event, spaceship.x,spaceship.y);
		}

		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
}
