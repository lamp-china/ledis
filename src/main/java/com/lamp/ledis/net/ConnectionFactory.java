package com.lamp.ledis.net;

public class ConnectionFactory {

	private final  static ConnectionFactory cf = new ConnectionFactory();
	
	private ConnectionPattern connectionPattern;
	
	private ConnectionFactory(){
		
	}
	
	public static final ConnectionFactory getInstance(){
		return cf;
	}
	
	public void init(){
		init( new NetConfigure() , new PoolConfig());
	}
	
	
	public void init(NetConfigure configure ,PoolConfig poolConfig ){
		if(connectionPattern == null){
			connectionPattern = new NoLockConnectionPattern(configure, poolConfig);
		}
	}
	
	public Connection getConnection(){
		
		try {
			return connectionPattern.getConnection();
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	public void setConnection( Connection conn){
		connectionPattern.setConnection( conn );
	}
}
