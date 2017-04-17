package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.ResolveNetProtocol ;

public interface BasicsCommandsElement {

	static final CombinationElement DEL        = CombinationElement.create( ).setComman( "del" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement EXISTS     = CombinationElement.create( ).setComman( "exists" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement EXPIRE     = CombinationElement.create( ).setComman( "expire" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement EXPIREAT   = CombinationElement.create( ).setComman( "expireat" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement PEXPIRE    = CombinationElement.create( ).setComman( "pexpire" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement PEXPIREAT  = CombinationElement.create( ).setComman( "pexpireat" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement PERSIST    = CombinationElement.create( ).setComman( "persist" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement REMANE     = CombinationElement.create( ).setComman( "rename" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
	static final CombinationElement REMANENX   = CombinationElement.create( ).setComman( "renameNX" ).setLength( 2 ).setResolveNetProtocol( ResolveNetProtocol.resolveIntToBooleanNetProtocol ).build( );
	
}
