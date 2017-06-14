package test.main;

import java.util.Stack;

/*
 *  [ Stack ]
 *  
 *  -선입 후출 구조로 데이터를 관리하고 싶을때 사용한다.
 *  -순서가 있는 데이터이다.(인덱스가 있음)
 *  
 *  데이터저장 : .push(데이터)
 *  데이터빼내기 : .pop()
 *  모두삭제 : .clear()
 */

public class MainClass15 {
	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<String>();
		stack1.push("하나");
		stack1.push("두울");
		stack1.push("세엣");
		
		String a = stack1.pop();
		String b = stack1.pop();
		String c = stack1.pop();
		
		stack1.push("네엣");
		stack1.push("다섯");
		stack1.push("여섯");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		//pop의 특징은 stack에서 가져올 뿐만 아니라 지운다.
	}
}
