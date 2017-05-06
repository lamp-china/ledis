package com.lamp.ledis.annotation;

import java.lang.reflect.Method ;
import java.util.HashMap;

public class LedisAanntationCollection {

	
	private static HashMap< Class< ? > , OperationsEntity > operationsEntity_map = new HashMap<>( ) ;
	
	
	public static OperationsEntity getOperationEntity ( Class< ? > clazz ) {
		if ( ! operationsEntity_map.containsKey( clazz ) ) {
			operationsEntity_map.put( clazz , new OperationsEntity( clazz ) ) ;
		}
		return operationsEntity_map.get( clazz ) ;
	}
	
	public void addOperationEntity(Class<?> clazz ){
		OperationList operationList;
		 if( clazz.isInterface( )){
			 Method[] me = clazz.getMethods( );
			 Class<?>  meClazz;
			 for(Method m : me){
				  operationList=  m.getAnnotation( OperationList.class  );
				  if( operationList != null){
					  meClazz = m.getReturnType( );
					  isType(meClazz , false);
					  setOperationListMap( meClazz , operationList );
				  }			 
			 }
			return; 
		 }
		 isType(clazz , true);
		 operationList= clazz.getAnnotation( OperationList.class );
		 setOperationListMap( clazz , operationList );
	}
	
	
	public void setOperationListMap( Class<?>  clazz, OperationList operationList){
		 OperationsObject[] operationsArray = operationList.operationsObject( );
		 OperationsEntity oe;
		 for(OperationsObject operations : operationsArray){
			 oe = getOperationEntity( clazz );
			 oe.setOperationListMap( operations );
		 }
	}
	
	public void isType(Class<?> clazz ,boolean bo){
		if( clazz.equals( Void.class ) || clazz.isInterface( ) || clazz.isAnnotation( ) || clazz.isEnum( ) || clazz.isPrimitive( )){
			  
		}
	}
	
}
