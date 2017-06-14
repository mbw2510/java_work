package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.util.DBConnect;

/*
 * JDBC(Java DataBase Connectivity)
 * 
 * -java 와 database 연동하기
 * -java 에서 db에 접근하여 데이터 조회, 삽입, 수정, 삭제를 가능하게 함 
 * 
 * -select 읽어오기
 * 
 */

public class MainClass04 {
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
			//다른 곳의 오라클을 접속하려면 ip주소를 적어야한다.
			//@ip주소:port번호
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url,"scott","tiger");
			System.out.println("Oracle DB접속 성공");
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		//필요한 객체의 참조값을 담을 변수 만들기
		PreparedStatement pstmt=null;
		//Query  의 결과값을 받을 변수 만들기
		ResultSet rs=null;
		
		try{//실행할 sql 문 구성하기
			String sql="select num,name,addr From member";
			//prepared statement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//select를 전달하면 ResultSet 객체로 리턴한다.
			
			rs=pstmt.executeQuery();
			while(rs.next()){//커서바로 다음에 select될 row가 있는지 확인하고 있으면 true를 리턴하고
				//없으면 false를 반환한다. 그리고 어떤 row를 가리키는지 까지 설정한다.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println(num+"|"+name+"|"+addr);				
			}


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
