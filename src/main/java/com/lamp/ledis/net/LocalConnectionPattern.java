package com.lamp.ledis.net;

public class LocalConnectionPattern implements ConnectionPattern{

	private final ThreadLocal<Connection>  tl = new ThreadLocal<>();
	
	private NetConfigure configure ;
	private PoolConfig   poolConfig;
	
	
	public LocalConnectionPattern(NetConfigure configure, PoolConfig poolConfig) {
		super( ) ;
		this.configure = configure ;
		this.poolConfig = poolConfig ;
	}



	@Override
	public Connection getConnection() throws Exception {
		// TODO 自动生成的方法存根
		Connection con = tl.get();
		if( con == null){
			con = new BIOConnection( configure );
			tl.set( con );
		}
		return con;
	}

	@Override
	public void setConnection(Connection conn) {

	}

}
