package com.lamp.ledis.annotation;

public @interface Operations {

	Operation operations();
	
	Operation string();
	
	Operation hash();
	
	Operation list();
	
	Operation set();
	
	Operation sortedSet();
	
	Operation pubSub();
	
}
