package com.cheaptickets.utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "postak@farandhigh.com";
	public static String password = "Purplemints@883";
	public static String[] to ={"postak_shrestha@hotmail.com"};
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="c:\\screenshot\\2017_10_3_14_49_9.jpg";
	public static String attachmentName="error.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.cj.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "root";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/sakila";
	
	
	
	
	
	
	
	
	
}
