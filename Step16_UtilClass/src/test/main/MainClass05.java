package test.main;

import java.util.HashMap;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		// Key : value 형태로 데이터를 관리하기 위한 HashMap 객체
		// HashMap<key 의 Generic, value의 Generic>
		HashMap<String, Car> map=new HashMap<String, Car>();
		// HashMap 객체에 Car 객체의 참조값 저장하기
		map.put("myCar", new Car("내차"));
		map.put("yourCar", new Car("니차"));
		map.put("ourCar", new Car("우리차"));
		
		map.get("myCar").drive();
		map.get("yourCar").drive();
		
		Car car=map.get("ourCar");
		car.drive();
		map.containsKey("myCar");
	}
}
