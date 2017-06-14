package test.main;

import test.mypac.CountThread;

public class MainClass05 {
	public static void main(String[] args) {
		//스레드 객체 생성해서 시작시키기
		Thread thread1=new CountThread("A",5);
		thread1.start();
		
		//스레드 객체 생성해서 시작시키기
		Thread thread2=new CountThread("B",10);
		thread2.start();
		
		System.out.println("메인스레드가 종료됩니다.");
	}
}
