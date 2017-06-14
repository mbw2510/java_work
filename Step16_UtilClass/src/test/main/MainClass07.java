package test.main;

import java.util.HashMap;
import java.util.Map;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * HashMap클래스는 Map 인터페이스를 구현해서 만들었기 때문에
		 * HashMap객체는 Map type 으로 받을 수 있다.
		 * 
		 * 주로 사용하는 메소드
		 *  .put()
		 *  .get()
		 *  .clear()
		 *  메소드는 모두 Map인터페이스에 정의된 메소드이다.
		 * 
		 */
		
		Map<String, Car> map=new HashMap<>();
		
		map.put("one", new Car("현대"));
		map.put("two", new Car("기아"));
		map.put("three", new Car("쌍용"));
		
		map.get("one").drive();
		map.get("two").drive();
		
		Car car=map.get("three");
		car.drive();
		
		map.clear();
		
	}
}
