package data;

import java.sql.Connection;

public class DbConnector {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="java";
	private String password="12345";
	private String db="java";
	private int conectados=0;
	private Connection conn=null;
}
