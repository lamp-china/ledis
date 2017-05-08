package com.lamp.ledis.commands;

public interface BasicsCommandsString {

	
	boolean del(String t);
	
	boolean exists(String t);
	
	boolean expire(String key , int seconds);
	
	boolean pexpire(String key , int milliseconds);
	
	boolean expireat(String key , long timestamp);
	
	boolean pexpireat(String key , long milliseconds);
	
	boolean persist(String key );
	
	boolean rename(String key ,String newkey );
		
	boolean renamenx(String key , String newkey);
		
}
