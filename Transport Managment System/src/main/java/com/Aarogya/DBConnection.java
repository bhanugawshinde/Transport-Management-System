package com.Aarogya;

import java.sql.Connection;


public class DBConnection {
	public static Connection con= ContextListner.con;;
	public static Connection getConnection() {
		return con;
	}
}
