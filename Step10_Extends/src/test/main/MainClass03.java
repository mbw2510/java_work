package test.main;

import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		//Phone 객체를 생성해서 참조값을 Object type 변수에 담기
		Object p1=new Phone();
		
		//Casting 연산자를 이용해서 casting 한 다음 변수에 담는다.
		//형변환연산자() 요거를 쓰면 요기에는 해당 타입이 있다고 간주를 해줍니다
		//하지만 실행을 했을때 아다리가 안맞으면 안될수도있어요.
		Phone p2 = (Phone)p1;
		
		p2.call();
		
		//하고 싶은거 p2에 점을찍어서 하고싶다.
		
	}
}
