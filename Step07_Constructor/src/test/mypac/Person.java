package test.mypac;

public class Person {
	public int age; //연령
	public double weight; //몸무게
	public String name; //이름
	
	//연령과 몸무게와 이름을 인자로 전달받는 생성자를 정의하고
	//인자로 전달받은 값을 맴버필드에 저장하는 작업을 해보세요.
	
	public Person(int age, double weight, String name){
		this.age=age;
		this.weight=weight;
		this.name=name;
	}
	//정보를 콘솔에 출력하는 메소드
	public void showInfo(){
		System.out.println("나이:"+age+" 몸무게:"+weight+" 이름:"+name);
	}
}
