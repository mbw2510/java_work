package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass04 {
	public static void main(String[] args) {
		String path="c:/myfolder/myMemo.txt";
		File file= new File(path);
		try{
			//File에 문자열을 출력할 수 있는 객체 생성해서 참조값 변수에 담기
			FileWriter fw = new FileWriter(file);
			fw.write("김구라\r\n");
			fw.write("해골\r\n");
			fw.write("원숭이");
			fw.close(); // .close() 하는 시점에 파일이 만들어진다.
			System.out.println("파일에 기록했습니다.");
		}catch(IOException ie){
			ie.printStackTrace();
		}
		
	}
}
