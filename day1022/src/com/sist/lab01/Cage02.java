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
		 *LionŬ������ Object�� �ڽ�Ŭ����
		 *�ڽİ�ü�� ���������� �θ�ü�� ������ �� ����
		 *������ ���ؼ��� �ڽ�Ŭ������ ��ȯ�ؾ��Ѵ�.
		 *	Lion lion = (Lion)cage.getAnimal();
		 */
		/*Tiger tiger = (Tiger)cage.getAnimal();
		 *cage�� Lion�� �ְ� ������ Tiger��üŸ������ ��ȯ -> �����Ͽ���x
		 *������ ����� ����, ���������δ� ������ ���׹߻� 
		 */
	}

}
