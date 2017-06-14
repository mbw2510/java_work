package test.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * 	[Quiz1]
 *  1. Scanner 객체를 이용해서 문자열을 5번 입력받아서
 *  입력받은 문자열을 ArrayList객체에 저장하고
 *  2. 저장된 문자열을 순서대로 콘솔창에 출력 해보세요.
 *  
 *  [Quiz2]
 *  1.Scanner 객체를 이용해서 문자열을 5번 입력받아서
 *  입력받은 문자열을 HashSet 객체에 저장하고
 *  2.저장된 문자열을 모두 콘솔창에 출력해보세요.
 */


public class MainClass13 {
	public static void main(String[] args) {

		ArrayList<String> quiz1=new ArrayList<>();
		//문자열을 저장할 ArrayList 객체를 생성해서 참조값 변수에 담기
		Set<String> quiz2=new HashSet<>();
		
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		for(int i=0; i<5; i++){
			System.out.println("quiz1 입력할 단어를 쳐라 : ");
			String word=scan1.nextLine();
			quiz1.add(word);
		}
		for(int j=0; j<5; j++){
			System.out.println(quiz1.get(j));
		}
		for(int k=0; k<5; k++){
			System.out.println("quiz2 입력할 단어를 쳐라 : ");
			String word=scan2.nextLine();
			quiz2.add(word);
		}
		Iterator<String> it=quiz2.iterator();
		while(it.hasNext()){
			String tmp=it.next();
			System.out.println(tmp);
		}
		
	}
}
