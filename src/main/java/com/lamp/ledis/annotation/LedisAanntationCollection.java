package com.lamp.ledis.annotation;

import java.util.LinkedList ;
import java.util.List ;

public class LedisAanntationCollection {

	private List< OperationEntity > operationList = new LinkedList<>( );
	
	
	
	public void addOperationEntity(Class<?> clazz ){
		 OperationList operationList= clazz.getAnnotation( OperationList.class );
		 OperationsObject[] operationsArray = operationList.operationsObject( );
		 Operation defaults,string, hash , list,set,sortedSet,pubSub;
		 for(OperationsObject operations : operationsArray){
			 defaults  = operations.operations( );
			 string    = operations.string( );
			 hash      = operations.hash( );
			 list      = operations.list( );
			 set       = operations.set( );
			 sortedSet = operations.sortedSet( );
			 pubSub    = operations.pubSub( );
			 if( defaults == null && string  == null &&  hash  == null &&  list == null && set == null && sortedSet == null && pubSub == null ){
				 
			 }
			 if( defaults == null){
				 
			 }else{
				 
			 }
		 }
	}
	
	private void comparison(Operation defaults , Operation conn){
		if( conn == null){
			
		}
	}
	public List<OperationEntity> getOperationList(){
		return this.operationList;
	}
}
