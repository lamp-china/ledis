package com.lamp.ledis.configuration;

import com.lamp.ledis.utils.BasicAttributes;

public class SingleConfiguration {
	
	private String host;
	
	private int    post = BasicAttributes.DEFAULT_POST;
	
	private int    select;
	
	private int    connectionMode;
	
	private int    netMode;
	
	private int    connectionNum;

	public String getHost ( ) {
		return host ;
	}

	public void setHost ( String host ) {
		this.host = host ;
	}

	public int getPost ( ) {
		return post ;
	}

	public void setPost ( int post ) {
		this.post = post ;
	}

	public int getSelect ( ) {
		return select ;
	}

	public void setSelect ( int select ) {
		this.select = select ;
	}

	public int getConnectionMode ( ) {
		return connectionMode ;
	}

	public void setConnectionMode ( int connectionMode ) {
		this.connectionMode = connectionMode ;
	}

	public int getNetMode ( ) {
		return netMode ;
	}

	public void setNetMode ( int netMode ) {
		this.netMode = netMode ;
	}

	public int getConnectionNum ( ) {
		return connectionNum ;
	}

	public void setConnectionNum ( int connectionNum ) {
		this.connectionNum = connectionNum ;
	}
	
}
