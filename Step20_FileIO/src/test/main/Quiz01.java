package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * MainClass04를 참고해서 
 * Scanner객체를 이용해서 문자열을 1줄 입력받고
 * 입력받은 내용을
 * c:myFolder/quiz01.txt 파일에 기록해보세요. 
 * 
 */

public class Quiz01 {
	public static void main(String[] args) {
		String path="c:/myfolder/quiz01.txt";
		File file= new File(path);		
		
		System.out.println("메모장에 쓸 말을 써봐라 : ");
		Scanner scan=	new Scanner(System.in);
		String msg=scan.nextLine();//여기 몰랐음
		


		try {
			FileWriter fw = new FileWriter(file);
			fw.write(msg);
			fw.close();
			System.out.println("기록완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
