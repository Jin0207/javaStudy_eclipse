package com.sist.exam03;

public class Cube extends ThreeDimShape {
	private double width;
	private double length;
	private double height;
	
	public Cube(int x, int y, double width, double length, double height) {
		super(x, y);
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Cube [width=" + width + ", length=" + length + ", volume=" + volume + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		volume = width * length * height;
		return volume;
	}

}
