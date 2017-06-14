package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다.");
		
		try {
			//test()메소드에서 RuntimeException을 상속받지 않는
			//Exception을 발생시키기 때문에
			//try~catch 블럭으로 Exception을 처리해야한다.
			test();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//아래 test()메소드를 호출하면 오류로 던지고있기 때문에 처리를 해줘야한다.
		
		System.out.println("메인메소드가 종료됩니다.");
	}
	//throw 예약어를 이용해서 Exception 을 던질 수도 있다.
	public static void test() throws InterruptedException{
		System.out.println("test()메소드가 호출되었습니다.");
		
		//↓↓↓↓↓ 별로 잘못한것도 없는데 오류가 떠있을때가 있다. 그러면 try,catch로 블럭씌우든지, 오류를 던져버림
		//오류를 던져버리면 결국 오류를 언젠가는 잡아야한다.
		Thread.sleep(5000);
	}
}
