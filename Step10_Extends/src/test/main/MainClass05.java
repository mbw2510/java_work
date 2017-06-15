package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		HandPhone p1= new HandPhone();
		p1.call();//phone 클래스에 정의된 기능 사용가능
		p1.mobileCall();
		p1.takePicture();
		//상속을 언제받느냐 부모로 부터 받은 기능을 다쓰고 추가적으로 기능을 쓰고 싶을때.
		
		SmartPhone p2= new SmartPhone();//2단 상속
		p2.call(); //phone 클래스에 정의된 기능
		p2.mobileCall(); //HandPhone 클래스에 정의된 기능
		p2.takePicture(); //HandPhone 클래스에 정의된 기능
		p2.DoInternet(); //HandPhone 클래스에 정의된 기능
		
		//부모로 받은 기능중의 몇가지를 재정의 할 수 있다.
		//overriding - 덮어쓰기 기능
		
		// new SmartPhone(); 객체를 새로 만들게 되면 heap영역이 어떻게 될것인가??
		//상속받은 클래스의 객체를 생성하면 heap라인에는
		//SmartPhone->HandPhone->Phone->Object 상속 라인에 있는 모든것들이 새로 만들어진다?!
		//단 new SmartPhone();의 id(참조값) 아래에 부모요소들이 전부 만들어져. 한 id값으로 참조할 수 있게 된다.
		//한 id값으로 관리가 되기 때문에 부모 요소의 기능들을 사용할 수 있는 것이다!.
		// 
		
	}
}
