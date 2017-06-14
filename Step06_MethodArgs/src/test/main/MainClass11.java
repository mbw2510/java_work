package test.main;

import java.io.PrintStream;

public class MainClass11 {
	public static void main(String[] args) {
		//Wrapper 클래스안에 정의된 car라는 이름의
		//static 멤버필드를 참조해서 drive()라는 메소드를 호출해보세요
		test.mypac.Wrapper.car.drive();
		//이것의 실행주체는 jvm
		System.out.println("안뇽");
					
		PrintStream a = System.out;
		//System이라는 클래스의 out필드 에는 PrintStream 타입의 값이 들어있기 때문
		a.println("안뇽!!");
		
	}
}