package com.lamp.ledis.annotation;

public @interface Operation {

	String name() default "";

	String prefix() default "";
	
	String separator() default "_";
	
	String[] key();
	
	String mapPrefix() default "";
	
	String mapKey();
	
	String dataSource() default "default";
	
	Pattern[] pattern() default Pattern.DEFAULT;
	
	String sliceKey() default "";
}
