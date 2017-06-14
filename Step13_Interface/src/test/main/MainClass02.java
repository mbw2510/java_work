package test.main;

import test.mypac.Remocon;

public class MainClass02 {
	public static void main(String[] args) {
		//익명의 local inner class를 이용해서 Remocon type 참조값
		//얻어내섯 Remocon type 변수에 담기
		Remocon a = new Remocon(){

			@Override
			public void up() {
				// TODO Auto-generated method stub
				System.out.println("볼륨을 업업");
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				System.out.println("볼륨을 다운");
			}			
		};
		a.up();
		a.down();
		
	}
}
