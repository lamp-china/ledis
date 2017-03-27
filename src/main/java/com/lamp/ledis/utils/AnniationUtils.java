package com.lamp.ledis.utils ;

import com.lamp.ledis.annotation.LedisAanntationCollection ;
import com.lamp.ledis.annotation.Operation ;
import com.lamp.ledis.annotation.Operations ;

public class AnniationUtils {

	public static void readAnniation ( Class< ? > clazz , LedisAanntationCollection lac ) {
		Operations operations = clazz.getAnnotation( Operations.class ) ;

		if ( operations != null ) {
			for (Operation operation :  operations.peration( ) ){
				readOperation( clazz, operation , lac );
			}
		}

		Operation operation = clazz.getAnnotation( Operation.class ) ;
		if ( operation != null ) {
			readOperation( clazz, operation , lac );
		}
	}
	
	
	private static void readOperation(Class< ? > clazz , Operation operation , LedisAanntationCollection lac ){
		
	}
	
}
