package test.main;
/*
 * [java data type]
 * 2.숫자형
 * 
 * -정수형 : byte, short, int, long
 * -실수형 : float, double
 */

//main선택해서 + ctrl + space
public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		// 정수형 변수 선언과 동시에 값 대입하기
		byte iByte=10; //1byte
		short iShort=10; //2byte
		int iInt=10; //4byte
		long ilong=10; //8byte
		
		//실수형 변수 선언과 동시에 값 대입하기
		float num1=10.1f; //4byte
		double num2=10.1d;//8byte
		double num3=10.2; //생략 가능
		System.out.println("메인 메소드가 종료됩니다.");		
	}
}
