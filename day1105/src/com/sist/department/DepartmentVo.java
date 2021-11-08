package com.sist.department;

public class DepartmentVo {
	
	private int no;
	private String name;
	private String location;
	
	public DepartmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentVo(int no, String name, String location) {
		super();
		this.no = no;
		this.name = name;
		this.location = location;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
