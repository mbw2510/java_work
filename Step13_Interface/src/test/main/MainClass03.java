package test.main;

import test.mypac.Remocon;
import test.mypac.TVRemocon;

public class MainClass03 {
	public static void main(String[] args) {
		Object r1=new TVRemocon();
		Remocon r2=new TVRemocon();
		TVRemocon r3=new TVRemocon();
	
		//Remocon 인터페이스의 static final 멤버필드 참조
		String info = Remocon.COMPANY; //interface 이름에 . 필드명 으로 참조되어야 한다.
		int v = Remocon.VERSION;
		String info2 = TVRemocon.COMPANY;
		int v2 = TVRemocon.VERSION;
		
		//참고
		//지역변수 혹은 필드에 final 예약어를 붙이면 상수화 된다.
		//상수 => 수정불가
		//관례상 변수명 혹은 필드명은 모두 대문자로 작성한다.
		final String NAME = "김구라";
		//final (상수) 는 값이 수정이 안된다.
	//	NAME="kim"; 
	
	}
}
