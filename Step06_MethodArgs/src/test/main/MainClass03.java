package test.main;

public class MainClass03 {
	public static void main(String[] args){
		System.out.println("메인메소드가 시작되었습니다.");
		//test1()메소드를 호출해 보세요.
		test1("hi~");
		test2(19);
		test3(10<5);
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
