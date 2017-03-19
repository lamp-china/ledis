package com.lamp.ledis.commands;

import org.junit.Before ;
import org.junit.Test;

import com.lamp.ledis.entity.TestEntity;
import com.lamp.ledis.net.ConnectionFactoryTest;
import com.lamp.ledis.utils.KeyCreateUtils ;

public class StringCommandsTest extends ConnectionFactoryTest{
	
	StringCommands<TestEntity> sc;
	TestEntity testEntity = new TestEntity(1 , "hello , laohu");
	
	TestEntity te ;
	
	@Before
	public void bo(){
		try {
			sc = new StringCommandsImlp<TestEntity>(null, null,KeyCreateUtils.getInstance( ).createKeyCreate( "com.lamp.ledis.entity.TestEntity" , "id" , null ,null,null));
			System.out.println( " commands init succer" ) ;
		} catch ( Exception e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
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
