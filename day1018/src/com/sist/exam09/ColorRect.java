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
		System.out.println("����: " + width + ", ����: " + height + ", ����" + area + ", ����: " + color);
	}
	/*
	public final void clacArea() { //�������̵� ����
		area = width * height;
	}
	Multiple markers at this line
	- Cannot override the final method 
	 from Rect
	- overrides com.sist.exam09.Rect.
	 clacArea
	 //�θ�Ŭ������ final�޼���� �������̵� �� �� ����
	 */
}
