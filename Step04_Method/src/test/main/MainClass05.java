package test.main;

public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		//메소드를 호출하고 나서 리턴 되는 데이터를 각각 변수에 담아보세요.
		long test01=test1();
		double test02=test2();
		boolean test03=test3();
		String test04=test4();
		
		System.out.println("메인 메소드가 리턴됩니다.");
	}
	public static long test1(){
		return 10;
	}
	public static double test2(){
		return 10.1;
	}
	public static boolean test3(){
		return true;
	}
	public static String test4(){
		return "김구라";
	}
}
