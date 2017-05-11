package com.lamp.ledis.entity;

public class TestValue implements Value<Integer , String , TestEntity>{



	@Override
	public TestEntity setValue( Integer k , String v ) {
		TestEntity te = new TestEntity( );
		te.setName( v );
		te.setId( k );
		return te;
	}
}
