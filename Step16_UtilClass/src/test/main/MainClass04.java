package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

/*
 * ArrayList 는 List 인터페이스를 구현하였기 때문에
 * ArrayList 객체는 List type 으로 받을 수 있다.
 * 주로 사용하는 메소드
 * .add()
 * .get()
 * .remove()
 * .size()
 * .clear()
 * 등의 메소드는 모두 List 인터페이스에 명시된 메소드이다.
 *
 */

public class MainClass04 {
	public static void main(String[] args) {
		//ArrayList 객체 생성해서 List type 변수에 참조값 담기
		List<Car> cars = new ArrayList<>();
		//주요 메소드 사용해보기
		cars.add(new Car("A"));
		cars.add(new Car("B"));
		cars.add(new Car("c"));
		
		Car c = cars.get(0);//0번방에 저장된 참조값 얻어오기
		cars.remove(1); //1번방 삭제
		int size = cars.size();//방의 갯수 얻어오기
		cars.clear();//모든 방 제거하기
	}
}
