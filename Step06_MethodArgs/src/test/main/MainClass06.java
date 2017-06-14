package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		String a="hello";
		String b="hi!";
		int c=10;
		int d=20;
		boolean e=true;
		boolean f=false;
		MainClass06.test1(a,b);
		test2(c,d);
		test3(e,f);
		test4(d,e,a);
		
		
	}
	public static void test1(String msg1, String msg2){
		String a = msg1;
		String b = msg2;
		System.out.println(a);
		System.out.println(b);
	}
	public static void test2(int num1, int num2){
		int a = num1;
		int b = num2;
		System.out.println(a);
		System.out.println(b);
	}
	public static void test3(boolean isRun, boolean isWait){
		boolean a = isRun;
		boolean b = isWait;
		System.out.println(a);
		System.out.println(b);
	}
	public static void test4(int num, boolean canRun, String msg){
		int a = num;
		boolean b = canRun;
		String c = msg;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
