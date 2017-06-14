package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("메인 메소드가 시작되었습니다.");
		//getNum()메소드가 리턴해주는 int값을
		//int type a 라는 변수에 대입 연산자로 담기
				
		int a=getnum();
		//a는 지역변수 local 에서 만들어진것은 메소드 안에서만 사용가능하다.
		
		System.out.println("메인 메소드가 리턴됩니다.");
	}
	//void 자리에 올수있는것들 byte,short,int,long,float,double,char,boolean,String
	//자바의 데이터 타입이 무한대로 올수있다.
	//메소드를 호출한 그 위치로 int type 데이터를 return 해 주는
	//static 멤버 메소드
	public static int getnum(){
		//int로 뭘 돌려줄것인데? 를 정의해줘야한다.
		System.out.println("getNum()호출됨");
		//999를 메소드를 호출한 위치로 돌려주기
		return 999;
	}
}
