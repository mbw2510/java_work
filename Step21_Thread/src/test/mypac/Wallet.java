package test.mypac;

/*
 * 가상의 지갑 역할을 할 클래스
 * 
 */
public class Wallet {
	//static 멤버 필드
	public static int totalMoney;
	
	//static 멤버 메소드
	public static void addMoney(int money){
		totalMoney += money;
	}
	//돈을 인출하는 static 멤버 메소드
	//요 메소드를 사용할때면 다른건 실행하지 안\\ㅎ
	public static synchronized int getMoney(String name){
		if(totalMoney>0){
			totalMoney -= 1;
			System.out.println(name+" 라 1만원 인출! 현재잔고 : "
					+totalMoney);
			return 1;
		}else{
			System.out.println(name+" 이 인출요청, "
					+ "더이상 인출할 돈이"+"없습니다.");
			System.out.println("현재 잔고 : "+totalMoney);
			return 0;
		}
	}
}
