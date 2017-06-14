package test.main;

import test.mypac.Bakery;
//import된 경로를 참고해보세요.
import test.mypac.Bakery.Bread;

public class MainClass01 {
	public static void main(String[] args) {
		new Bakery("종로지점").getBread().eat();
		
		//위의 작업을 세줄로 표현하면
		Bakery bakery=new Bakery("을지로지점");
		Bread bread=bakery.getBread();
		bread.eat();
		
		new Bakery("시청지점").eatCola();
	}
}
//이너클래스가 뭔지, 로칼 이너클래스가 뭔지
//추상클래스가 뭔지
//인터페이스가 뭔지