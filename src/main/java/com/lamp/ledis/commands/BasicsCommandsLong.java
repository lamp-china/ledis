package com.lamp.ledis.commands;

public interface BasicsCommandsLong {

	
	boolean del(Long t);
	
	boolean exists(Long t);
	
	
	boolean expire(Long key   , int seconds);
	
	
	boolean pexpire(Long key   , int milliseconds);
	
	boolean expireat(Long key   , long timestamp);
	
	
	boolean pexpireat(Long key   , long milliseconds);
	
	
	boolean persist(String key );
	
	
	boolean rename(Long key   , Long newkey);

	
	boolean renamenx(Long key   , Long newkey);
}
