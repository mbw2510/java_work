package test.main;

import test.mypac.AnotherThread;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		//AnotherThread 객체 생성하고
		AnotherThread at = new AnotherThread();
		//start() 메소드 호출해서 새로운 작업단위를 시작시킨다.
		at.start();//Thread를 새로 호출하려면 run()메소드가아닌 start 메소드를 호출해야한다.
		
		AnotherThread at2 = new AnotherThread();
		//start() 메소드 호출해서 새로운 작업단위를 시작시킨다.
		at2.start();//Thread를 새로 호출하려면 run()메소드가아닌 start 메소드를 호출해야한다.
		
		System.out.println("메인 메소드가 종료됩니다.");
	}
}
