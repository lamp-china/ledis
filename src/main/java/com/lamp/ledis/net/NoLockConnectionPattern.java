package com.lamp.ledis.net;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class NoLockConnectionPattern implements ConnectionPattern{

	private final LinkedBlockingQueue<Connection> lbq = new LinkedBlockingQueue<Connection>();
	
	public NoLockConnectionPattern(NetConfigure configure , PoolConfig poolConfig ){
		for(int i = 0 ; i < poolConfig.getMaxTotal() ; i++){
			lbq.add( new BIOConnection(configure));
		}
	}
	
	@Override
	public Connection getConnection() throws Exception {
		return lbq.poll(2000, TimeUnit.MINUTES);
	}
	@Override
	public void setConnection(Connection conn) {
		lbq.add( conn );		
	}
}
