package test.mypac;

public class YourRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("your리모콘으로 세상을 바꾸어요 업업");
	}

	@Override
	public void down() {
		System.out.println("your리모콘으로 세상을 바꾸어요 다운다운");		
	}
	
}
