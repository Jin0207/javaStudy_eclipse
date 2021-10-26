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
		//매번 새로운 서비스가 추가될 때마다 코드를 변경하는 번거로움이 있어
		//별도의 설정파일을 만들어 코드의 변경없이 새로운 서비스를 등록할 수 있다.
		
		//사용자가 용청하는 서비스명을 key로하고 일처리담당 객체를 value로 담기 위한 map생성
		HashMap<String, SistAction> map = new HashMap<String, SistAction>();
		//서비스명과 일처리담당클래스명이 있는 파일객체를 생성함
		//설정파일을 만들때는 공백없이 작성해야한다, 저장시 All files로 형식을 바꾸어 저장
		FileReader fr = new FileReader("sist.properties"); // 괄호안에 파일 이름
		//파일의 내용을 key로 value로 관리하기 위한 객체 생성
		Properties prop = new Properties();
		//파일의 내용을 읽어옴
		prop.load(fr); // key는 key대로 value는 value대로
		//porp로부터 key목록(서비스명)을 반복자 객체로 생성함
		Iterator iter = prop.keySet().iterator();
		//key가 있는 만큼 반복실행
		while(iter.hasNext()){

			String cmd = (String)iter.next(); // 서비스명 가져옴
			String clsName = (String)prop.get(cmd); // 서비스명에 해당하는 value를 꺼집어내어옴(일처리 담당하는 클래스명)
			// 문자열로 되어 있는 클래스이름에 해당하는 객체를 생성함
			SistAction obj = (SistAction)Class.forName(clsName).newInstance();
			//사용자가 요청할 서비스명과 일처리 담당 객체를 key와   value로 하여 map에 등록
			map.put(cmd, obj);
		}
		String url = args[0];
		String cmd = url.substring( url.lastIndexOf("/") + 1);
		//map으로부터 서비스담당객체를 얻어와 저장함
		SistAction action = map.get(cmd);
		action.pro();

		
	}
}
