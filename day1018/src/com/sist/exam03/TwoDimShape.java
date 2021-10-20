package com.sist.exam03;

public abstract class TwoDimShape extends Shape {
	protected double area;
	public abstract double getArea();
	
	public TwoDimShape(int x, int y) {
		super(x, y);
	}
	
}
