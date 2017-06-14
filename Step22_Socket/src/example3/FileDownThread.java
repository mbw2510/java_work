package example3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileDownThread extends Thread{
	private Socket socket;
	//생성자
	public FileDownThread(Socket socket){
		//인자로 전달받은 객체를 맴버필드에 저장하기
		this.socket=socket;
		
	}
	
	//새로운 스레드의 실행순서가 시작되는 run()메소드
	@Override
	public void run() {
		//여기가 새로운 쓰레드
		//멤버필드에 저장된 Socket 객체의 참조값을 이용해서 파일
		//다운로드 작업을 한다.
		
		InputStream is = null;
		FileOutputStream fos = null;
		
		try{
			//클라이언트의 ip 주소 읽어오기
			String ip=socket.getInetAddress().getHostAddress();
			//파일 다운로드 경로 구성
			String path="c:/myFolder/"+ip+"image.jpg";
			//입력 받을 수 있는 객체의 참조값
			is=socket.getInputStream();
			//파일에 출력할 수 있는 객체
			fos = new FileOutputStream(path);
			byte[] buffer = new byte[1024];
			//반복문을 돌면서 읽어들인다.
			while(true){
				int readedByte = is.read(buffer);
				if(readedByte==-1)break;
				//읽어들인 만큼 파일에 출력하기
				fos.write(buffer, 0, readedByte);;
				fos.flush();
			}
			System.out.println(ip+" 에서 전송한 파일 저장성공!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(is!=null)is.close();
				if(fos!=null)fos.close();
				if(socket!=null)socket.close();
			}catch(Exception e){}
		}		
		System.out.println("새로운 스레드 종료");
	}//run();
}
