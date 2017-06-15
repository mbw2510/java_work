package test.main;

public class MainClass05 {
	public static void main(String[] args) {
		//test1, test2, test3, test4 메소드를 각각 순서대로 호출해보세요.
		test1("안녕","내이름은");
		MainClass05.test2(1,2);
		MainClass05.test3(10<5,10>11);
		MainClass05.test4(12,10<8,"우와우와");

	}
	public static void test1(String msg1, String msg2){
		String a = msg1;
		String b = msg2;
		System.out.println(a);
		System.out.println(b);
	}
	public static void test2(int num1, int num2){
		
	}
	public static void test3(boolean isRun, boolean isWait){
		
	}
	public static void test4(int num, boolean canRun, String msg){
		
	}
}
