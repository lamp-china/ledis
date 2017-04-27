package com.lamp.ledis.annotation;

import java.util.LinkedList ;
import java.util.List ;

public class LedisAanntationCollection {

	private List< OperationEntity > operationList = new LinkedList<>( );
	
	
	
	public void addOperationEntity(Operations[] operationsArray){
		 Operation defaults,string, hash , list,set,sortedSet,pubSub;
		 for(Operations operations : operationsArray){
			 defaults  = operations.operations( );
			 string    = operations.string( );
			 hash      = operations.hash( );
			 list      = operations.list( );
			 set       = operations.set( );
			 sortedSet = operations.sortedSet( );
			 pubSub    = operations.pubSub( );
		 }
	}
	
	
	public List<OperationEntity> getOperationList(){
		return this.operationList;
	}
}
