package test.main;

import java.util.Scanner;

/*
 * + 연결연산자.
 * 
 */
public class MainClass16 {
	public static void main(String[] args) {
		String name = "kim"+"gura";
		//연결연산
		//연결연산을 하게되면 쓰레기가 계속 만들어진다.
		//kim = idvalue 19
		//gura = idvalue 20
		//kimgura = idvalue 21
		String familyname = "kim";
		String name2 = "gura";
		
		String fullname;
		fullname = familyname + name2;
		//문자열을 입력받기 위한 Scanner 객체 생성하기
		
		Scanner scan = new Scanner(System.in);
		//입력한 문자열을 누적해서 담을 String type 변수
//		String str="";
//		for(int i=0;i<5;i++){
//			System.out.println("문자열 입력");
//			String tmp=scan.nextLine();
//			str = str + tmp;
//		}
		
		//입력한 문자열을 누적해서 담을 객체 생성
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<5; i++){
			System.out.println("문자열입력 : ");
			String tmp = scan.nextLine();
			//StringBuilder 객체에 누적시키기
			builder.append(tmp);
		}
		
		//StringBuilder 객체에 누적된 문자열을 String type으로 얻어내기
		String str = builder.toString();
		//입력한 문자열 전체 출력하기
		System.out.println(str);
		
		//문자열을 다룰때 좀쓴다
		//StringBuilder
		//.append(변수);
		//.toString();
	}
}
