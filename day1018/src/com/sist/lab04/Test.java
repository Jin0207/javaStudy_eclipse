package com.sist.lab04;

public class Test {
	
	public static void drawAll(GameCharacter[] characters) {
		for(GameCharacter character : characters) {
			character.draw();
			if(character instanceof Hobitt) {
				((Hobitt)character).getRing();
			}
		}
	}
	/*
	public static void drawAll(Object[] ob) {
		for(Object g : ob) {
			((GameCharacter)g).draw();
		}
	}
	*/
	public static void main(String[] args) {
		
		GameCharacter g1 = new Hobitt();
		//is a 관계에 있을 때(상속관계)
		//부모의 참조변수가 자식클래스의 객체를 참조할 수 있다.
		
		g1.getLife();
		//객체가 메세지를 받으면
		//자신의 클래스에서 먼저 찾고
		//없으면 부모클래스의 메서드가 동작
		/*
		g1.getRing();
		The method getRing() is undefined for the type GameCharacter
		--getRing()메서드는 Hobitt 클래스에서 정의된 메서드이기에
		  Hobbitt클래스로 형변환해야지 호출가능하다
		*/
		((Hobitt)g1).getRing();
		System.out.println("===============================");
		/*GameCharacter[] characters = new GameCharacter[6];
		characters[0] = new Hobitt();
		characters[1] = new Hobitt();
		characters[2] = new Titan();
		characters[3] = new Titan();
		characters[4] = new Sorcerer();
		characters[5] = new Sorcerer();
		*/
		GameCharacter[] characters = {
				new Hobitt(),
				new Hobitt(),
				new Titan(),
				new Titan(),
				new Sorcerer(),
				new Sorcerer()			
		};
		//배열의 객체를 초기화시켜주면서 생성하기
		for(GameCharacter character : characters) {
			character.draw();
		}
		System.out.println("===============================");
		drawAll(characters);
	}

}
