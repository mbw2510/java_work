package test.main;

import java.sql.Connection;

import test.util.DBConnect;

public class cscsc {
	public static void main(String[] args) {
		Connection conn2 = new DBConnect().getConn();
	}
}
