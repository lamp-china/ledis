package com.lamp.ledis.annotation;

import java.lang.annotation.ElementType ;
import java.lang.annotation.Retention ;
import java.lang.annotation.RetentionPolicy ;
import java.lang.annotation.Target ;

@Target({ ElementType.TYPE ,ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationsObject {

	
	String name();
	
	Operation operations();
	
	Operation string() default @Operation(key = "", mapKey = "");
	
	Operation hash()   default @Operation(key = "", mapKey = "");
	
	Operation list()   default @Operation(key = "", mapKey = "");
	
	Operation set()    default @Operation(key = "", mapKey = "");
	
	Operation sortedSet() default @Operation(key = "", mapKey = "");
	
	Operation pubSub()  default @Operation(key = "", mapKey = "");
	
}
