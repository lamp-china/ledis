package com.lamp.ledis.net;

public class PoolConfig {

	private int connectionMode;
	
	private int netMode;
	
	private int select;
	
	private int maxIdle;
	
	private int maxTotal =10;
	
	private int maxWaitMillis;
	
	private boolean testOnBorrow;
	
	private boolean testWhileIdle;

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public int getConnectionMode( ) {
		return connectionMode;
	}

	public void setConnectionMode( int connectionMode ) {
		this.connectionMode = connectionMode;
	}

	public int getNetMode( ) {
		return netMode;
	}

	public void setNetMode( int netMode ) {
		this.netMode = netMode;
	}

	public int getSelect( ) {
		return select;
	}

	public void setSelect( int select ) {
		this.select = select;
	}
	
	
}
