package com.lamp.ledis.commands;

import java.util.ArrayList ;
import java.util.List ;

import org.junit.Before ;
import org.junit.Test;

import com.alibaba.fastjson.JSON ;
import com.lamp.ledis.entity.TestEntity;
import com.lamp.ledis.net.ConnectionFactoryTest;
import com.lamp.ledis.utils.KeyCreateUtils ;

public class StringCommandsTest extends ConnectionFactoryTest{
	
	StringCommands<TestEntity> sc;
	TestEntity testEntity = new TestEntity(2 , "hello , laohu");
	
	List<TestEntity> list;
	{
		list = new ArrayList<>( );
		for(int i = 4 ; i<14 ;i++ ){
			list.add( new TestEntity(i , "hello , laohu" + i) );
		}
	}
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
		System.out.println( te );
	}
	
	@Test
	public void mset(){
		sc.mSet( list );
	}
	
	@Test
	public void mget(){
		List<TestEntity> cd = sc.mGet( list );
		System.out.println( JSON.toJSONString( cd ) ) ;
	}
	

}
