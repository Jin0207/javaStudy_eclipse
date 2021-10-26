package com.sist.exam04;

public class SearchArray {
	
	public static int search(int[] arr, int value) throws NotFoundException{
		//�迭�� �ε����� �ƴ� ���� �����ϱ����Ͽ� -1
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return index = i;
			}
		}
		if(index == -1) {
			throw new NotFoundException("�迭�� ã�� ��: " + value + "�� �����ϴ�.");
			
		}
		return index;
	}
	
	public static void main(String[] args) {
		try {
			int[] data = {2, 4, 10, 9, 6};
			int n = search(data, 30);
			System.out.println(n);
		}catch(NotFoundException e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
