package com.lamp.ledis.net;

public class NetAndPoolConfig {

	private String name;
	
	private NetConfigure netConfigure;
	
	private PoolConfig poolConfig;

	public NetConfigure getNetConfigure( ) {
		return netConfigure;
	}

	public void setNetConfigure( NetConfigure netConfigure ) {
		this.netConfigure = netConfigure;
	}

	public PoolConfig getPoolConfig( ) {
		return poolConfig;
	}

	public void setPoolConfig( PoolConfig poolConfig ) {
		this.poolConfig = poolConfig;
	}

	public String getName( ) {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}
	
	
	
	
}
