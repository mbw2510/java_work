package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		
		InputStream is = System.in;
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		// 위의 3줄을 한줄로 표현하면
		BufferedReader bre2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문자열 한줄 입력");
		try {
			// BufferedReader 객체를 이용해서 한줄 단위로 읽어들이기
			String line = br.readLine();
			System.out.println("입력한 문자열:"+line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
