package com.sist.exam04;

public class SearchArray {
	
	public static int search(int[] arr, int value) throws NotFoundException{
		//배열의 인덱스가 아닌 값을 설정하기위하여 -1
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return index = i;
			}
		}
		if(index == -1) {
			throw new NotFoundException("배열에 찾는 값: " + value + "가 없습니다.");
			
		}
		return index;
	}
	
	public static void main(String[] args) {
		try {
			int[] data = {2, 4, 10, 9, 6};
			int n = search(data, 30);
			System.out.println(n);
		}catch(NotFoundException e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
