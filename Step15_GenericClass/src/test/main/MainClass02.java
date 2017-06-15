package test.main;

import test.mypac.MyBox;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다.");
		
		MyBox<String> box1=new MyBox<String>(); //T자리에 클래스타입이 올 수 있다.
		
		//기본 data type 으로 Generic 클래스를 지정불가		
		//MyBox<int> box2=new MyBox<int>();
		
		//기본 data type 의 [클래스 type] 을 wrapper 클래스라고 한다.
		//분명 ↓ 기본 데이터 타입인데 ID값이 부여된다.
		//wrapper 클래스를 적용하는 방법은 첫글자를 대문자로 설정 + int를 Integer 로 char 대신에 Character로 변환
		
		Byte a = 10; //byte의 객체형
		Short b = 10;//short 의 객체형
		Integer c = 10;//int 의 객체형
		Long d = 10l;//long 의 객체형
		
		Float e=10.1f;//float 의 객체형
		Double f =10.1d;//double 의 객체형
		
		Character g = 'A';//char 의 객체형
		Boolean h=true;//boolean 의 객체형	
		
		//기본 데이터 type의 객체형을 이용해서 generic class 지정하기
		MyBox<Integer> box2=new MyBox<Integer>();
		box2.set(10);
		int result = box2.get();//int, Integer 둘다 받을수있다.
		Integer result3= box2.get();
		
		//객체생성시 generic type생략가능
		MyBox<Boolean> box3=new MyBox<Boolean>();//new MyBox<>로 생략해도 된다.
		box3.set(true);
		boolean result2 = box3.get();
		
	}
}
