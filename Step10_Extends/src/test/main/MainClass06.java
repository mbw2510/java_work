package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass06 {
	public static void main(String[] args) {
		
		//객체를 생성해서 참조값을 object type 변수에 답기
		Object p1=new SmartPhone(); //id19
		//객체를 생성해서 참조값을 Phone type 변수에 담기
		Phone p2=new SmartPhone(); //id23
		//객체를 생성해서 참조값을 HandPhone type 변수에 담기		
		HandPhone p3=new SmartPhone(); //id24
		//객체를 생성해서 참조값을 SmartPhone type 변수에 담기
		SmartPhone p4=new SmartPhone();//id25
		
		//자식개체는 부모타입으로 전부 받아진다.
		
		
		//p1은 SmartPhone 객체이지만 p1.으로 찾아가보면 SmartPhone 기능을 쓸 수는 없다.
		//어떤 타입에 담아졌느냐에 따라서 참조할 수 있는 영역이 다르다.
		//부모타입으로 타입을 받으면 유연해진다????!!!!
		//비유. 붕어싸만코 스무개 사오는것, 아이스크림 사오는 것, 먹을것 사오는것,
		//부모타입으로 받아놨다가 원하는 시점에 캐스팅하면 된다.
		//
		
		Phone p5 = (Phone)p1; 
		p5.call(); //id19로 실행한것
		((Phone)p1).call();
		HandPhone p6 = (HandPhone)p1;
		SmartPhone p7 = (SmartPhone)p1;
	}
}
