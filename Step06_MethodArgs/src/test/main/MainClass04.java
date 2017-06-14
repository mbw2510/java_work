package test.main;

public class MainClass04 {
	public static void main(String[] args){
		System.out.println("메인메소드가 시작되었습니다.");
		//test1()메소드를 호출해 보세요.
		String a = "hello~!";
		int b = 999;
		boolean c = false;
		
		//위에서 만들어진 변수명을 이용해서 test1() 메소드를 호출해보세요.
		test1(a);
		test2(b);
		test3(c);
	}
	public static void test1(String gggㅎㅎㅎㅎㅎㅎㅎㅎㅎ){//ggg라는 지역 변수 선언
		String a = gggㅎㅎㅎㅎㅎㅎㅎㅎㅎ;
		System.out.println(a);
	}
	public static void test2(int num){
		int a = num;
		System.out.println(a);
	}
	public static void test3(boolean isRun){
		boolean a = isRun;
		System.out.println(a);
	}
}
