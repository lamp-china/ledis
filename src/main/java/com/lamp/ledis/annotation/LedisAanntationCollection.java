package com.lamp.ledis.annotation;

import java.lang.reflect.Method ;
import java.util.HashMap;

public class LedisAanntationCollection {

	
	private  HashMap< String , OperationsEntity > operationsEntity_map = new HashMap<>( ) ;
	
	private void isExistence(String name){
		if( name  == null ){
			
		}
		if( "".equals( name )){
			
		}
		if( !operationsEntity_map.containsKey( name )){
			
		}
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
		 OperationsEntity oe ;
		 for(OperationsObject operations : operationsArray){
			 isExistence( operations.name( ) );
			 oe = new OperationsEntity( );
			 oe.setName(  operations.name( ) );
			 oe.setOperationListMap( operations ,  clazz);
			 operationsEntity_map.put( operations.name( ) , oe );
		 }
	}
	
	public HashMap< String , OperationsEntity >  getOperationsEntityMap(){
		return this.operationsEntity_map;
	}
	
	public void isType(Class<?> clazz ,boolean bo){
		if( clazz.equals( Void.class ) || clazz.isInterface( ) || clazz.isAnnotation( ) || clazz.isEnum( ) || clazz.isPrimitive( )){
			  
		}
	}
	
}
