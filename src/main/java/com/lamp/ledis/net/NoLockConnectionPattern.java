package com.lamp.ledis.net;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class NoLockConnectionPattern implements ConnectionPattern{

	private final LinkedBlockingQueue<Connection> lbq = new LinkedBlockingQueue<Connection>();
	
	private int maxWaitMillis;
	
	public NoLockConnectionPattern(NetConfigure configure , PoolConfig poolConfig ){
		this.maxWaitMillis = poolConfig.getMaxWaitMillis( );
		for(int i = 0 ; i < poolConfig.getMaxTotal() ; i++){
			lbq.add( new BIOConnection(configure));
		}
	}
	
	@Override
	public Connection getConnection() throws Exception {
		return lbq.poll(this.maxWaitMillis, TimeUnit.MINUTES);
	}
	@Override
	public void setConnection(Connection conn) {
		lbq.add( conn );
	}
}
