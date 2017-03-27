package com.lamp.ledis.annotation;

import java.util.LinkedList ;
import java.util.List ;

public class LedisAanntationCollection {

	private List< OperationEntity > operationList = new LinkedList<>( );
	
	
	
	public void addOperationEntity(String name, String prefix, String separator, String key, String mapPrefix, String mapKey, String server,
			Pattern[] pattern, String sliceKey , Class< ? > clazz){
		operationList.add( new OperationEntity( name , prefix , separator , key , mapPrefix , mapKey , server , pattern , sliceKey ,clazz) );
	}
	
	
	public List<OperationEntity> getOperationList(){
		return this.operationList;
	}
}
