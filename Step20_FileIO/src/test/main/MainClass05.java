package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass05 {
	public static void main(String[] args) {
		File file=new File("C:/myFolder/myMemo.txt");
		try{
			//파일에서 문자열을 읽어들일 수 있는 FileReader 객체 생성
			FileReader fr=new FileReader(file);
			//한번에 5개의 글자를 읽어들일 수 있는 char[] 객체 생성
			char[] buffer = new char[5];
			// /r/n도 문자 갯수로 인식한다.
			//FileReader 객체에 char[]의 참조값을 전달해서
			//읽은 내용을 배열에 저장하도록 한다.
			fr.read(buffer);
			//배열에 저장된 읽은 내용을 한글자식 출력해보기
			for(char tmp:buffer){
				System.out.println(tmp);
			}
		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}
