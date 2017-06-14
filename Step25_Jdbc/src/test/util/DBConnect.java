package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * - 아래의 코드를 수행했을 때, Connection 객체의 참조값이 정상적으로
 *   리턴되게 클래스를 설계해보세요
 *   Connection conn = new DBConnect().getConn();
 */

public class DBConnect {
   
   public Connection getConn(){
      
      Connection conn = null;
      
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle driver loading
         String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 oracle DB url 정보
         conn = DriverManager.getConnection(url, "scott", "tiger"); // Connection 객체 참조값 받기
         
         System.out.println("Oracle DB 접속 성공");
      }catch(Exception e){
         e.printStackTrace();
      }
      
      return conn;
   }
}