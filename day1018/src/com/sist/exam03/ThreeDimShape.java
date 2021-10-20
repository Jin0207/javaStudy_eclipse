package com.sist.exam03;

public abstract class ThreeDimShape extends Shape {

	protected double volume;
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public ThreeDimShape(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public abstract double getVolume();
}
