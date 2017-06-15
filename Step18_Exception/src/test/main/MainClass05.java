package test.main;

/*
 *  Exception의 종류
 *  1.Checked Exception
 *  -RuntimeException 클래스를 상속받지 않은 Exception type
 *  -반드시 try~catch 블럭으로 처리하거나 혹은 throws 해야한다.
 *  
 *  2.Unchecked Exception
 *  -RuntimeException 클래스를 상속 받은 Exception Type
 *  -try~catch 블럭으로 처리하지 않아도 컴파일 오류는 발생하지 않으므로 필요시 선택적으로 처리한다.
 */

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다.");
		//쓰레드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		//runtime Exception을 상속받지 않은 Exception은
		//try catch 를 해줘야 compile이 된다.	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인메소드가 종료됩니다.");
	}
}
