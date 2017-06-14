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

public class MainClass05 {
	public static void main(String[] args) {
		//oracle 에 scott/tiger 계정으로 접속해서 member 테이블에
		//회원 한명의 정보를 저장하려고한다.

		//필요한 객체의 참조값을 담을 변수 만들기
		PreparedStatement pstmt=null;
		//Query  의 결과값을 받을 변수 만들기
		ResultSet rs=null;
		//Connection 객체의 참조값 얻어오기
		Connection conn=new DBConnect().getConn();
		
		try{//실행할 sql 문 구성하기
			String sql="select num,name,addr From member ORDER By num ASC";
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
