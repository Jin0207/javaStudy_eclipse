package com.sist.lab01;

import java.util.ArrayList;

class Animal{
	
}

class Lion extends Animal{
	
}

class Tiger extends Animal{
	
}

public class Cage02 {
	private Object animal;
	
	public Object getAnimal() {
		return animal;
	}

	public void setAnimal(Object animal) {
		this.animal = animal;
	}

	public static void main(String[] args) {
		Cage02 cage = new Cage02();
		cage.setAnimal(new Lion());
		/*
		 *Lion lion = cage.getAnimal();
		 *Type mismatch
		 *Lion클래스는 Object의 자식클래스
		 *자식객체의 참조변수가 부모객체를 참조할 수 없음
		 *참조를 위해서는 자식클래스로 변환해야한다.
		 *	Lion lion = (Lion)cage.getAnimal();
		 */
		/*Tiger tiger = (Tiger)cage.getAnimal();
		 *cage에 Lion을 넣고 꺼낼땐 Tiger객체타입으로 변환 -> 컴파일오류x
		 *하지만 실행시 오류, 문법적으로는 맞지만 버그발생 
		 */
	}

}
