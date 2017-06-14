package test.main;

import test.mypac.Apple;
import test.mypac.Car;
import test.mypac.Orange;

public class MainClass08 {
	public static void main(String[] args) {
		int a = 10;
		String b = "김구라";
		boolean c = true;
		Orange d = new Orange();
		Apple e = new Apple();
		Car f = new Car();
		//test1, test2, test3 메소드를 순서대로 각각 호출해 보세요.
		//이미 만들어진 변수를 이용해서...
		test1(f);
		test2(e);
		test3(d);
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

