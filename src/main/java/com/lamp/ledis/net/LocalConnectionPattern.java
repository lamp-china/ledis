package com.lamp.ledis.net;

public class LocalConnectionPattern implements ConnectionPattern{

	private final ThreadLocal<Connection>  tl = new ThreadLocal<>();
	
	@Override
	public Connection getConnection() throws Exception {
		// TODO 自动生成的方法存根
		Connection con = tl.get();
		if( con == null){
			tl.set( con );
		}
		return con;
	}

	@Override
	public void setConnection(Connection conn) {

	}

}
