package test.main;

import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MainClass05 {
	public static void main(String[] args) {
		OutputStream os = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		try{
			osw.write("여러개의 문자를 한번에 출력해요");
			osw.flush();
			
			// char[] buffer = {'가','나','다','라'};
			
			char[] buffer=new char[4];
			buffer[0]='가';
			buffer[1]='나';
			buffer[2]='다';
			buffer[3]='라';
			
			osw.write(buffer); 
			osw.flush();  // 방출(출력)
			
			// .write() 만이 아닌 .flush() 까지 해줘야만 콘솔창에 출력해준다.
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
