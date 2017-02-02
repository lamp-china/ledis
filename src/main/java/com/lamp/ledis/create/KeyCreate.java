package com.lamp.ledis.create;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.TypeReference;

public interface KeyCreate<T> {
	
	
	public String getKeyPrefix();
	
	public String getKeySuffix(T t);
	
	public String getKey(T t);
	
	public String getKey(String t);
	
	public String getKey(long num);
	
	public Class<T> getEntityClass();
	
	public TypeReference<List<T>> getTypeReferenceList();
	
	public TypeReference<Set<T>>  getTypeReferenceSet();
	
	public TypeReference<Map<Object ,T>>  getTypeReferenceMap();
	

}
