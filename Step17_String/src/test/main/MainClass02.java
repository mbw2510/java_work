package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		Car car1=new Car("병우");
		Car car2=new Car("병우");
		
		boolean result = car1 == car2;
		//기본데이터 타입은 value값이 들어가지만
		//참조데이터 타입은 id값이 들어간다!!!!!
		//비교연산자로 비교를 하면 동일한 객체인지를 구별하는것이아니라
		//동일한 참조값인 지를 비교하는 것이다.
		
		String num1="10";
		String num2="10";
		Car car3=car1;
		
		//num1 과 num2 은 같다.
		//car3 와 car1 은 같다.
		
	}
}
