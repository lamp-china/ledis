package com.lamp.ledis.net;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import com.lamp.ledis.utils.LedisInputStream;

public interface Connection {

	public LedisInputStream getInputStream();
	
	public OutputStream getOutputStream();
	
	public void close() throws IOException;
	
	public void setOperationTime();
	
	public long getOperationTime();
	
	public ByteBuffer getBuffer();
}
