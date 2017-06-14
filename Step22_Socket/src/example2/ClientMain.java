package example2;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 *  [ Socket 클라이언트 프로그램 작성순서 ]
 *  
 *  1. Socket 객체 생성 : 생성됨과 동시에 서버에 소켓 접속을 시도함
 *     - 접속할 서버의 ip 주소와 port 번호가 필요하다
 *  
 *  2. Socket 객체를 이용해서 서버와 통신하기
 *  
 *  3. 필요한 작업을 완료한 후 Socket 객체 닫아주기
 */
public class ClientMain {
	public static void main(String[] args) {
		//Scanner 객체를 이용해서 서버에 전송할 문자열을 입력 받는다.
		Scanner scan = new Scanner(System.in);
		System.out.println("서버로 전송할 메세지 입력 : ");
		String msg=scan.nextLine();
		
		//필요한 객체를 담을 변수 만들기
		Socket socket=null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try{
			/*
			 *  new Socket("ip주소", port 번호)
			 *  - 객체를 생성하는 시점에 연결 요청이 되고
			 *  - 객체의 참조값이 리턴되면 Socket 연결이 성공한 것이다.
			 */
			socket=new Socket("192.168.0.122", 5000);
			System.out.println("Socket 연결 성공!");
			//서버에 출력 할 수 있는 객체의 참조값 얻어오기
			os=socket.getOutputStream();
			osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
			//문자열 출력
			bw.write(msg);
			bw.newLine();//개행기호 출력
			bw.flush();//방출
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(os!=null)os.close(); //null체크를 하는 이유는 중간에 Exceotion이 발생하면
				if(osw!=null)osw.close();//참조값이 안들어가는 경우가 있다.
				if(bw!=null);bw.close();
				if(socket!=null)socket.close();//소켓은 나중에 닫아줘야한다.
			}catch(Exception e){}
		}
		System.out.println("메인 메소드가 종료 됩니다.");
	}
}







