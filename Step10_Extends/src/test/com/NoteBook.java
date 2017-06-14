package test.com;

public class NoteBook extends Computer{

	//CPu타입을 인자로 전달받는 생성자
	public NoteBook(Cpu cpu) {
		//부모 생성자를 호출하면서 Cpu의 참조값 전달하기
		//반드시 생성자의 첫번째 라인에 위치해야한다!
		super(cpu);//부모클래스를 의미
		// TODO Auto-generated constructor stub
	}
	//클래스를 extends한 것 뿐인데 오류가 발생한다!
	//실행하지 않아도 오류가 발생하는것은 컴파일이 안된다는뜻, 문법이 맞지않다는뜻
	
	//Computer객체는 Cpu타입의 인자를 전달해야 생성이 될 수 있다.
	//부모생성자를 만들기 위해서 전달해야하는 것을 자식생성자에서 받아서 부모에게로 넘겨주는 코드가 필요하다.
	
	@Override
	public void operation() {
		super.operation();
		//super. 부모의 참조값
		System.out.println("이동중에 연산을 해요!");
	}
	
	
	
}

//super() = 인자를 받아서 부모요소에게 전달하는 것!