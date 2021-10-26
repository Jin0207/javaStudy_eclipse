package com.sist.game;

import java.util.Random;

public class Enermy extends GraphicObject {
	// 적이 x축으로 움직이는 간격을 위한 변수
	// 맨처음에는 오른쪽 끝에 적이 위치하였으니 왼쪽으로가기위해 음수설정
	int dx = -10;
	
	//생성 시, "적"으로 표현할 그래픽 파일이름을 매개변수로 전달받아 부모클래스의 생성자에게 전달
	public Enermy(String name) {
		super(name);
		
		// "적"이 시작되는 위치
		// 오른쪽 맨끝 상단에 위치시킴
		x = 500;
		y = 0;
	}
	public void randomLocation() {
			x = new Random().nextInt(400);
	}
	
	public void update() {
		// x좌표를 dx만큼 변경시킴		
		x += dx;

		
		//만약, 왼쪽끝에 도달하였다면 x는 < 0 거니깐 오른쪽으로 이동시키기위해 dx를 양수로 설정
		if(x < 0) {
			dx = 10;
		}
		if(x == new Random().nextInt(400))
		//만약, 오른쪽 끝에 도달하였다면 다시 왼쪽으로 이동시키기위해 dx를 음수로 설정
		if(x > 500) {
			dx = -10;
		}
	}
}
