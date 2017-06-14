package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		
		//int값이 들어있는 배열의 type은 아래와 같이 표시한다.
		
		//정수값을 배열로 관리하고 싶다면...
		int[] nums = {10, 20, 30, 40, 50};
		//실수값을 배열로 관리하고 싶다면...
		double[] nums2 = {10.1, 10.2, 10.3, 10.4, 10.5};
		//String type 데이터를 배열로 관리하고 싶다면...
		String[] names={"kim","lee","park","huh","han"};
		//기본데이터 타입 배열과 String 타입 배열에는 약간의 차이가 있다.
		//디버그 모드로 확인하라		
		int[] nums3=new int[5];
		//각각의 인덱스를 참조해서 대입연산자로 값 대입하기
		nums3[0]=10;
		nums3[1]=20;
		nums3[2]=30;
		
		//int type 밸류를 받을 수 있는 5개 칸짜리 객체를 생성
		String[] names2=new String[3];
		//String type을 담을 수 있는 방 5개짜리 배열객체 생성
		//각각의 인덱스를 참조해서 대입연산자로 String type data 대입하기
		names2[0]="kim";
		names2[1]="lee";
		names2[2]="park";
				
		//자바는 array를 한번 만들게 되면 방의 크기를 변경하는것이 불가능하다.
		//때문에 잘 쓰이지는 않는다.
		
		Car[] carr={new Car(),new Car()};

		
		System.out.println(nums);
		System.out.println(nums2);
		System.out.println(names);
		System.out.println(nums3);
		//nums,nums2에는 array의 키값이 들어있다. 즉 heap영역에 만들어진다는 이야기
	}
}
