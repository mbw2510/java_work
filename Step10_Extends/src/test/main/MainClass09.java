package test.main;

import test.com.Computer;
import test.com.Cpu;
import test.com.NoteBook;

public class MainClass09 {
	public static void main(String[] args) {
		//Computer 클래스는 생성자(Cpu타입을 받는다)를 지정하였다.
		new Computer(new Cpu());
		//Cpu의 참조값을 전달하면서 NoteBook 객체 생성하기
		new NoteBook(new Cpu());
		
		//Cpu 참조값을 전달하면서 NoteBook 객체 생성하기
		NoteBook 
		c1=new NoteBook(new Cpu());
		//메소드 호출하기
	}
}

