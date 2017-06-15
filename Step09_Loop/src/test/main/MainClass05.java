package test.main;

import test.mypac.Beer;

public class MainClass05 {
	public static void main(String[] args) {
		String[] names={"김구라","해골","원숭이","주뎅이","덩어리"};
		//names 배열을 이용해서 확장 for 문을 구성해보세요.
		
		for(String tmp : names){
			//tmp 변수에 참조된 문자열을 콘솔에 출력해보기
			System.out.println(tmp);
		}
		//방 5개짜리 Beer[]객체를 생성해서
		Beer[] beers = new Beer[5];
		//5개의 방에 Beer 객체의 참조값을 넣고
		
//		for(int i=0; i<names.length;i++){
//			String nam = names[i];
//			beers[i]=new Beer(nam);
//			beers[i].drink();
//		}
		
		beers[0]=new Beer("문병우");
		beers[1]=new Beer("문병우");
		beers[2]=new Beer("문병우");
		beers[3]=new Beer("문병우");
		beers[4]=new Beer("문병우");
		
		//확장 for문을 이용해서 Beer객체의 drink()메소드를 호출해보세요.
		for(Beer bang:beers){
			Beer hwang = bang;
			hwang.drink();
		}
	}
}
