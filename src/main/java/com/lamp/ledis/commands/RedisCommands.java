package com.lamp.ledis.commands;

public interface RedisCommands<K , T> extends KeyCommands , ListCommands< T > , HashCommands< K , T > , StringCommands< T >{

	
	
}
