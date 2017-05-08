package com.lamp.ledis.annotation;

import java.lang.annotation.ElementType ;
import java.lang.annotation.Retention ;
import java.lang.annotation.RetentionPolicy ;
import java.lang.annotation.Target ;

@Target({ ElementType.TYPE ,ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Operation {

	String name() default "";

	String prefix() default "";
	
	String separator() default "_";
	
	String key();
	
	String combinationKey() default "";
	
	String mapPrefix() default "";
	
	String mapKey();
	
	String dataSource() default "default";
	
	Pattern[] pattern() default Pattern.DEFAULT;
	
	String sliceKey() default "";
	
	String value() default "";
	
	
}
