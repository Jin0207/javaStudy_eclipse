package com.sist.exam03;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//타원, 직육면체, 원기둥
		//타원,직육면체,원기둥을 담을 수 있는 배열의 자료형 -> Shape
		Shape[] arr = new Shape[3];
		//배열을 사용하는 이유: 일괄처리가 가능함
		arr[0] = new Ellipse(10, 10, 20, 50);
		arr[1] = new Cube(10, 100, 100, 100, 100);
		arr[2] = new Cylineder(10, 300, 50, 100);
		/*
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		((TwoDimShape)arr[0]).getArea();
		//((Ellipse)arr[0]).getArea();
		((ThreeDimShape)arr[1]).getVolume();
		((ThreeDimShape)arr[2]).getVolume();
		System.out.println("==================================");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		*/
		for(Shape s : arr) {
			if(s instanceof TwoDimShape) {
				((TwoDimShape)s).getArea();
			}else if( s instanceof ThreeDimShape) {
				((ThreeDimShape)s).getVolume();
			}
			System.out.println(s);
		}
	}

}
