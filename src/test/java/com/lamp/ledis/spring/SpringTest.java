package com.lamp.ledis.spring;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamp.ledis.commands.RedisCommands ;
import com.lamp.ledis.entity.TestEntity ;

public class SpringTest {

	
	@Test
	public void springStart( ) throws IOException{
		 	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
	        context.start();
	        @SuppressWarnings( "unchecked" )
			RedisCommands<  Integer , TestEntity >  rc = ( RedisCommands< Integer , TestEntity > ) context.getBean( "test" );
	        System.in.read(); // 按任意键退出
	}
}
