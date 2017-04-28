package com.lamp.ledis.annotation;

public @interface OperationsObject {

	Operation operations();
	
	Operation string();
	
	Operation hash();
	
	Operation list();
	
	Operation set();
	
	Operation sortedSet();
	
	Operation pubSub();
	
}
