package test.main;

import test.mypac.YourThread;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다.");
		//Runnable type 의 참조값을 얻어내고
		YourThread yt = new YourThread();
		//Thread 객체를 생성하면서 Runnable type의 참조값 전달
		Thread thread=new Thread(yt);
		//Thread 객체의 start()메소드를 이용해서 스레드 시작 시키기.
		thread.start();
		System.out.println("메인메소드가 종료되었습니다.");
	}
}
