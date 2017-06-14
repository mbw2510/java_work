package test.main;

import test.mypac.Phone;

public class MainClass01 {
	public static void main(String[] args) {
//		Phone p1=new Phone();
		//다형성????????????????????????????????????
		//하나의 객체는 여러가지 타입일 수 있다.
		
		String a = "abcd";
		
		//모든 참조 데이터는 Object타입이다.
		//하나의 객체가 여러가지 타입을 가지는 것을 다형성(폴리모피즘)이라고 한다.
		// 그 이유는?? 
		//Phone 객체의 참조값을 상속받은 부모 type 
		//즉 Object type 변수에 대입
		Object p1=new Phone();
		//Phone 객체의 참조값을 Phone type 변수에 대입
		Phone p2=new Phone();
		
	}
}
