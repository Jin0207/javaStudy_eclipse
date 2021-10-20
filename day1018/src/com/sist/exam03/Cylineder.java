package com.sist.exam03;

public class Cylineder extends ThreeDimShape {
	private double radius;
	private double height;
	
	public Cylineder(int x, int y, double radius, double height) {
		super(x, y);
		this.radius = radius;
		this.height = height;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
		

	@Override
	public String toString() {
		return "Cylineder [radius=" + radius + ", height=" + height + ", volume=" + volume + ", x=" + x + ", y=" + y
				+ "]";
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		volume = Math.PI * Math.pow(radius, 2) * height;
		return volume;
	}

}
