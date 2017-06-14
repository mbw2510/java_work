package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * c:/myFolder 를 엑세스 할 수 있는 File 객체 생성해서
		 * 참조값을 변수에 담기
		 */
		
		String path = "c:/myFolder/index.html";
		File file1=new File(path);
		
		
		
		if(file1.exists()){
			System.out.println(path+" 는 이미 존재합니다.");
			//디렉토리인지 판별
			if(file1.isDirectory()){
				System.out.println(path+" 는 디렉토리 입니다.");
				System.out.println(file1.toString());
			}else{
				System.out.println(path+" 는 파일입니다.");
			}
		}else{	
			System.out.println(path+" 는 존재하지 않습니다.");
			try {
				//파일 만들기
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
