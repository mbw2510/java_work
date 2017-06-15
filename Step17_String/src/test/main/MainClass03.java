package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		String name1="김구라";
		String name2="김구라";
		String name3=new String("김구라");
		String name4=new String("김구라");
		
		boolean result = name1==name2;
		System.out.println("name1:"+name1);
		System.out.println("name3:"+name3);
		
		if(name1==name3){
			System.out.println("참조값이 같아요");
		}else{
			System.out.println("참조값이 달라요");
		}//name3의 id값은 새로 만들었기 때문에 다르다.
		//문자열을 비교할때. 참조값 비교는 의미가 없다.
		//자바에서 문자열을 비교할때 동등비교 연산자( == )로비교 하면 안된다.
		//method로 비교해야한다.
		
		//String 타입의 내용을 비교할때는 .equals()메소드를 이용한다.
		if(name1.equals(name3)){
			System.out.println("method 비교 -> 내용이 같아용");
		}else{
			System.out.println("method 비교 -> 내용이 달라요");
		}
	}
}
