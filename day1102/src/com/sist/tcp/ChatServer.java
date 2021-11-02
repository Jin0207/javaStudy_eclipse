package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

// 서버가 한번에 여러명의 클라이언트와 대화가 가능하도록(메아리) 하기 위하여
// 클라이언트와 계속하여 대화를 주고받는 기능을 쓰레드로 구현
class ServerThread extends Thread{
	
	//요청한 클라이언트와 연결된 소켓을 멤버변수로 선언 
	Socket socket;
	
	// 연결된 클라이언트와 데이터를 주고받을 스트림 선언
	InputStream is;
	OutputStream os;
	
	// 실제로 데이터가 담길 배열 선언
	byte[] data = new byte[100];
	
	// 객체 생성시 클라이언트와 연결된 소켓을 매개변수로 전달받아 멤버변수에 담고
	// 스트림 생성
	public ServerThread(Socket socket){
		this.socket = socket;
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
	}
	
	
	public void run() {
		//연결이 된 클라이언트와 계속하여 데이터를 주고 받기 위하여 반복문 사용
		while(true) {
			try {
				//클라이언트로부터 데이터를 수신한다.
				//	read(byte[] b)
				is.read(data);
				String msg = new String(data);
				System.out.println("수신된 데이터: " + msg.trim());
				
				//클라이언트로부터 수신된 데이터를 그대로 메아리한다.
				//os.write(data);
				
				// 접속한 모든 클라이언트들에게 데이터를 방송하고자 함
				sendAll(data);
				
				//다음에 수신될 데이터를 위하여 배열을 비워준다
				Arrays.fill(data,  (byte)0);
			}catch (Exception e) {
				System.out.println("예외발생: " + e.getMessage());
			}// end catch
		}// end while
	}// end run
	
	public void sendAll(byte[] data) throws Exception{
		
		// 모든 클라이언트를 담아둔 list로 부터 데이터를 하나씩 꺼내어오면 그것은 ServerThread자료형
		// 
		for(ServerThread t : ChatServer.list) {
			// 각각의 SeverThread에는 연결한 클라이언트에게 데이터 출력을위한 스트림이 있음
			//  그 스트림을 통하여 데이터를 출력함
			t.os.write(data);
		}
	}// end sendAll
	
}// end class


public class ChatServer {
	
	// 요청한 클라이언트들을 모두 담아두기위한 ArrayList를 만듦
	// ArrayList에 담는 자료형은 통신을 요청한 한명의 클라이언트와 계속하여
	//대화를 주고 받는 일을 담당하는 쓰레드인 ServerThread를 담음
	public static ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	
	
	public static void main(String[] args) {
		//클라이언트로부터 수신된 데이터를 담기 위한 byte의 배열
		byte[] data = new byte[100];
		
		try {
			// 1. SeverSocket을 통해 서버 가동
			ServerSocket server = new ServerSocket(9007);
			
			//무한대기상태로 클라이언트의 접속 기다림
			while(true) {
				//클라이언트의 요청 수락
				Socket socket = server.accept();
				
				// 연결된 클라이언트와 대화를 계속 주고받기위한 쓰레드객체를 생성하고 쓰레드 가동
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
				// 접속한 모든 클라이언트와의 통신을 담당하는 객체를 담아두기위한 리스트에 담음
				list.add(thread);
				
			}
		}catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
		
	}

}
