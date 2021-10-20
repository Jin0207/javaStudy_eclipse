package com.sist.exam02;

public class UnderGraduate extends Student {
	private String club;

	public UnderGraduate(String name, String number, String major, int grade, double credits, String club) {
		super(name, number, major, grade, credits);
		this.club = club;
	}

	public UnderGraduate() {
		super();
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "UnderGraduate [club=" + club + ", name=" + name + ", number=" + number + ", major=" + major + ", grade="
				+ grade + ", credits=" + credits + "]";
	}

	
	
	
}
