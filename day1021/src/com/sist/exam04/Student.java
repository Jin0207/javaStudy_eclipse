package com.sist.exam04;

public class Student {
	private String name;
	private String addr;
	private String phone;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}
	
	
}
