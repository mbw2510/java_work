package test.main;

import test.mypac.Emart;
public class MainClass02 {
	public static void main(String[] args) {
		//Emart 객체 생성해서 order()메소드 호출하기
		new Emart().order();
		new Emart().order();
		//각기 다른객체에서 실행한것, new로 2객체를 만들었으니까
		//this 생략이 가능하다??!!
	}
}
