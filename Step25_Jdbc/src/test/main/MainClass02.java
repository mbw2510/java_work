package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC(Java DataBase Connectivity)
 * 
 * -java 와 database 연동하기
 * -java 에서 db에 접근하여 데이터 조회, 삽입, 수정, 삭제를 가능하게 함 
 * 
 */

public class MainClass02 {	
	public static void main(String[] args) {
		//oracle 에 scott/tiger 계정으로 접속해서 member 테이블에
		//회원 한명의 정보를 저장하려고한다.
		//연결객체가 필요하다!!!!!!
		
		//DataBase 연결객체를 담을 지역변수 선언
		Connection conn=null;
		//java.sql
		try{
			//오라클 드라이버 로딩하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 oracle db url 정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url,"scott","tiger");
			System.out.println("Oracle DB접속 성공");
		}catch(Exception e){
			e.printStackTrace();
		}		

		int num = 1;
		
		//필요한 객체의 참조값을 담을 변수 만들기
		PreparedStatement pstmt=null;
		try{//실행할 sql 문 구성하기
			String sql="delete from member where num=?";
			//prepared statement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값 바인딩하기, 물음표의 순서
			pstmt.setInt(1, num);
			
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");	
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
		System.out.println("메인 메소드가 리턴됩니다.");
	}
}
