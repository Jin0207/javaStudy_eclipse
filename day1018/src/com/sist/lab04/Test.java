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
		//is a ���迡 ���� ��(��Ӱ���)
		//�θ��� ���������� �ڽ�Ŭ������ ��ü�� ������ �� �ִ�.
		
		g1.getLife();
		//��ü�� �޼����� ������
		//�ڽ��� Ŭ�������� ���� ã��
		//������ �θ�Ŭ������ �޼��尡 ����
		/*
		g1.getRing();
		The method getRing() is undefined for the type GameCharacter
		--getRing()�޼���� Hobitt Ŭ�������� ���ǵ� �޼����̱⿡
		  HobbittŬ������ ����ȯ�ؾ��� ȣ�Ⱑ���ϴ�
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
		//�迭�� ��ü�� �ʱ�ȭ�����ָ鼭 �����ϱ�
		for(GameCharacter character : characters) {
			character.draw();
		}
		System.out.println("===============================");
		drawAll(characters);
	}

}
