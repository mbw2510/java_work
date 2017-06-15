package test.mypac;

public class Phone extends Object {
	//안써도 생략되있는게 많다. 써보겠다. extends Object 요거 생략된거. 아래 생성자도 생략된거
	
	//어떤 클래스를 상속받을 때 사용하는 예약어가 extends이다.
	//변수를 만들때 어떤 타입인지 명시를 해줘야한다.
//	public Phone(){
//		
//	}
	
	//일반 멤버 메소드 new-
	public void call(){
		System.out.println("전화를 걸어요!");
	}	
}
