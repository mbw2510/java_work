package test.main;

/*
 * [java데이터 type]
 * 
 * 1.String type
 * 
 * -문자열을 다룰때 사용하는 데이터 type 이다.
 * 
 */


public class MainClass01 {
	//실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args){
		System.out.println("메인 메소드가 시작되었습니다.");
		
		//김구라 라는 문자데이터를 java에서 다룰려면?
		String name = "김구라";
		
		//name 변수 안에 있는 문자열정보를 콘솔창에 출력하기
		System.out.println(name);
		
		System.out.println("메인 메소드가 종료됩니다.");
	}
}
