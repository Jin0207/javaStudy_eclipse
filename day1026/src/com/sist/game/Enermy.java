package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	// 적이 x축으로 움직이는 간격을 위한 변수
	// 맨처음에는 오른쪽 끝에 적이 위치하였으니 왼쪽으로가기위해 음수설정
	//int dx = -10;
	//int dy = 10;
	
	//적의 이동경로를 난수로
			int dx;
			int dy;
			
	//생성 시, "적"으로 표현할 그래픽 파일이름을 매개변수로 전달받아 부모클래스의 생성자에게 전달
	public Enermy(String name) {
		super(name);
		
		// "적"이 시작되는 위치
		// 오른쪽 맨끝 상단에 위치시킴
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//맨 처음에 적의 위치도 난수로 설정
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		//적의 이동경로값을 생성시에 난수로 만듦
		//이동하는 최소값: 10, 최대값: 40
		// 어떤 난수를 만들어서 90으로 나눈 나머지 10을 더한다
		dx = r.nextInt() % 30;
		dy = r.nextInt() % 30;
		
		if(dx >= 0) x += 10; 
		else dx -= 10;
		
		if(dy >= 0) y += 10;
		else dy -= 10;
		
		System.out.println("dx: " + dx);
		System.out.println("dy: " + dy);
	}
	
	public void update() {
		// x좌표를 dx만큼 변경시킴		
		x += dx;
		y += dy;
		
		
		
		//x축으로 끝에 도달했으면 부호를 바꿔줌
		if(x < 0 || x > 500) {
			dx = dx * -1;
		}
		
		//y축으로 끝에 도달했으면 부호를 바꿔줌
		if(y < 0 || y > 500) {
			dy = dy * -1;
		}
		/*
		//만약, 왼쪽끝에 도달하였다면 x는 < 0 거니깐 오른쪽으로 이동시키기위해 dx를 양수로 설정
		if(x < 0) {
			dx = 10;
		}
		
		//만약, 오른쪽 끝에 도달하였다면 다시 왼쪽으로 이동시키기위해 dx를 음수로 설정
		if(x > 500) {
			dx = -10;
		}
		
		if(y > 400) {
			dy = -10;
		}
		if(y < 0 ) {
			dy = 10;
		}
		*/
	}
	
	// "미사일"에 맞았는지 판별하는 메소드 정의
	// 미사일의 위치가 필요함
	// 매개변수를 미사일자체를 해도되고 미사일의 위치만으로 해도된다.
	public void crush( Missile missile ){
		//적의 크기에따라서 미사일이 맞앗는지 안맞앗는지 판별해야한다.
		if(x <= missile.x && missile.x <= x + 100 && y <= missile.y && missile.y <= y + 90) {
			//소리파일 객체 생성
			File file = new File("EXPLODE.WAV");
			
			try {
				//오디오 파일을 읽어오기위한 준비
				Clip clip = AudioSystem.getClip();
				
				//오디오 파일을 읽어온다
				clip.open(AudioSystem.getAudioInputStream(file));
				
				//오디오파일 재생
				clip.start();
			}catch (Exception e) {
			}
			
			y = -1000;
		}
	}
	
}
