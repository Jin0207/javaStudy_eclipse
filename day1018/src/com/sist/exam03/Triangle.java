package com.sist.exam03;

public class Triangle extends TwoDimShape {
	public Triangle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	private double width;
	private double height;
	
	
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}
	

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}


	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		area = width * height / 2;
		return area;
	}

}
