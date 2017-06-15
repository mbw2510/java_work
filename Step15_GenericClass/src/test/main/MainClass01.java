package test.main;

//<> 꺽쇠 안쪽에 집어 넣는 것을 generic Class라고 한다.
//type을 자유자재로 바꾸는 능력!
import test.mypac.Apple;
import test.mypac.AppleBox;
import test.mypac.FruitBox;
import test.mypac.Orange;
import test.mypac.OrangeBox;

public class MainClass01 {
	public static void main(String[] args) {
		//AppleBox객체 생성해서
		AppleBox box1=new AppleBox();
		//Apple 객체 담기
		box1.push(new Apple());
		
		//OrangeBox객체 생성해서
		OrangeBox box2=new OrangeBox();
		//Orange 객체 담기
		box2.push(new Orange());
		
		FruitBox<Apple> box3=new FruitBox<Apple>();
		box3.push(new Apple());
		
		FruitBox<Orange> box4=new FruitBox<Orange>();
		box4.push(new Orange());
		
	}
}
