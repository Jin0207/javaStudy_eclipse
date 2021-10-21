//컴퓨터하고 사용자하고 가위,바위,보 게임을하는 프로그램
// 0: 가위, 1: 바위, 2:보
package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		Random r = new Random();
		int com = r.nextInt(3);
		Scanner sc = new Scanner(System.in);
		System.out.println("0: 가위, 1: 바위, 2:보");
		System.out.print("선택하세요: ");
		int user = sc.nextInt();
		
		System.out.println("컴퓨터는 " + map.get(com) + " 를 내었습니다.");
		System.out.println("당신은 " + map.get(user) + " 를 내었습니다.");
		
		//비기는 경우
		if(com == user) {
			System.out.println("당신은 비겼습니다.");
		}else if(user > com - 1 || user == 0 && com == 2){//이기는 경우
			System.out.println("당신은 이겼습니다.");
		}else {//지는 경우
			System.out.println("당신은 졌습니다.");
		}
	}

}
