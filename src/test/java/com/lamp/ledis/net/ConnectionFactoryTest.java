package com.lamp.ledis.net;

import org.junit.Before;
import org.junit.Test;

import com.lamp.ledis.commands.HashCommands ;
import com.lamp.ledis.commands.HashCommandsImlp ;
import com.lamp.ledis.commands.StringCommands ;
import com.lamp.ledis.commands.StringCommandsImlp ;
import com.lamp.ledis.entity.TestEntity ;
import com.lamp.ledis.utils.KeyCreateUtils ;

public class ConnectionFactoryTest {

	
	protected StringCommands< TestEntity > sc ;
	
	protected HashCommands<Integer ,  TestEntity > hc ;
	
	@SuppressWarnings( "unchecked" )
	@Before
	public void bo ( ) {
		try {
			sc = new StringCommandsImlp< TestEntity >( null , null , KeyCreateUtils.getInstance( )
					.createKeyCreate( "com.lamp.ledis.entity.TestEntity" , "id" , null , null , null ) ) ;
			
			hc = new HashCommandsImlp<Integer ,  TestEntity >( null , null , KeyCreateUtils.getInstance( )
					.createKeyCreate( "com.lamp.ledis.entity.TestEntity" , "id" , null , "name" , null ) ) ;
			System.out.println( " commands init succer" ) ;
		} catch ( Exception e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace( ) ;
		}
	}
	
	@Before
	public void info() {
		ConnectionFactory.getInstance().init();
	}

	@Test
	public void connectionTest() {

	}

}
