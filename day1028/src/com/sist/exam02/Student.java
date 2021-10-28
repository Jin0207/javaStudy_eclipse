package com.sist.exam02;

import java.io.Serializable;
//객체단위의 출력을 위하여 직렬화함 -- Serializable 인터페이스를 받아야함
public class Student implements Serializable{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}



	
	
}
