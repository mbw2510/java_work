package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		//Car 클래스의 default 생성자(Constructor)호출해서 객체 생성
		//기본생성자-정의하지않아도 존재한다. new같은것 
		new Car();
		new Car().drive();
		Car a=new Car();
		a.drive();
		a.drive();
	}
}
/*
 *new Car(); -> heap 영역에 Car 객체를 생성하여 올린것 
*/