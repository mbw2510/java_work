package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.Memory;

public class MainClass04 {
	public static void main(String[] args) {
//		new Computer();
		//정의된 내용이 있기때문에 default생성자가 정의되지 않음
		//computer 객체를 생성해보세요.
		Cpu cc = new Cpu();
		Memory mm = new Memory();
		HardDisk hd = new HardDisk();		
		
		new Computer(cc,mm,hd);
		
		//변수에 담긴 값을 이용해서 computer 객체를 생성해보세요
		Computer com = new Computer(cc,mm,hd);
		//경우에 따라서는 null 값을 전달해서 객체를 생성할 수도 있다.
		Computer com2 = new Computer(null,null,null);
		
	}
}
