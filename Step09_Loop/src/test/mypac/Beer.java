package test.mypac;

public class Beer {
	//생성자
	public String type;
	
	public Beer(String type){
		//Beer클래스의 생성자에 담긴 String값을 type에 담아보세요.
		//this는 생성된 객체의 해당클래스명을 선택하는 참조값
		this.type=type;
	}
	//일반 맴버 메소드
	public void drink(){
		System.out.println(this.type+"찬형이를 취하게 해요~");
	}
}
