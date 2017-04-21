package com.lamp.ledis.commands;

import java.util.List ;
import java.util.Map ;


/**
 * 无法确定，
 * @author muqi
 *
 * @param <K>
 * @param <T>
 */
public interface HashCommands<K , T> extends BasicsCommands< T >{

	
	boolean hdel(T key);
	
	boolean hdel(String key , K field);
	
	boolean hdel(Long key , K field);
	
	boolean hdel(List<T> key);
	
	
	boolean hexists(T key);
	
	boolean hexists(String key , String field);
	
	boolean hexists(Long key , Long field);
	
	
	T hget(T key);
	
	T hget(String key , String field);
	
	T hget(Long key , Long field);
	
	
	Map<K,T> hgetall(K key);
	
	Map<K,T> hgetall(String key );
	
	Map<K,T> hgetall(Long key );
	
	long hincrby(K key , long increment);
	
	long hincrby(String key , String field , long increment);
	
	long hincrby(Long key   , Long field   , long increment);
	
	List<K> hkeys(T key);
	
	List<K> hkeys(String key );
	
	List<K> hkeys(Long key );
	
	
	List<T> hvals(T key);
	
	List<T> hvals(String key );
	
	List<T> hvals(Long key );
	
	
	long hlen(T key);
	
	long hlen(String key );
	
	long hlen(Long key );
	
	
	List<T> hmget(List<T> t);
	
	List<T> hmget(String key , List<T> t);
	
	List<T> hmget(Number key , List<T> t);
	
	boolean hmset(List<T> t);
	
	boolean hmset(String key , List<T> t);
	
	boolean hmset(Number key , List<T> t);
	
	boolean hset(T t);
	
	boolean hset(String key , T t);
	
	boolean hset(Number key , T t);
	
	boolean hsetnx(T t);
	
	boolean hsetnx(String key , T t);
	
	boolean hsetnx(Number key , T t);
}
