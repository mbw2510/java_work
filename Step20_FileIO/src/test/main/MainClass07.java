package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass07 {
	public static void main(String[] args) {
		//필요한 객체를 담을 변수 만들기
		FileInputStream fis = null;//파일에서 읽어들이기 위한 객체
		FileOutputStream fos = null;
		
		try {
			//필요한 객체를 생성해서 참조값을 변수에 담기
			fis=new FileInputStream("c:/myFolder/myImage.png");
			fos=new FileOutputStream("c:/myFolder/myImage2.png");
			
			//한번에 읽어들일 byte의 크기를 고려해서 byte[]객체 생성
			byte[] buffer=new byte[1024];//1024개의 byte알갱이를 담을 수 있다.
			while(true){
				//FileInputStream 객체의 read()메소드 호출하면서
				//메소드의 인자로 byte[]객체를 전달해서 읽어들인다. 읽으면서 저장하고 저장한 숫자를 리턴한다.
				int readedByte=fis.read(buffer);
				System.out.println(readedByte);
				//더이상 read()가 읽을 것이 없을때 -1을 return 한다.
				if(readedByte==-1)break;
				//읽은 만큼 출력하기
				fos.write(buffer, 0, readedByte); //buffer의 배열의 0번째인덱스 부터 읽은인덱스 만큼 출력을 해라
				fos.flush();//방출
			}
			System.out.println("파일을 복사 했습니다.");
			//요까지 들어왔단건 예외가 발생하지 않았다는 뜻이다.
			
		} catch (Exception e) {//예외가 발생하면 실행순서가 들어온다.
			e.printStackTrace();
		}finally{//예외가 발생하지 않아도 무조건 실행순서가 들어오는 구간
			try {
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
