package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		int[] a=new int[3];
		String[] b=new String[3];
		Car[] c=new Car[5];
		//위에서 만들어진 변수의 이름을 이용해서
		//test1, test2, test3, test4 순서대로 호출해보세요.
		
		test2(a);
		test3(b);
		test4(c);

	}

	public static void test2(int[] nums){
		System.out.println("test2() 메소드 호출됨");
	}
	public static void test3(String[] names){
		System.out.println("test3() 메소드 호출됨");
	}
	public static void test4(Car[] cars){
		System.out.println("test4() 메소드 호출됨");
	}
}
