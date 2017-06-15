package test.main;

import test.mypac.Car;

public class MainClass10 {
	public static void main(String[] args) {
		Car car1=new Car();
		Car car2;
		Car car3=null;
		
		car1.drive();
//		car2.drive();
		//car2는 만들 준비만 하고 바로 버림
		car3.drive();
		//변수 생성되고 데이터를 null값을 넣었기 때문에 nullpoint exception 이 발생함
	}
}
