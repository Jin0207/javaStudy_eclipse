package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//�����̸���, ���̸� ���Ϸ� ����غ���
		
		//���ڴ����� ����� ���� Ŭ������
		//Writer�� �ļ� �� ���� ����� ���� FileWriter�� ����
		try {
			//�������� ���ؼ��� �ش� ������ �����ؾ��Ѵ�.
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("���� �̸��� �ӻ����̰�\n");
			fw.write("���̴� 20�� �Դϴ�.");
			
			//������ ����� �������� ������ �ݾ��־���Ѵ�.
			//�ݾ����� ������ ������ �߻����� �ʰ�����,
			//�ش������� �ٸ� ������ ����� �� ���Եȴ�.
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�.");
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}
}
