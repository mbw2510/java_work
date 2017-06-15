package test.main;

import test.factory.MyFactory;
public class MainClass06 {
	public static void main(String[] args) {
		//MyFacroty 클래스에 정의된 static 멤버 메소드를 모두 호출해보세요
		//리턴해주는 데이터가 있다면 변수에 담아보세요.
		System.out.println("메인 메소드 시작~");
		MyFactory.printMsg();
		int GG =MyFactory.getCount();
		String MM =MyFactory.getMsg();
		String VV = MM;
		//참조값(id, 키값)을 복사해준것
		int HH = GG;
		//value값 복사
		System.out.println(GG);
		System.out.println(MM);
		System.out.println("메인메소드 종료");
		//객체는 field와 method로 이루어져 있다.
		
	}
}
