package test.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		
		try{
			Scanner scan=new Scanner(System.in);
			System.out.println("나눌 수(젯수) 입력 : ");
			int num1 = scan.nextInt();
			
			System.out.println("나누어 지는(피젯수) 수 입력 : ");
			int num2 = scan.nextInt();
			
			//num2를 num1으로 나눈 몫을 변수에 저장
			int mog=num2/num1;
			//num2를 num1으로 나눈 나머지를 변수에 저장
			int na=num2%num1;
			
			//정수를 정수로 나누면 결과값은 정수만 나온다.
			//0을 나눠보게되면 Exception이 발생한다. - ArithmeticException발생.
			//Exception이 발생하면 발생이후 실행과정이 중단된다.
			
			
			System.out.println(num2+" 를 "+num1+" 으로 나눈 결과");
			System.out.println("몫:"+mog+" 나머지:"+na);
		}catch(Exception e){
			//모든 익센셥의 부모타입
			//예외정보 출력해보기
			e.printStackTrace();
			System.out.println("예외가 발생했습니다.");
		}
		
		//try블럭에서 수행된 것중에 변수명, 타입명이 나오면 실행순서가 catch이후로 뛴다.

		
		System.out.println("메인 메소드가 리턴됩니다.");
		
	}
}
