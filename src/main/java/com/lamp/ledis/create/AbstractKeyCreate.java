package com.lamp.ledis.create;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.TypeReference;

public abstract class AbstractKeyCreate<T> implements KeyCreate<T> {
	
	private String stringKey ;
	
	private byte[] byteKey;
	
	private Class<T> clazz;
	public AbstractKeyCreate(String key){
		this.stringKey = key;
		if( key != null)
			this.byteKey   = stringKey.getBytes();
	}

	
	public String getKey(T t){
		return getKeySuffix(t);
	}
	
	public String getKey(String key){
		return key;
	}
	
	public String getKey(int key ){
		return getKey( key );
	}
	public String getKey(long key){
		return getKey( Long.toString( key ));
	}
	
	public String getKeyPrefix(){
		return stringKey;
	}
	
	public String getKey(Integer key){
		return getKey( key.longValue( ) );
	}
	
	public String getKey(Long key){
		return getKey( key.longValue( ) );
	}
	
	
	
	public Class<T> getEntityClass() {
		return clazz;
	}

	@Override
	public TypeReference<List<T>> getTypeReferenceList() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TypeReference<Set<T>> getTypeReferenceSet() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public TypeReference<Map<Object, T>> getTypeReferenceMap() {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
