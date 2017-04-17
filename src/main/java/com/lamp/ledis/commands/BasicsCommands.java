package com.lamp.ledis.commands;

public interface BasicsCommands<T> {
	
	boolean del(T t);
	
	boolean del(String t);
	
	boolean del(Long t);
	
	boolean exists(T t);
	
	boolean exists(String t);
	
	boolean exists(Long t);
	
	
	boolean expire(T key      , int seconds);
	
	boolean expire(String key , int seconds);
	
	boolean expire(Long key   , int seconds);
	
	boolean pexpire(T key      , int milliseconds);
	
	boolean pexpire(String key , int milliseconds);
	
	boolean pexpire(Long key   , int milliseconds);
	
	
	boolean expireat(T key      , long timestamp);
	
	boolean expireat(String key , long timestamp);
	
	boolean expireat(Long key   , long timestamp);
	
	
	boolean pexpireat(T key      , long milliseconds);
	
	boolean pexpireat(String key , long milliseconds);
	
	boolean pexpireat(Long key   , long milliseconds);
	

	boolean persist(T key      );
	
	boolean persist(String key );
	
	boolean persist(Long key   );
	
	boolean rename(T key      ,T newkey);
	
	boolean rename(String key ,String newkey );
	
	boolean rename(Long key   , Long newkey);
	
	boolean renamenx(T key      ,T newkey);
	
	boolean renamenx(String key , String newkey);
	
	boolean renamenx(Long key   , Long newkey);
	
	
	
}
