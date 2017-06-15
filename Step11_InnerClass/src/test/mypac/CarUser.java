package test.mypac;
/* * 익명의 클래스를 이용해서 특정 메소드를 간단히 재정의 할 수 있다. */
public class CarUser {
	//멤버필드
	public Car car=new Car(){//이 중괄호는 무엇일까?
		//익명의 innerClass를 호출하는 것
		//class ? extends Car{
		//}
		@Override
		public void drive() {
			System.out.println("내 마음대로 달려요!");
		}
	};
	//멤버 메소드 
	public void useCar(){
		Car car=new Car(){//익명의 local inner Class-메소드안에서 정의되었기 때문
			@Override
			public void drive() {
				System.out.println("달릴까? 말까?");
			}
		};
		car.drive();
	}
	//멤버 메소드
	public void useCar2(){
		new Car(){
			@Override
			public void drive() {
				System.out.println("천천히 달리자!");			
			}
		}.drive();
	}
	
}
