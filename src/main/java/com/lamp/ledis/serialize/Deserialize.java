package com.lamp.ledis.serialize;

public interface Deserialize {

	@SuppressWarnings("rawtypes")
	public Object execute(byte[] by , Class clazz) ;
}
