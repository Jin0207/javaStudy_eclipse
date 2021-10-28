package com.sist.exam02;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutputSstream {

	public static void main(String[] args) {
		Student lim = new Student("�ӻ���", 99, 88, 100);
		// ����Ʈ������ ��� ( ��ü������ ��� )
		// �ٸ� txt���ϰ� �����ϱ����� �ٸ� Ȯ���ڷ� �����Ѵ�.
		try {
			//��ü������ ����ϱ����� ObjectOutputSream ��ü ���� -- FileOutputStreamdml �θ�Ŭ����
			//Ȯ���ڴ� �ؽ�Ʈ������ �ƴϱ� ������ .txt�� ���� ����
			//���α׷��� �Ӽ��ݿ� �µ��� �˸°� Ȯ�����̸��� ������
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lim.stu"));
			//��ü�� ���
			oos.writeObject(lim);
			
			oos.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
			
		}
	}

}
