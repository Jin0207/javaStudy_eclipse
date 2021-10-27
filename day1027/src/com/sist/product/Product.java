package com.sist.product;

import java.util.Random;

// 생산자와 소비자가 공유할 제품클래스
public class Product {

	//생산되는 제품은 임의의 정수
	int number;
	//제품을 새로 생산하였는지, 소비하였는지 판별하기위한 변수
	// 생산자가 새로운 제품을 생산하면 true를 설정
	// 소비자가 제품을 소비하면 false
	public boolean isNew = false; 
	
	//생산자가 사용할 새로운 제품을 생성하는 메소드 정의
	//생산자가 제품을 생산하는 동안 소비자가 접근할 수 없도록 하기위해
	//"임계영역"으로설정
	public synchronized void makeNumber() {
		//새로운 제품 생산 전, 소비가 일어날때가지 대기상태로
		//소비자가 제품을 소비하고 isNew에 false를 설정하고 notify를 깨워주면 반복문탈출
		while(isNew == true) { 
			try {
				wait();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//새로운 제품 생산
		Random r = new Random();
		number = r.nextInt(100);
		System.out.println("생산자가 새로운 제품 생성: " + number);
		//새로운 제품이 생산되었다는 표시로 isNew를 true를 설정
		isNew = true;
		//대기중인 쓰레드(소비자)를 깨워줌
		notify();
	}//end 생성자
	
	//소비자가 사용할 제품을 소비하기 위한 메소드 정의
	public synchronized int getNumber() {
		
		//생산자가 새로운 제품을 생산할 때까지 대기상태로 있도록한다.(새로운 제품을 생산하지 않는동안)
		// 생산자가 새로운 제품을 생산하고 isNew에 true를 담고 notify로 깨워주면 반복문 탈출
		while(isNew == false) {
			try {
				wait();
			}catch (Exception e) {
			}
		}
		
		System.out.println("소비자가 제품 소비함: " + number);
		isNew = false;
		notify();
		return number;
	}
}
