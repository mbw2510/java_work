package test.mypac;
/*
 *  [ interface ]
 *  
 *  - 생성자를 가지고 있지 않다 (객체 생성 불가)
 *  - 추상 메소드만 정의 할 수 있다.
 *  - 필드는 static final(상수) 멤버필드만 가질 수 있다.
 *  - 상수, 값이 한번 정해지면 바뀌지 않는다.  
 *  - 데이터 type 역할을 할 수 있다.
 *  
 *  //변수선언 시에 생성자가 없어 객체를 새로 생성할 수 없고 , 클래스가 아니라 상속을 통한 오버라이드도 안되어 힘들다. 
 */
public interface Remocon {
	//필드 정의하기
	public static final String COMPANY="LG";
	public static final int VERSION=1;//interface 에서는 static final 생략가능
	
	//메소드 정의하기
	public void up();
	public void down(); //abstract 생략가능
	//interface에 있는 메소드는 형태만을 구현해야한다. abstract라는 뜻
}
