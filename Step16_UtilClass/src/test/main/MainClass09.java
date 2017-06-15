package test.main;

import java.util.Random;

/*
 *   random 클래스
 *   - 무작위 숫자를 얻어내고 싶을때 사용한다.
 *   
 *   
 */
public class MainClass09 {
	public static void main(String[] args) {
		//Random 객체 생성해서 참조값을 변수에 담기
		Random ran = new Random();
		System.out.println(ran.nextInt(99));
		//0~9사이의 랜덤한 정수
		int num1 = ran.nextInt(10);
		
		//0~1사이의 랜덤한 정수
		int num2 = ran.nextInt(2);
		
		//0~14사이의 랜덤한 정수
		int num3 = ran.nextInt(25);
		
		//-20 ~ 20 사이의 랜덤한 정수
		int num4 = ran.nextInt(41)-20;
	}
}
