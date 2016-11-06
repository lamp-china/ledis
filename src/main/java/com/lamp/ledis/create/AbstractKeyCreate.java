package com.lamp.ledis.create;

import com.lamp.ledis.utils.ByteUtils;

public abstract class AbstractKeyCreate<T> implements KeyCreate<T> {
	
	private String stringKey ;
	
	private byte[] byteKey;
	
	
	public AbstractKeyCreate(String key){
		this.stringKey = key;
		this.byteKey   = key.getBytes();
	}

	
	public byte[] getKey(T t){
		return ByteUtils.addBytes(byteKey, getKeySuffix(t));
	}
	
	public byte[] getKey(String key){
		return ByteUtils.addBytes(byteKey, key.getBytes());
	}
	
	public byte[] getKey(Number key){
		return getKey(key.toString());
	}
	
	
	
}
