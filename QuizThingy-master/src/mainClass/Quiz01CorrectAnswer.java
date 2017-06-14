package mainClass;

//1. util 패키지에 있는 myList 클래스를 import 해보세요.
import util.myList;
//6.
import java.util.Random;

public class Quiz01CorrectAnswer {
	//2. 해당 클래스를 Run 했을 때 실행순서가 오는 메소드를 만들어보세요.
	public static void main(String[] args) {
		//3. 해당 메소드 안에 myList 클래스 객체를 만들어 변수 list1에 저장해보세요.
		myList<String> list1=new myList<>();
		
		//4. 변수에 저장된 myList 객체에 "자바는", "재미있는", "프로그래밍", "언어다"라는 문자열을
		//myList 클래스 객체의 메소드를 이용해서 저장해보세요.
		list1.add("자바는");
		list1.add("재미있는");
		list1.add("프로그래밍");
		list1.add("언어다");
		
		//5. list1 객체에 저장된 모든 내용을 콘솔에 출력해보세요.
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		//System.out.println("----------------------------- question 5");
		System.out.println("----------------------------- question 5");
		
		//6. java.util.Random를 import하여 객체를 생성한 뒤
		//1부터 10까지의 무작위의 숫자를 만들어 변수 test1에 저장해보세요.
		Random ran=new Random();
		
		int test1=ran.nextInt(10)+1;
		
		//7. 1부터 10까지의 무작위의 숫자를 만들어서 이미 만들어진 list1 객체에 넣되,
		//이미 넣어진 숫자와는 중복되지않게 myList 클래스의 메소드를 이용해서
		//결과적으로 10개의 수가 순서와는 상관없이 전부 들어가게 만들어보세요.
		for(int i=0; i<10; i++){
			Integer num=ran.nextInt(10)+1;
			
			while(list1.check(num.toString())==true){
				num=ran.nextInt(10)+1;
			}
			
			list1.add(num.toString());
		}
		
		//8. list1 객체에 저장된 모든 내용을 콘솔에 출력해보세요.
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		//System.out.println("----------------------------- question 8");
		System.out.println("----------------------------- question 8");
		
		//9. myList 클래스의 remove() 메소드를 이용하여 list1에 저장된 문자열
		//"자바는", "재미있는", "프로그래밍", "언어다"를 삭제해보세요.
		for(int i=0; i<4; i++){
		list1.remove(i);
		}
		
		//10. list1 객체에 저장된 모든 내용을 콘솔에 출력해보세요.
		for(int i=4; i<list1.size()+4; i++){
			System.out.println(list1.get(i));
		}
		//System.out.println("----------------------------- question 10");
		System.out.println("----------------------------- question 10");
		
		//11. myList 클래스의 메소드를 이용하여 list1에 저장된 모든 내용을 지워보세요.
		list1.clear();
		
		//12. list1 객체에 저장된 모든 내용을 콘솔에 출력해보세요.
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		//System.out.println("----------------------------- question 12");
		System.out.println("----------------------------- question 12");
	}
}
