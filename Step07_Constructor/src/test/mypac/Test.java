package test.mypac;

public class Test {
	public static int age;
	public static double weight;
	public static String name;
	
	public static void showInfo(){
		System.out.println(Test.age);
		System.out.println(Test.weight);
		System.out.println(name);
	//	System.out.println(this.msg);
		//static 영역에서 this라는것은 말이 안되는 것이다.
	}
}
