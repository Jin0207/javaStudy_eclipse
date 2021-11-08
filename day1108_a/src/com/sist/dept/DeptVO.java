package com.sist.dept;

public class DeptVO {
	private int dno;
	private String dname;
	private String dlo;
	
	public DeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeptVO(int dno, String dname, String dlo) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dlo = dlo;
	}
	
	public int getDno() {
		return dno;
	}
	
	public void setDno(int dno) {
		this.dno = dno;
	}
	
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getDlo() {
		return dlo;
	}
	
	public void setDlo(String dlo) {
		this.dlo = dlo;
	}
	
	
}
