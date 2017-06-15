package test.main;

import java.io.IOException;
import java.io.OutputStream;

public class MainClass04 {
	public static void main(String[] args) {
		// 콘솔에 출력할 수 있는 객체의 참조값을
		// OutputStream type 변수에 담기
		OutputStream os = System.out;
		
	
		try {
			
			os.write(97); // 출력할 준비 //keycode - 97 - a
			os.write(98); //keycode - 98 - b
			os.write(99); //keycode - 99 - c
			os.write(100); //keycode - 100 - d
			os.flush();	  // 방출(출력)
		
			// byte[] 배열 객체 만들고
			byte[] buffer={65, 66, 67, 68};
			// write() 메소드 호출하면서 배열의 참조값 전달하기
			os.write(buffer);
			// buf의 index 위치부터 size만큼의 바이트를 출력한다. 
			os.write(buffer, 2, 1);
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
 *  class OutputStream{
 *   	
 *   	public void write(int a){}		--> os.write(10);
 *   										byte[] b = {10,20};
 * 		public void write(byte[] b){}	--> os.write(b);
 *  
 * 		write(byte[] a, int b, int c){} --> os.write(b, 10, 20);
 *  }
*/
