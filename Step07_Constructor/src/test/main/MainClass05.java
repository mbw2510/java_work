package test.main;

import test.mypac.Person;

public class MainClass05 {
	public static void main(String[] args) {
		//생성자를 하나라도 정의하면default 생성자는 없어진다.
		//default 생성자를 호출해서 객체 생성은 불가하다.
		//new Person();
		
		
		//Person 객체를 3개 생성해서 참조값을 각각 변수에 담아보세요.
		int a = 30;
		double b = 82.5;
		String c = "문병우";
		Person A = new Person(a,b,c);
		Person B = new Person(30,84.7,"돼랑이");
		Person C = new Person(40,23.9,"우왕");
		A.showInfo();
		B.showInfo();
		C.showInfo();
	}	
}
