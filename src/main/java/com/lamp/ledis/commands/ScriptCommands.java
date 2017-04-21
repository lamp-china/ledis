package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.ResolveNetProtocol ;

/**
 * 只有两个命令，script load，evalsha
 * 直接读取xml文件，
 * @author laohu
 *
 */
public interface ScriptCommands {

	static final CombinationElement SCRIPT_LOAD = CombinationElement.create( ).setComman( "script load" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveStringNetProtocol ).build( );
	
	/**
	 * 这里不太可能使用 ams，
	 */
	static final CombinationElement EVALSHA = CombinationElement.create( ).setComman( "evalsha" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveStringNetProtocol ).build( );
}