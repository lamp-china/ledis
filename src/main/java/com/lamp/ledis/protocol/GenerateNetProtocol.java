package com.lamp.ledis.protocol;

import java.nio.ByteBuffer;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;

public interface GenerateNetProtocol {
	
	/**
	 * 这样的设计是为了不要出现过多的对象创建，与操作。
	 * 提高性能
	 * @param key
	 */
	/**
	 * bytebuffer 实现也是为了得高性能
	 * @param byteBuffer
	 */
	public void setByteBuffer(ByteBuffer byteBuffer);
	
	
	public byte[] parameter(String str);
	
	public byte[] parameter(long number);
	
	public byte[] parameter( Object t,KeyCreate<Object> keyCreate);
	
	public byte[] parameterList(  List<String> list );
	
	public byte[] parameterListLong(  List<Long>  list );
	
	public byte[] parameterList(  List<Object> list ,KeyCreate<Object> ceyCreate);
	
	public byte[] parameterSet(Object t);
	
	public byte[] parameterListSet(  List<Object> list ,KeyCreate<Object> keyCreate);
	
}