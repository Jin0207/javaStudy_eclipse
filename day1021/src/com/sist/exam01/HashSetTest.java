package com.sist.exam01;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet data = new HashSet();
		data.add("���");
		data.add("����");
		data.add("����");
		data.add("����");
		
		System.out.println(data);
		//���ο� �޸𸮰� �ƴ� ���� �޸𸮿� �迭��Ҹ� �߰��Ҽ�����
		data.add("������");
		data.add("���");
		//�ߺ� �����ʹ� ���� ����
		//�������� ���� �������� ����
		System.out.println(data);
	}

}
