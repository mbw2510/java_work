package test.main;

import test.mypac.AttackUnit;

public class MainClass02 {
	public static void main(String[] args) {
		//AttackUnit 객체를 생성해서 attack()메소드를 호출해보세요.
		
		AttackUnit a = new AttackUnit();
		AttackUnit b = new AttackUnit("문병우");
		a.attack();
		System.out.println(b.name);
		
		String name = b.name;
		System.out.println(name);		
		
		
		AttackUnit A = new AttackUnit();
		AttackUnit B = new AttackUnit(10);
		A.attack();
		B.attack();
		//new Attack() + ctrl + space
		
	}
}
