package test.com;

public class Computer {
	//맴버필드
	private Cpu cpu;
	
	//Cpu type 의 참조값을 전달 받는 생성자
	public Computer(Cpu cpu){
		//전달 받은 값을 멤버필드에 저장하기
		this.cpu=cpu;
	}
	
	//연산을 하는 메소드
	public void operation(){
		System.out.println("연산을해요");
	}
	
}
