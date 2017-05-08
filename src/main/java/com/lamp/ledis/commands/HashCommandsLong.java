package com.lamp.ledis.commands;

import java.util.List ;
import java.util.Map ;

public interface HashCommandsLong<K,T>  extends BasicsCommandsLong{
		
	boolean hdel(Long key , K field);
		
	boolean hexists(long key , long field);
		
	T hget(long key , long field);
		
	Map<K,T> hgetall(long key );
		
	long hincrby(Long key   , Long field   , long increment);
	
	List<K> hkeys(long key );
		
	List<T> hvals(long key );	
	
	long hlen(long key );
		
	List<T> hmget(Number key , List<T> t);
	
	boolean hmset(Number key , List<T> t);
		
	boolean hset(Number key , T t);
		
	boolean hsetnx(Number key , T t);

}
