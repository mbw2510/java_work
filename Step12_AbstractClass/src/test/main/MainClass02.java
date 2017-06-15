package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;
import test.mypac.YourWeapon;

public class MainClass02 {
	public static void main(String[] args) {
		Weapon w1=new MyWeapon();
		//MyWeapon 객체를 부모타입인 Weapon 타입으로 상속받아도
		//아무 문제가 없는것이 확인된다.
		//추상클래스인 Weapon을 타입역할로 사용할 수 있는 이유는
		//메소드가 완전하지 않은 것이지 type으로서의 문법은 맞기때문이다.
		w1.prepare(); //MyWeapon의 부모요소인 Weapon의 멤버메소드 실행
		w1.attack(); //MyWeapon의 부모요소인 Weapon의 추상메소드 attack()을
					 //MyWeapon이 override 한 내용으로 실행
		Weapon y1 = new YourWeapon();		
		y1.prepare();
		y1.attack();		
	}
	
}
