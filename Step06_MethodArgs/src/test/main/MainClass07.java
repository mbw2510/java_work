package test.main;

import test.mypac.Apple;
import test.mypac.Car;
import test.mypac.Orange;

public class MainClass07 {
	public static void main(String[] args) {
		//test1, test2 메소드를 각각 호출해보세요
		Car a = new Car();
		test1(a);
		Apple b = new Apple();
		test2(b);
		test1(new Car());
		//Orange type 을 인자로 전달받는 static 멤버 메소드를 만들고 호출해보세요
		test3(new Orange());
		
		test3(null);
		test2(null);
		test1(null);
		
		Car car3=null;
		//참조데이터 타입이 담길수 있는 빈공간을 null이라고 한다.
		
		/*
		 * Car car1 = new Car(); car1 만들어짐
		 * Car car2; 만들준비만 하고 안만들어짐
		 * Car car3=null; car3가 만들어졌으나 비어있다.
		 */
		//null은 빈상태를 나타낸다.
	}
	public static void test1(Car car){
		System.out.println("111");
	}
	public static void test2(Apple apple){
		System.out.println("222");
	}
	public static void test3(Orange orange){
		System.out.println("333");
	}
}

