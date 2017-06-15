package test.mypac;

/*
 * [Thread(작업단위) 만들기]
 * 
 * (방법2)
 * 
 * -runnable 인터페이스를 구현한 클래스를 정의한다.
 * -run()메소드를 오버라이딩 한다.
 * -스레드가 필요한 곳에서 지금만든 크래스로 Runnable type 객체를 생성한다.
 * -Thread 객체를 생성하면서 생성자의 인자로 Runnable type 객체의 참조값을 전달한다.
 * -생성한 Thread 객체의 start()메소드를 호출해서 새로운 스레드를 시작시킨다.
 */
public class YourThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Your Thread 가 시작됨");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Your Thread 가 종료됩니다.");
		
	}
	
}
