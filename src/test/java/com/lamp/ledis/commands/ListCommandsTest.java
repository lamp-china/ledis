package com.lamp.ledis.commands;

import java.util.ArrayList ;
import java.util.List ;

import org.junit.Test ;

import com.lamp.ledis.entity.TestEntity ;
import com.lamp.ledis.net.ConnectionFactoryTest ;

public class ListCommandsTest extends ConnectionFactoryTest{
	
	TestEntity testEntity = new TestEntity( 2 , "hello , laohu" ) ;
	
	List<TestEntity> llist = new ArrayList<>( );
	List<TestEntity> rlist = new ArrayList<>( );
	
	{
		for(int i = 0 ; i < 11 ; i ++){
			TestEntity testEntity = new TestEntity( 3 , "hello , llist" + i ) ;
			llist.add( testEntity );
			testEntity = new TestEntity( 3 , "hello , rlist" + i ) ;
			rlist.add( testEntity );
		}
	}
	
	
	
	@Test
	public void addData(){
		List<TestEntity> list = lc.lrange(testEntity.getId( ) , 0 , -1);
		System.out.println( "hello lrange : " + list ) ;
		
		testEntity.setName( "hello lpush" );
		long l = lc.lpush( testEntity );
		System.out.println( "lpush return : "  + l ) ;
		list = lc.lrange(testEntity.getId( )+"" , 0 , -1);
		System.out.println("lpush exect  : " +  list ) ;
		
		
		testEntity.setName( "hello rpush" );
		l = lc.rpush( testEntity );
		System.out.println( "lpush return : "  + l ) ;
		list = lc.lrange(testEntity , 0 , -1);
		System.out.println("rpush exect  : " +  list ) ;
		
		l = lc.lpush( llist );
		System.out.println( "lpushList return : "  + l ) ;
		list = lc.lrange(3 , 0 , -1);
		System.out.println("lpushList exect  : " +  list ) ;
		
		l = lc.rpush( rlist );
		System.out.println( "rlist return : "  + l ) ;
		list = lc.lrange(3 , 0 , -1);
		System.out.println("rlist exect  : " +  list ) ;
	}
	
	@Test
	public void getData(){
		TestEntity testEntity = new TestEntity( 3 , "hello , llist" ) ;
		
		TestEntity te = lc.lpop( testEntity.getId( ) );
		System.out.println(  "lpop long return : "  + te) ;
		
		te = lc.lpop( testEntity.getId( ) + "");
		System.out.println(  "lpop String return : "  + te) ;
		
		te = lc.lpop( testEntity );
		System.out.println(  "lpop String return : "  + te) ;
		
		
		te = lc.blpop( testEntity.getId( ) );
		System.out.println(  "blpop long return : "  + te) ;
		
		te = lc.blpop( testEntity.getId( ) + "");
		System.out.println(  "blpop String return : "  + te) ;
		
		te = lc.blpop( testEntity );
		System.out.println(  "blpop String return : "  + te) ;
		
		
		
		te = lc.rpop( testEntity.getId( ) );
		System.out.println(  "rpop long return : "  + te) ;
		
		te = lc.rpop( testEntity.getId( ) + "");
		System.out.println(  "rpop String return : "  + te) ;
		
		te = lc.rpop( testEntity );
		System.out.println(  "rpop String return : "  + te) ;
		
		te = lc.brpop( testEntity.getId( ) );
		System.out.println(  "brpop long return : "  + te) ;
		
		te = lc.brpop( testEntity.getId( ) + "");
		System.out.println(  "brpop String return : "  + te) ;
		
		te = lc.brpop( testEntity );
		System.out.println(  "brpop String return : "  + te) ;
	}
	
	
	@Test
	public void lrange(){
		List<TestEntity> list = lc.lrange( 3 , 0 , -1 );
		System.out.println( list.toString( ) ) ;
		
		list = lc.lrange( 3+"" , 0 , -1 );
		System.out.println( list.toString( ) ) ;
		
		
		list = lc.lrange( new TestEntity(3 , "" ) , 0 , -1 );
		System.out.println( list.toString( ) ) ;
	}
	
	@Test
	public void llenAndLindexAndLset(){
		TestEntity e = new TestEntity(3 , "lset" );
		
		long length = lc.llen( 3  );
		System.out.println(  length ) ;
		
		length = lc.llen( 3+""  );
		System.out.println(  length ) ;
		
		length = lc.llen( e  );
		System.out.println(  length ) ;
		
		
		TestEntity te = lc.lindex( 3 , 0 );
		System.out.println(  te ) ;
		
		te = lc.lindex( 3+"" , 0 );
		System.out.println(  te ) ;
		
		te = lc.lindex( e , 0 );
		System.out.println(  te ) ;	
		
		boolean boo = lc.lset( e , 0 );
		System.out.println(  boo ) ;

		List<TestEntity> list = lc.lrange( new TestEntity(3 , "" ) , 0 , -1 );
		System.out.println( list.toString( ) ) ;
		
		boo = lc.lset( te , 0 );
		System.out.println(  boo ) ;
		
	}
	
	
	
	
	
	
}
