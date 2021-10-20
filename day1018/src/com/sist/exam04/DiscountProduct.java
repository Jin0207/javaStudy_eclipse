package com.sist.exam04;

public class DiscountProduct extends Product {
	private double discount;

	public DiscountProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DiscountProduct(String name, int price, double discount) {
		super(name, price);
		this.discount = discount;
	}


	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "DiscountProduct [discount=" + discount + ", name=" + name + ", price=" + price + "]";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		price = (int)(price - price * discount);
		return super.getPrice();
	}
	
}
