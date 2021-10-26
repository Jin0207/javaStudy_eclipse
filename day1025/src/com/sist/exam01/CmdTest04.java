package com.sist.exam01;
import java.util.Scanner;
//java CmdTest04 http://www.sist.co.kr/insert.do
//java CmdTest04 http://www.sist.co.kr/list.do
//java CmdTest04 http://www.sist.co.kr/update.do
import java.util.HashMap;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
class CmdTest04{
	public static void main(String[] args) throws Exception
	{
		//�Ź� ���ο� ���񽺰� �߰��� ������ �ڵ带 �����ϴ� ���ŷο��� �־�
		//������ ���������� ����� �ڵ��� ������� ���ο� ���񽺸� ����� �� �ִ�.
		
		//����ڰ� ��û�ϴ� ���񽺸��� key���ϰ� ��ó����� ��ü�� value�� ��� ���� map����
		HashMap<String, SistAction> map = new HashMap<String, SistAction>();
		//���񽺸�� ��ó�����Ŭ�������� �ִ� ���ϰ�ü�� ������
		//���������� ���鶧�� ������� �ۼ��ؾ��Ѵ�, ����� All files�� ������ �ٲپ� ����
		FileReader fr = new FileReader("sist.properties"); // ��ȣ�ȿ� ���� �̸�
		//������ ������ key�� value�� �����ϱ� ���� ��ü ����
		Properties prop = new Properties();
		//������ ������ �о��
		prop.load(fr); // key�� key��� value�� value���
		//porp�κ��� key���(���񽺸�)�� �ݺ��� ��ü�� ������
		Iterator iter = prop.keySet().iterator();
		//key�� �ִ� ��ŭ �ݺ�����
		while(iter.hasNext()){

			String cmd = (String)iter.next(); // ���񽺸� ������
			String clsName = (String)prop.get(cmd); // ���񽺸� �ش��ϴ� value�� ��������(��ó�� ����ϴ� Ŭ������)
			// ���ڿ��� �Ǿ� �ִ� Ŭ�����̸��� �ش��ϴ� ��ü�� ������
			SistAction obj = (SistAction)Class.forName(clsName).newInstance();
			//����ڰ� ��û�� ���񽺸�� ��ó�� ��� ��ü�� key��   value�� �Ͽ� map�� ���
			map.put(cmd, obj);
		}
		String url = args[0];
		String cmd = url.substring( url.lastIndexOf("/") + 1);
		//map���κ��� ���񽺴�簴ü�� ���� ������
		SistAction action = map.get(cmd);
		action.pro();

		
	}
}
