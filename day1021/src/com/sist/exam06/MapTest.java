package com.sist.exam06;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ȫ���");
		list.add("����");
		list.add("010-1234-5678");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("�̸�", "ȫ�浿");
		map.put("�ּ�", "����");
		map.put("��ȭ", "010-1234-1234");
		
		//list�κ��� �ּҸ� ����Ϸ��� �ε����� ����
		System.out.println(list.get(1));
		//map���κ��� �ּҸ� ����Ϸ��� key������ ����
		System.out.println(map.get("�ּ�"));
	}

}
