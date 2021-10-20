package com.sist.exam02;

import com.sist.exam01.Human;

public class Student extends Human {
	String major;
	//생성자
	public Student(String name, int age, String major) {
		super(name, age);
		System.out.println("Student의 생성자 동작함.");
		this.major = major;
	}
	//getter, setter
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [major=" + major + ", name=" + name + ", age=" + age + "]";
	}
	
	
	public static void main(String[] args) {
		Student student = new Student("명진", 21, "컴퓨터");
		Student student2 = new Student("미현", 22, "경영");
		Student student3 = new Student("용준", 24, "경제");
		
		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student.getProfession());
		System.out.println(student2.getProfession());
		System.out.println(student3.getProfession());
	}
	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "학생";
	}
	
}
