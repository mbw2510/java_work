package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass06 {
	public static void main(String[] args) {
		File file=new File("C:/myFolder/myMemo.txt");
		try{
			//파일에서 문자열을 읽어들일 수 있는 FileReader 객체 생성
			FileReader fr=new FileReader(file);
			//문자열을 줄단위로 읽어올 수 있는 BufferReader 객체 생성
			BufferedReader br = new BufferedReader(fr);
			//반복물 돌면서 줄단위로 읽어들이기
			while(true){
				//한줄씩 읽어들이기
				String line=br.readLine();
				//더이상 읽을 문자열이 없다면 break 예약어를 이용해서 빠져나오기
				if(line==null){
					break;
				}
				System.out.println(line);
			}

		}catch(FileNotFoundException fe){
			fe.printStackTrace();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}
