package test.main;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
 *  MainClass04 를 참고해서 
 *  
 *  Scanner 객체를 이용해서 문자열을 여러줄 입력받고
 *  c:/myFolder/quiz03.txt 파일에 기록해 보세요
 *  
 *  단, "q" 혹은 "Q" 를 입력할때 까지의 문자열만 저장하세요
 *  
 *  hint : StringBuilder 객체 사용하기 
 *  hint : while(true){ } 
 */
public class Quiz03 {
	public static void main(String[] args) {
		
		//키보드로 부터 입력 받을 객체
		Scanner scan=new Scanner(System.in);
		
		String path="c:/myFolder/quiz03.txt";
		//파일 객체
		File file=new File(path);
		
		try{
			//파일에 문자열을 기록하기 위한 객체
			FileWriter fw=new FileWriter(file);
			//문자열을 누적시킬 StringBuilder 객체 생성하기 
			StringBuilder builder=new StringBuilder();
			while(true){
				System.out.print("문자열 입력:");
				String str=scan.nextLine();
				//만일 입력한 문자열이 q 혹은 Q 라면
				if(str.equals("q") || str.equals("Q")){
					break; //반복문 빠져 나오기 
				}
				//입력한 문자열 누적 시키기
				builder.append(str);
				builder.append("\r\n");//개행 기호
			}
			//누적된 문자열 파일에 기록하기
			fw.write(builder.toString());
			fw.close();
			System.out.println("문자열을 기록 했습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}









