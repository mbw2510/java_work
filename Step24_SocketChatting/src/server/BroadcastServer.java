package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 *  [ 문자열 전송 약속 ]
 *  
 *  0#id                  => 새로운 클라이언트 접속 메세지
 *  1#id#message      => 대화 메세지
 *  2#id                  => 대화방 탈퇴 메세지
 *  3#id1, id2, id3 ...      => 대화 참여자 목록 메세지
 */

public class BroadcastServer {
   // static 맴버필드
   static List<ServerThread> threadList; // ServerThread 의 참조값을 담은 Generic List
   
   
   public static void main(String[] args) {
      // ArratList 객체 생성해서 참조값을 static 맴버필드에 저장
      threadList = new ArrayList<>(); // 이거 없으면 threadList.add(thread); 할때 NullPointException 발생
      
      ServerSocket serverSocket = null;
      try{
         serverSocket = new ServerSocket(5000);
         while(true){
            System.out.println("클라이언트의 접속을 대기....");
            Socket socket = serverSocket.accept();
            /*
             * 생성자의 인자로 클라이언트와 연결된 Socket 객체를 
             * 전달하면서 객체를 생성하고 스레드를 시작 시킨다.
             */
            ServerThread thread = new ServerThread(socket);
            thread.start();
            // 생성한 스레드 객체의 참조값을 List 에 누적 시킨다.
            BroadcastServer.threadList.add(thread); // BroadcastServer 생략가능 (클래스 명에 점찍어서 참조할수 있는 필드는  static을 붙여줘야해)
            
         }
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(serverSocket!=null)serverSocket.close();
         }catch(Exception e){}
      }
   }
   
   // 스레드 객체를 생성할 클래스를 inner class 로 정의하기
   public static class ServerThread extends Thread{
      // 맴버필드
      Socket socket;
      String id; // 아이디(대화명) 을 저장할 필드
      BufferedReader br;
      BufferedWriter bw;
      
      // 생성자
      public ServerThread(Socket socket){
         this.socket=socket;
      }
      
      @Override
      public void run() {
         try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열을 줄단위로 읽어 들일려고 BufferedReader 로 포장을 한 것.
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 문자열을 줄단위로 출력하려고 BufferedWriter 로 포장을 한 것.
            boolean isRun = true;
            // 반복문 돌면서 읽어들인다.
            while(isRun){
               // 전송된 문자열이 있으면 한줄 읽어들이기
               String msg = br.readLine();
               if(msg == null){ // null 이면 접속이 끊긴 상태
                  
                  isRun=false;
               }else{
                  // # 으로 구분해서 문자열을 배열로 얻어온다.
                  String[] result = msg.split("#");
                  // String[] 의 0번방 참조
                  int msgType = Integer.parseInt(result[0]);
                  // 0 or 1 or 2 or 3 이다
                  //메세지 Type 에 따라서 switch 문으로 분기 한다. 
                  switch(msgType){
                  case 0: //새로운 참여자 입장
                     //아이디를 맴버필드에 저장한다
                     id=result[1];
                     //대화방 참여자 목록을 방송한다.
                     sendClientList();
                     break;
                  case 1: //대화메세지 도착
                     //대화 메세지를 방송한다.
                     sendMessage(msg);
                     break;
                  case 2: //대화 참여자 탈퇴 
                     //탈퇴 메세지를 방송한다. 
                     sendMessage(msg);
                     //스레드 배열에서 해당 스레드 제거 
                     threadList.remove(this);
                     
                     //해당 스레드 종료
                     isRun=false;
                     //대화 참여자 목록을 다시 보내준다.
                     sendClientList();
                     break;
                  case 3: //대화 참여자 목록 도착 
                     //참여자 목록을 방송한다. 
                     sendClientList();
                     break;
                  }
               }
            }
            
         }catch(Exception e){
            e.printStackTrace();
         }finally{
            try{
               if(br!=null)br.close();
               if(bw!=null)bw.close();
               if(socket!=null)socket.close();
            }catch(Exception e){}
         }// try
      }// run
      
      // 대화 참여자 목록을 모든 클라이언트에게 방송하는 메소드
      public void sendClientList() throws IOException{
         String data = "3";
         for(int i=0; i<threadList.size(); i++){
            ServerThread tmp = threadList.get(i);
            if(i==0){
               data = data+"#"+tmp.id;
            }else{
               data = data+","+tmp.id;
            }
         }
         sendMessage(data);
      }
      
      //모든 클라이언트에게 문자열을 보내는 메소드
      public void sendMessage(String msg) throws IOException{
         for(ServerThread tmp: threadList){
            tmp.bw.write(msg);
            tmp.bw.newLine();
            tmp.bw.flush();
         }
      }
      
   }// class ServerThread
   
}