package test.main;
//aa
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("메인메소드가 시작되었습니다.");
		
		int num=10;
		
		//반복문 for사용해보기		
		for(int i=0; i<10; i++){
			//반복되는 동안에 i는 0~9까지 1씩 증가한다.
			int tmp=i;
			System.out.println(i);
			System.out.println(tmp);
			//i라는 지역변수는 for문이 실행되는 동안에만 사용할 수 있다.
			//i는 반복문이 긑난후 사라짐
			//tmp라는 지역변수는 만들어지고 사라지고를 반복한다.
		}
		// int num=20;
		//↑같은 변수를 중복해서 선언할 수 없다.
		for(int i=0; i<10; i++){
			int tmp=i;
			System.out.println(i);
			System.out.println(tmp);
			//위와같은 특성으로 여러번 선언해도 상관없다.
		}
		System.out.println("메인메소드가 종료되었습니다.");
	}
}
