package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import test.mypac.Car;
import test.mypac.Lottonum;

/*
 * 실행했을때 
 * 
 * 로또 번호 6개를 무작위로 콘솔창에 출력하는 코드를 작성해 보세요.
 * 
 * 로또 번호 : 1~45 범위의 숫자중에서 중복되지 않는 6개의 숫자
 */

public class MainClass98 {
	public static void main(String[] args) {
		Random lotto = new Random();
		
//		HashMap<String, Lottonum> lottery=new HashMap<String, Lottonum>();
//		// HashMap 객체에 Lottonum 객체의 참조값 저장하기
//		lottery.put("lot1", new Lottonum(lotto.nextInt(46)));
//		lottery.put("lot2", new Lottonum(lotto.nextInt(46)));
//		lottery.put("lot3", new Lottonum(lotto.nextInt(46)));
//		lottery.put("lot4", new Lottonum(lotto.nextInt(46)));
//		lottery.put("lot5", new Lottonum(lotto.nextInt(46)));
//		lottery.put("lot6", new Lottonum(lotto.nextInt(46)));

		List<Integer> lotto1 = new ArrayList<>();
		 //for문?
		 //if문??
		 //if문을 사용해야 할 것 같다.
		 //숫자 여섯개
		 //숫자 여섯개를 반복해서 가져오고 비교.
		
		for(int i=0; i<45; i++){
			lotto1.add(i+1);
		}
		
		for(int i=0; i<6; i++){
			int pick2 = lotto1.size();
			int pick1 = lotto.nextInt(pick2);
			System.out.println(lotto1.get(pick1));
			lotto1.remove(pick1);
		}
		System.out.println("종료");
	}
}
