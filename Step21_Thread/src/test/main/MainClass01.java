package test.main;

/*
 * 실행의 흐름 thread 작업단.
 * 
 * 메인메소드에서 시작하는 작업단위 - 메인Thread
 * 
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		
		MainClass01.test();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//작업단위를 여기서 5초동안 잡아두겠다.
		
		System.out.println("메인 메소드가 종료되었습니다.");
	}
	
	public static void test(){
		System.out.println("test() 메소드가 시작되었습니다.");
		
		System.out.println("test() 메소드가 리턴 됩니다.");
	}
}
