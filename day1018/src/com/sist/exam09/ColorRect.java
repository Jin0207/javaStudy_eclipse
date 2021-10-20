package com.sist.exam09;

public class ColorRect extends Rect {
	private String color;

	public ColorRect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColorRect(double width, double height, String color) {
		super(width, height);
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	public void info() {
		System.out.println("가로: " + width + ", 세로: " + height + ", 면적" + area + ", 색상: " + color);
	}
	/*
	public final void clacArea() { //오버라이딩 금지
		area = width * height;
	}
	Multiple markers at this line
	- Cannot override the final method 
	 from Rect
	- overrides com.sist.exam09.Rect.
	 clacArea
	 //부모클래스의 final메서드는 오버라이딩 할 수 없어
	 */
}
