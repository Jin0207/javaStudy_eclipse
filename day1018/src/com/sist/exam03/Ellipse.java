package com.sist.exam03;

public class Ellipse extends TwoDimShape {
	private double width_radius;
	private double height_radius;
	
	public Ellipse(int x, int y) {
		super(x, y);
	}

	public Ellipse(int x, int y, double width_radius, double height_radius) {
		super(x, y);
		this.width_radius = width_radius;
		this.height_radius = height_radius;
	}
	
	public double getWidth_radius() {
		return width_radius;
	}

	public void setWidth_radius(double width_radius) {
		this.width_radius = width_radius;
	}

	public double getHeight_radius() {
		return height_radius;
	}

	public void setHeight_radius(double height_radius) {
		this.height_radius = height_radius;
	}
	
	
	@Override
	public String toString() {
		return "Ellipse [width_radius=" + width_radius + ", height_radius=" + height_radius + ", area=" + area + ", x="
				+ x + ", y=" + y + "]";
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		area = Math.PI * width_radius * height_radius;
		return area;
	}

}
