package com.lamp.ledis.commands;

import java.util.List ;

public interface ListCommands<T> extends BasicsCommands< T > {

	
	T blpop(T t );
	
	T blpop(long t );
	
	T blpop(String t );
	
	T blpop(T t , int timeout);
	
	T blpop(long t , int timeout);
	
	T blpop(String t , int timeout);
	
	
	T brpop(T t );
	
	T brpop(long t );
	
	T brpop(String t );
	
	T brpop(T t , int timeout);
	
	T brpop(long t , int timeout);
	
	T brpop(String t , int timeout);
	
	
	T brpoplpush(T source , T destination );
	
	T brpoplpush(long source ,long destination );
	
	T brpoplpush(String source ,String destination);
	
	T brpoplpush(T source , T destination ,int timeout);
	
	T brpoplpush(long source ,long destination ,int timeout);
	
	T brpoplpush(String source ,String destination, int timeout);
	
	
	
	T lindex(T t  , int index);
	
	T lindex(long t ,int index);
	
	T lindex(String t ,int index);
	
	/**
	 * 这个操作很少使用，然后这个操作如果使用泛型是一件很头疼的事情
	 * @param key
	 * @param pivot
	 * @param value
	 * @return
	 */
	long linsert(String key , String pivot , String value);
	
	long llen(T key);
	
	long llen(String key);
	
	long llen(long key);
	
	T lpop(T key);
	
	T lpop(String key);
	
	T lpop(long key);
	
	long lpush(T value);
	
	long lpush(List<T> value);
	
	long lpushx(T value);
	
	List<T> lrange(T key , int start , int stop);
	
	List<T> lrange(String key , int start , int stop);
	
	List<T> lrange(long key , int start , int stop);
	
	/**
	 * 一种少用的方法，不做优化处理
	 * @param key
	 * @param num
	 * @param value
	 * @return
	 */
	long  lren(String key , int num , String value);
	
	boolean lset(T value , int index);
	
	boolean ltrim(T key , int start , int stop);
	
	boolean ltrim(String key , int start , int stop);
	
	boolean ltrim(long key , int start , int stop);
	
	T rpop(T t );
	
	T rpop(long t );
	
	T rpop(String t );
	
	
	T rpoplpush(T source , T destination );
	
	T rpoplpush(long source ,long destination );
	
	T rpoplpush(String source ,String destination );
	
	long rpush(T value);
	
	long rpush(List<T> value);
	
	long rpushx(T value);
}
