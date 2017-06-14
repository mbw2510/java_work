package test.star;

public class Marine {
	//move 는 일반 멤버 메소드
	//heap 영역에다가 뭔가를 만드는 것을 객체를 생성한다.
	//만드는 방법은 new Marine();
	//class는 설계도에 불과하다.
	//일반 멤버 메소드를 실행할때는 아래 방식으로
	//new Marine(); 은 키값을 갖는다ㅏ.
	//move()를 실행하려면 id(키값).move();
	
	//객체는 field와 method를 가지는데
	//field는 static, heap등의 영역. method는 기능
	public void move(){
		System.out.println("마린이 움직여요!! 무브무브");
	}
}
