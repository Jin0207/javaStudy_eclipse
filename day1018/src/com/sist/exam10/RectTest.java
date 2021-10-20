package com.sist.exam10;

public class RectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect r1 = new Rect(10, 20);
		ColorRect r2 = new ColorRect(10, 20, "red");
		r1.calcArea();
		r2.calcArea();
		r1.info();
		r2.info();
	}

}
