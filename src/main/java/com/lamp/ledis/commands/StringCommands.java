package com.lamp.ledis.commands;


import java.util.List;


public interface StringCommands<T>{
	
	
	
	T get(T t);
	
	T get(String t);
	
	T get(long t);
	
	T getSet(T t);
	
	List<T> mGet(List<T> keys);
	
	List<T> mGetString(List<String> keys);
	
	List<T> mGetNumber(List<Number> keys);

	void set(T t);

	//void set(byte[] key, byte[] value, Expiration expiration, SetOption option);
	
	Boolean setNX(T t);
	
	Boolean setNX(T t, Object o);
	
	Boolean setEx(T t);
	
	Boolean setEx(T t, Object o);

	void pSetEx(byte[] key, long milliseconds, byte[] value);

	void mSet(List<T> tuple);

	Boolean mSetNX(List<T> tuple);

	Long incr(T t);

	Long incrBy(T t ,long value);
	/**
	 * 这个方法不做实现，
	 * @param t
	 * @param value
	 * @return
	 */
	Double incrBy(T t , double value);

	Long decr(T t);

	Long decrBy(T t,long value);
/*
	Long append(byte[] key, byte[] value);

	byte[] getRange(T t, long begin, long end);
	
	byte[] getRange(String t, long begin, long end);
	
	byte[] getRange(Number t, long begin, long end);

	void setRange(byte[] key, byte[] value, long offset);

	Boolean getBit(byte[] key, long offset);

	Boolean setBit(byte[] key, long offset, boolean value);

	Long bitCount(byte[] key);

	Long bitCount(byte[] key, long begin, long end);
*/

	Long strLen(T t);

}
