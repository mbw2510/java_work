package test.main;


public class MainClass01 {
	public static void main(String[] args) {
		//메소드를 호출하면서 아무것도 전달하지 않기
		MainClass01.test1();
		//메소드를 호출하면서 int type value 전달하기
		MainClass01.test2(11);
		//멤버 메소드, 일반메소드 호출하기
		//
		new MainClass01().test3();
		//new+클래스명 -> ID값으로 변경된다.
	}
	public static void test1(){
		
	}
	public static void test2(int num){
		
	}
	public void test3(){
		//static 예약어가 붙지않은 메소드는 객체를 생성했을때 
		//그 객체가 어떤 기능을 가질지 설계도의 역할을 한다.
		//설계도를 실체화 하는 것은 new를 사용하여 실행한다.
		//test3 메소드는 static 영역에 올라가 있지 않다. static 영역에 올라가있는것은 Main,test1,test2등이다.
		//고로 
		System.out.println("우와 되었다!");
	}
}
