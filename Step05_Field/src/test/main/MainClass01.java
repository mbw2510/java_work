package test.main;

import test.auto.Car;

public class MainClass01 {
	public static void main(String[] args) {
		//Car type 객체를 생성하고
		//참조값을 Car type c1 이라는 변수에 저장하기
		Car c1 = new Car();//Car타입 변수 c1에 담는다.
		//c1에 들어있는 참조값을 이용해서 메소드 호출하기
		c1.drive();
		//c1에 들어있는 참조값을 이용해서 필드참조하기
		String a = c1.brand; //brand 는 string 타입이다.
	} //필드는 저장소 ex)brand //메소드는 기능
}
