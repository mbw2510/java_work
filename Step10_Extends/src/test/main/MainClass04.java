
package test.main;

import test.mypac.Car;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		Object c1=new Car();
		
		Phone p = (Phone)c1;
//		p1.call();//따지고 들어갔을때 타입이 달라!
	}
}
