package test.main;

import java.util.HashSet;
import java.util.Iterator;

/*
 *  HashSet
 *  
 *  -순서가 없다. index없어!
 *  -키값도 없다. 
 *  -중복을 허용하지 않는다.
 *  
 *  값을 넣어줄때?
 *  set.add
 */

//Arraylist -> list interface 구현
//Hashmap -> map interface 구현
//Hashset -> set interface 구현

/*
 * 기억해두어야할것
 * List a = new ArrayList();
 * Map b = new HashMap();
 * Set c = new HashSet();
 */

public class MainClass11 {
	public static void main(String[] args) {
		//HashSet 객체를 생성해서 참조값을 변수에 담기
		HashSet<String> set=new HashSet<String>();
		set.add("김구라");
		set.add("해골");
		set.add("원숭이");
		set.add("주뎅이");
		set.add("김구라");
		set.add("덩어리");
		set.add("주뎅이");
		
		System.out.println("set.size() : "+set.size());
		
		//"문자"-문자가같으면 참조값을 같은걸로 인식한다.
		
		//↓반복자 이터레이터
		//.iterator() 메소드를 이용해서 Iterator(반복자) 객체를 얻어온다.
		Iterator<String> it=set.iterator();
		//cursor 다음에 데이터가 있는지 확인해서 있는 동안에만
		//반복문을 수행한다.
		//cursor 개념
		while(it.hasNext()){
			String tmp=it.next();
			System.out.println(tmp);
		}
	}
}
