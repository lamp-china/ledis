package com.lamp.ledis.net;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

public class ConnectionFactory {

	private final  static ConnectionFactory cf = new ConnectionFactory();
	
	private final Map<String , ConnectionPattern> connectionPatternMap = new HashMap< String , ConnectionPattern >();
	
	
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
	
	public void init( List<NetConfigure> netCOnfigureList ){
		
	}
	
	
	public Connection getConnection(){
		
		try {
			return connectionPattern.getConnection();
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ConnectionPattern getConnectionPattern(){
		return this.connectionPattern;
	}
	
	
	public ConnectionPattern getConnectionPattern( String data){
		return this.connectionPatternMap.get( data );
	}
	
	public void setConnection( Connection conn){
		connectionPattern.setConnection( conn );
	}
}
