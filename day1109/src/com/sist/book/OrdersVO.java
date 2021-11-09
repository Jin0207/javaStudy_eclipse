package com.sist.book;

import java.sql.Date;
//���̺� ������ ���� �Ӽ����� �ְ� �����ڸ����, setter,getter����
public class OrdersVO {
	private int orderid;
	private int custid;
	private int bookid;
	private int saleprice;
	private Date orderdate;
	
	//�⺻������(�Ű������� �����ʴ� ������)
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//�Ű������� ��� ���� ������
	public OrdersVO(int orderid, int custid, int bookid, int saleprice, Date orderdate) {
		super();
		this.orderid = orderid;
		this.custid = custid;
		this.bookid = bookid;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
	}
	
	//�ܺο��� Ŭ������ ����� �����Ͽ� ���� �����ϴ� setter,
	//�����ؼ� ���� �о���� getter
	
	public int getOrderid() {
		return orderid;
	}
	
	//��ȯ���� ���� �޼ҵ�
	public void setOrderid(int orderid) {
		this.orderid = orderid;
		//return;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	@Override
	public String toString() {
		return "OrdersVO [orderid=" + orderid + ", custid=" + custid + ", bookid=" + bookid + ", saleprice=" + saleprice
				+ ", orderdate=" + orderdate + "]";
	}
	
	
	
}
