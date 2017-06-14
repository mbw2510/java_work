package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		Thread t1 = new Thread(new Runnable(){//익명의 inner Class
			//인터페이스에는 new 인터페이스명() 같은 생성자 호출이 이뤄지지가 않는다.
			//위 문법은 익명의 inner Class를 생성하여 Thread타입의 객체를 생성한 것이다.

			@Override
			public void run() {
				System.out.println("새로운 작업 단위 시작");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("새로운 작업단위 종료");
			}
		});
		t1.start();//새로운 스레드 시작시키기
		System.out.println("메인 메소드가 종료됩니다.");
	}
}
