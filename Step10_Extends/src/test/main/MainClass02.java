package test.main;

import test.mypac.Phone;

public class MainClass02 {
	public static void main(String[] args) {
		//phone 객체를 생성해서 참조값을 phone type 변수에 담기
		Phone a=new Phone();
		//a에 들어있는 참조값을 object type에 담기
		Object b = a;
		
		// a는 phone type임으로 call() 메소드 호출가능
		a.call();
		// b는 object type 임으로 call() 메소드 호출불가
//		b.call();
		
		
		
		
		/*
		 * a.
		 * b. 의 사용할 수 있는 기능이 다르다.
		 * a나 b나 동일한 참조값이 설정되어있지만 
		 */
	
		
	}
}
