package com.lamp.ledis.net;

public interface ConnectionPattern {
	
	public Connection getConnection() throws Exception ;
	
	public void setConnection(Connection conn)  ;
}
