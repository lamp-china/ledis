package com.lamp.ledis.create;

public interface KeyCreate<T> {
	
	public byte[] getKeySuffix(T t);
	
	public byte[] getKey(T t);
	
	public byte[] getKey(String t);
	
	public byte[] getKey(Number num);
	

}
