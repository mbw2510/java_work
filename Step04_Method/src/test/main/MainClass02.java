package test.main;

public class MainClass02 { //↓이클래스의 멤버다. static 멤버 메소드
	
	//static 멤버 메소드
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		
		//동일한 클래스의 static 멤버 메소드를 호출할때 클래스명 생략가능
		test();
		
		System.out.println("메인 메소드가 종료됩니다.");
	}
	//static 멤버 메소드	
	public static void test(){ //기본으로 실행되지는 않는다.
		System.out.println("MainClass02-test()메소드가 호출되었습니다.");
		
		System.out.println("MainClass02-test()메소드가 종료(리턴)됩니다.");
		//자바스크립트의 function은 종료될때 최소한 undefined로라도 변하지만 메소드의 리턴값은 아무것도없다.
		//void -> 메소드가 종료될 때 어떻게 변할지 정의해둠, 아무것도 없는걸로 설정됨
		
	}
}
