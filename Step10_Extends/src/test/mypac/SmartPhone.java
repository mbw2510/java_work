package test.mypac;

public class SmartPhone extends HandPhone{//이미 다른기능이 있기 때문에 추가기능만 집어넣어주면됨
	
	//빈공간에서 ctrl + space
	//부모 클래스에 정의된 메소드 재정의 (오버라이딩)
	@Override
		public void takePicture() {
			System.out.println("1000만 화소의 사진을 찍어요!");
		}
	
	public void DoInternet(){
		System.out.println("인터넷을 해요!");
	}
}
