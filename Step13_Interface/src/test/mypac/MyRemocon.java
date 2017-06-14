package test.mypac;

public class MyRemocon extends Object implements Remocon{

	@Override
	public void up() {
		System.out.println("업업업업");
	}

	@Override
	public void down() {
		System.out.println("다운다운");
	}
	//class는 상속받는 것이지만 interface는 구현하는 것
	
	
}
