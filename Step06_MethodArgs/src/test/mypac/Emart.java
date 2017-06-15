package test.mypac;

/*
 * this라는 예약어는 해당클래스로 객체가 생성되었을때
 * 생성된 객체의 참조값을 지칭하는 예약어 이다.
 */


public class Emart {
	
	//주문하는 메소드
	public void order(){
	//order메소드 안에서 상품을 만드는 메소드와 상품을 배달하는 메소드를 실행하고 싶은데.
	//new Emart()의 참조값을 알수가없다. 그렇기에 만들어진 참조값을 읽는 this가 필요하다
		System.out.println("order메소드 호출됨");
		//order()메소드가 호출되었을때 동일한 객체의 메소드 호출하기
		
		this.make();
		deliver();//같은 객체안의 메소드를 실행하는것이라 this.을 생략가능
	}
	//상품을 만드는 메소드
	public void make(){
		System.out.println("make메소드 호출됨");
	}
	//상품을 배달하는 메소드
	public void deliver(){
		System.out.println("deliver 메소드 호출됨");
	}
}
