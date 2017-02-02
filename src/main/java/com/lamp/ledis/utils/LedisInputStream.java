package com.lamp.ledis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * 都是为了性能
 * 
 * @author muqi
 *
 */
public class LedisInputStream extends InputStream {

	private InputStream inputStream;
	private boolean is = false;

	public LedisInputStream(InputStream inputStream){
		is = false;
		this.inputStream = inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		is = false;
		this.inputStream = inputStream;
	}

	@Override
	public int read() throws IOException {
		try {
			int i = inputStream.read();
			if (i == -1) {
				if (is) {
					// 异常
				} else {
					is = true;
				}
			}
			return i;
		} catch (IOException e) {
			throw e;
		}
	}

	public byte readbyte() throws IOException {
		return (byte) read();
	}
	
	public byte readHead() throws IOException {
		return readbyte();
	}

	public byte[] readLind(byte[] b, int len) throws IOException {
		int off = 2;
		if (b == null) {
			throw new NullPointerException();
		} else if (off < 0 || len < 0 || len > b.length - off) {
			throw new IndexOutOfBoundsException();
		} else if (len == 0) {
			return null;
		}

		int c = read();
		if (c == -1) {
			return null;
		}
		b[off] = (byte) c;

		int i = 1;
		for (; i < len; i++) {
			c = read();
			if (c == -1) {
				break;
			}
			b[off + i] = (byte) c;
		}

		return null;
	}

	public long readLongCrLf() throws IOException  {
		int b = read();
		long value = 0;
		final boolean isNeg = b == '-';
		if (!isNeg) {
			value = value * 10 + b - '0';
		}
		while (true) {
			b = read();
			if (b == '\r') {
				if (read() != '\n') {

				}
				break;
			} else {
				value = value * 10 + b - '0';
			}
		}
		return (isNeg ? -value : value);
	}

	public boolean readOKCrLf() throws IOException{
		boolean bo = false;
		if( read() == 'O' && read() =='K' ){
			bo = true;
		}
		if (read() == '\r') {
			if (read() != '\n') {
				//异常
			}
		}else{
			//异常
		}
		return bo;
	}
	
	public void readLindBytes(ByteBuffer bb) throws IOException{
		byte b;
		while (true) {
			b = readbyte();
			if (b == '\r') {
				b = readbyte();
				if (b == '\n') {
					break;
				}
			}
			bb.put( b );
		}
	}
	
	
	public void readLindBytes(byte[] by,int limit) throws IOException  {
		byte b;
		while (true) {
			b = readbyte();
			if (b == '\r') {
				b = readbyte();
				if (b == '\n') {
					break;
				}
			}
			by[ limit++] = b;
		}
	}
	public boolean readLind(ByteBuffer bb) throws IOException {
		long length = readLongCrLf();
		if( length  == -1)
			return false;
		readLind( bb, length );
		return true;
		
	}
	
	public void readLind(ByteBuffer bb, long num) throws IOException {
		for (;;) {
			bb.put(   readbyte() );
			if (--num == 0) {
				readbyte();
				readbyte();
				return;
			}
		}
	}
	
	public void readLind(byte[] by, int limit, int num) throws IOException {
		for (;;) {
			by[limit++] = readbyte();
			if (--num == 0) {
				readbyte();
				readbyte();
				return;
			}
		}
	}

}
