package com.lamp.ledis.commands ;

import java.util.ArrayList ;
import java.util.List ;

import org.junit.Before ;
import org.junit.Test ;

import com.alibaba.fastjson.JSON ;
import com.lamp.ledis.entity.TestEntity ;
import com.lamp.ledis.net.ConnectionFactoryTest ;
import com.lamp.ledis.utils.KeyCreateUtils ;

public class StringCommandsTest extends ConnectionFactoryTest {


	TestEntity testEntity = new TestEntity( 2 , "hello , laohu" ) ;

	List< TestEntity > list ;
	List< TestEntity > listMsetNX = new ArrayList<>( ) ;
	List< String > listString ;
	List< Integer > listIntger ;
	{
		list = new ArrayList<>( ) ;
		listString = new ArrayList<>( ) ;
		listIntger = new ArrayList<>( ) ;
		for ( int i = 4 ; i < 14 ; i++ ) {
			list.add( new TestEntity( i , "hello , laohu" + i ) ) ;
			listString.add( i + "" ) ;
			listIntger.add( i ) ;
		}
		
		for ( int i = 14 ; i < 20 ; i++ ) {
			listMsetNX.add( new TestEntity( i , "hello , laohu" + i ) ) ;
		}
	}
	TestEntity te ;



	@Test
	public void set ( ) {

		sc.set( testEntity ) ;
	}

	@Test
	public void get ( ) {
		te = sc.get( testEntity ) ;
		System.out.println( te ) ;
		te = sc.get( testEntity.getId( ) ) ;
		System.out.println( te ) ;
		te = sc.get( testEntity.getId( ) + "" ) ;
		System.out.println( te ) ;
	}

	@Test
	public void getSet ( ) {
		testEntity.setName( "hello laohu" ) ;
		te = sc.getSet( testEntity ) ;
		System.out.println( te ) ;
	}

	@Test
	public void mget ( ) {
		List< TestEntity > cd = sc.mGet( list ) ;
		System.out.println( JSON.toJSONString( cd ) ) ;
		cd = sc.mGetString( listString ) ;
		System.out.println( JSON.toJSONString( cd ) ) ;
		cd = sc.mGetNumber( listIntger ) ;
		System.out.println( JSON.toJSONString( cd ) ) ;
		
	}
	@Test
	public void mset ( ) {
		sc.mSet( list ) ;
	}

	
	@Test
	public void setNX(){
		TestEntity testEntity = new TestEntity( 10001 , "hello , setNX" ) ;
		sc.set( testEntity ) ;
		
		boolean bo = sc.setNX(testEntity);
		System.out.println(  bo ) ;
		testEntity.setId( 10002 );
		bo = sc.setNX(testEntity);
		System.out.println(  bo ) ;
	}
	
	@Test
	public void msetNX(){
		boolean bo = false;
		bo = sc.mSetNX( list );
		System.out.println(  bo ) ;
		bo = sc.mSetNX( listMsetNX );
		System.out.println( bo ) ;
	}
	
	@Test
	public void setEX(){	
		boolean bo = sc.setEX(testEntity , 60);
		System.out.println(  bo ) ;
	}
	
	@Test
	public void incrAndIncrByOrDecrAndDecrBy() {
		TestEntity testEntity = new TestEntity( 100011 , "hello , incrAndIncrBy" ) ;
		long incr = -2;
		incr = sc.incr( testEntity );
		System.out.println( incr ) ;
		
		incr = sc.incrBy( testEntity , 50 );
		System.out.println( incr ) ;
		
		incr = sc.decr( testEntity );
		System.out.println( incr ) ;
		
		incr = sc.decrBy( testEntity , 10 );
		System.out.println( incr ) ;		
	}

	@Test
	public void strLen(){
		sc.set( testEntity );
		long i = sc.strLen( testEntity );
		System.out.println(  i ) ;
	}
}
