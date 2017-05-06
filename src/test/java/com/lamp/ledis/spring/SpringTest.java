package com.lamp.ledis.spring;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	
	@Test
	public void springStart( ) throws IOException{
		 	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
	        context.start();	 
	        System.in.read(); // 按任意键退出
	}
}
