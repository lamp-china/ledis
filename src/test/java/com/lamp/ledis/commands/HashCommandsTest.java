package com.lamp.ledis.commands;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.junit.Test ;

import com.lamp.ledis.entity.TestEntity ;
import com.lamp.ledis.net.ConnectionFactoryTest ;

public class HashCommandsTest extends ConnectionFactoryTest{
	
	
	@Test
	public void setAndExistsAndgetAnddel(){
		TestEntity te = new TestEntity(100 ,1,"set" );
		hc.hset( te );
		boolean boo = hc.hexists( te );
		System.out.println(  boo ) ;
		
		boo = hc.hexists( 100,1 );
		System.out.println(  boo ) ;
		
		boo = hc.hexists( 100+"",1+"" );
		System.out.println(  boo ) ;
		
		TestEntity tt = hc.hget( te );
		System.out.println( tt ) ;
		tt = hc.hget( 100,1  );
		System.out.println( tt ) ;
		tt = hc.hget( 100+"",1+""  );
		System.out.println( tt ) ;
		
		boo = hc.hdel( te );
		System.out.println( boo  ) ;
	}
	
	
	
	@Test
	public void msetAndmgetAndGetallAndhkeysAndhvalueAndHlen(){
		List< TestEntity > list = new ArrayList<>( );
		for(int i = 0 ; i < 20 ; i++){
			list.add( new TestEntity( 1001 , i , "mset") );
		}
		TestEntity t = list.get( 0 );
		
		boolean boo = hc.hmset( list );
		System.out.println( boo ) ;
		List< TestEntity > getList =hc.hmget( list );
		System.out.println( getList ) ;
		
		Map< Integer , TestEntity > getAll = hc.hgetall( list.get( 0 ).getId( ) );
		System.out.println( getAll ) ;
		getAll = hc.hgetall( t.getId( ) +"");
		System.out.println( getAll ) ;
		getAll = hc.hgetall( t);
		System.out.println( getAll ) ;
		
		List<Integer> keyList = hc.hkeys( t );
		System.out.println( keyList ) ;
		keyList = hc.hkeys( t.getId( ) );
		System.out.println( keyList ) ;
		keyList = hc.hkeys( t );
		System.out.println( keyList ) ;
		
		List<TestEntity>  valueList = hc.hvals( t );
		System.out.println( valueList ) ;
		valueList = hc.hvals( t.getId( ) );
		System.out.println( valueList ) ;
		valueList = hc.hvals( t );
		System.out.println( valueList ) ;
		
		long  len = hc.hlen( t );
		System.out.println( len ) ;
		len = hc.hlen( t.getId( ) );
		System.out.println( len ) ;
		len = hc.hlen( t.getId( )+"" );
		System.out.println( len ) ;
				
	}
	
	
	@Test
	public void test(){
		TestEntity te = new TestEntity(2001 ,1,"set" );
		for( int i = 0 ; i< 10 ; i++ ){
			hc.hincrby( te , 1 );
			Map< Integer , TestEntity > getAll = hc.hgetall( te );
			System.out.println( getAll ) ;
		}
	}
	
	
}
