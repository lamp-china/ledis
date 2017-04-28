package com.lamp.ledis.annotation;

public @interface OperationsName {
	String operations();
	
	String string();
	
	String hash();
	
	String list();
	
	String set();
	
	String sortedSet();
	
	String pubSub();
}
