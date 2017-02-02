package com.lamp.ledis.commands;

import org.junit.Test;

import com.lamp.ledis.entity.TestEntity;
import com.lamp.ledis.entity.TestEntityKeyCreate;
import com.lamp.ledis.net.ConnectionFactoryTest;

public class StringCommandsTest extends ConnectionFactoryTest{
	
	StringCommands<TestEntity> sc = new StringCommandsImlp<TestEntity>(null, null, new TestEntityKeyCreate("id"));
	TestEntity testEntity = new TestEntity(1 , "hello , laohu");
	
	TestEntity te ;
	
	@Test
	public void set(){
		sc.set(testEntity);
	}
	
	@Test
	public void get(){
		te = sc.get(testEntity);
		System.out.println( te.toString() );
	}

}
