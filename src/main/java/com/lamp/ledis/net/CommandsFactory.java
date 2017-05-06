package com.lamp.ledis.net;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandsFactory {

	private static final CommandsFactory  commandsFactory = new CommandsFactory();
	
	private CommandsFactory(){}
	
	public CommandsFactory getInstance(){
		return commandsFactory;
	}
	
	private final Map< String , Object >   commandsMap = new ConcurrentHashMap<>( );
	
	public <T>T getCommands(){
		
	}
	
}
