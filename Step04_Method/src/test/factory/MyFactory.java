package test.factory;

public class MyFactory {
	public static void printMsg(){
		System.out.println("메세지를 출력합니다.");
	}
	public static int getCount(){
		int count=10;
		return count;
	}
	public static String getMsg(){
		String msg="안녕하세요";
		return msg;
	}
}
