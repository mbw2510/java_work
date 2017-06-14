package test.mypac;

public class MyWeapon extends Weapon{
	//추상클래스를 extends 하면 override가 의무화 된다.
	//부모의 구성품(메소드)가 완성되지 않은 것이 있기 때문에...
	@Override
	public void attack() {
		System.out.println("지상 공격을 해요!");
	}
}
