package test.main;

import java.util.HashMap;

import test.mypac.Car;

public class MainClass06 {
	public static void main(String[] args) {
		//HashMap 객체의 두번째 Generic class 를 Object로 지정하면
		//모든 type 데이터를 저장할 수 있다.
		HashMap<String, Object> map =
				new HashMap<String, Object>();
		map.put("num",1);
		map.put("name", "김구라");
		map.put("isMan", true);
		map.put("car", new Car("Benz"));
		
		//리턴 타입이 Object이므로 원래 type으로 casting 해야한다.
		int num = (int)map.get("num");
		String name = (String)map.get("name");
		boolean isman = (boolean)map.get("isMan");
		Car car = (Car)map.get("car");
		map.get("num"); //object type으로 받는다.
	}
}
