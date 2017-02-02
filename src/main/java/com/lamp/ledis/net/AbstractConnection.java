package com.lamp.ledis.net;

import java.nio.ByteBuffer;

public abstract class AbstractConnection implements Connection{

	NetConfigure configure;
	private ByteBuffer buffer;
	
	private long operationTime;
	
	AbstractConnection(NetConfigure configure){
		this.configure = configure;
		this.buffer    = ByteBuffer.allocate( 8192 );
	}
	
	public void setOperationTime(){
		this.operationTime = System.currentTimeMillis();
	}
	public long getOperationTime(){
		return this.operationTime;
	}

	public ByteBuffer getBuffer(){
		return this.buffer;
	}
}