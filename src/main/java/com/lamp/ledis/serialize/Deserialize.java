package com.lamp.ledis.serialize;

public interface Deserialize {

	public <T> T execute(byte[] by , Class<T> clazz) ;
}
