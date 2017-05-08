package com.lamp.ledis.commands;

import java.util.Map ;
import java.util.concurrent.ConcurrentHashMap ;

import com.lamp.ledis.annotation.OperationsEntity ;

public final class CommandsObjectFactory {

	private final static CommandsObjectFactory commandsObjectFactory = new CommandsObjectFactory();
	
	private CommandsObjectFactory(){
		
	}
	
	public static final CommandsObjectFactory getInstance(){
		return commandsObjectFactory;
	}
	
	@SuppressWarnings( "rawtypes" )
	private final Map<String,RedisCommands> redisCommandsMap = new ConcurrentHashMap<>( );
	
	
	@SuppressWarnings( "unchecked" )
	public <T>T getRedisCommands(OperationsEntity operationsEntity){
		if( redisCommandsMap.containsKey( operationsEntity.getName( ))){
			redisCommandsMap.put( operationsEntity.getName( ) , new RedisCommandsImlp<>( operationsEntity ) );
		}
		return ( T ) redisCommandsMap.get( operationsEntity.getName( ) );
	}
	
	
}
