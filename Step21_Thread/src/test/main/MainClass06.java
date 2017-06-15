package test.main;

import test.mypac.Wallet;

public class MainClass06 {
	public static void main(String[] args) {
		//지갑에 돈을 넣는다.
		Wallet.addMoney(100000);
		
		//두개의 스레드에서 경쟁적으로 Waller.getMoney()를 호출한다.
		Runnable run1 = new Runnable(){
			@Override
			public void run() {
				//인출한 돈을 저장할 지역변수
				int totalMoney=0;
				while(true){
					//메소드를 이용해서 돈을 인출한다.
					int money = Wallet.getMoney("김구라");
					//인출할 돈이 없으면 반복문 탈출
					if(money==0)break;
					//인출할 돈을 변수에 누적시킨다.
					totalMoney += money;
				}
				System.out.println("김구라가 총 인출한 돈 : "+totalMoney);
			}
		};
		Runnable run2 = new Runnable(){
			@Override
			public void run() {
				//인출한 돈을 저장할 지역변수
				int totalMoney=0;
				while(true){
					//메소드를 이용해서 돈을 인출한다.
					int money = Wallet.getMoney("원숭이");
					//인출할 돈이 없으면 반복문 탈출
					if(money==0)break;
					//인출할 돈을 변수에 누적시킨다.
					totalMoney += money;
				}
				System.out.println("원숭이가 총 인출한 돈 : "+totalMoney);			
			}
		};
		//두개의 쓰레드 시작시키기
		new Thread(run1).start();
		new Thread(run2).start();
	}
}
