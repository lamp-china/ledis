package com.lamp.ledis.utils;

import java.io.IOException ;
import java.util.HashMap ;
import java.util.Map ;

import org.junit.Test ;

import com.alibaba.fastjson.JSON ;
import com.alibaba.fastjson.TypeReference ;
import com.lamp.ledis.entity.TestEntity ;

public class UtilsTest {

	@Test
	public void byteToString(){
		byte[] by = new byte[]{0, 49, 0, 13, 10, 103, 101, 116, 0, 36, 48, 13, 10, 13, 10};
		System.out.println(  new String(by) ) ;
	}
	
	
	@Test
	public void getClazz(){
		try {
			Thread.currentThread( ).getContextClassLoader( ).getResources( "" );
		} catch ( IOException e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void mapJson(){
		Map<Integer , TestEntity> map = new HashMap<>( );
		
		for(int i = 0 ; i< 20 ; i++){
			map.put( i , new TestEntity(1 , "test" ) );
		}
		String str= JSON.toJSONString( map );
		System.out.println(  str  ) ;
	}
	
	@Test
	public void  test(){
		String str = "{0:{\"appId\":0,\"id\":1001,\"name\":\"mset\"},1:{\"appId\":1,\"id\":1001,\"name\":\"mset\"},2:{\"appId\":2,\"id\":1001,\"name\":\"mset\"},3:{\"appId\":3,\"id\":1001,\"name\":\"mset\"},4:{\"appId\":4,\"id\":1001,\"name\":\"mset\"},5:{\"appId\":5,\"id\":1001,\"name\":\"mset\"},6:{\"appId\":6,\"id\":1001,\"name\":\"mset\"},7:{\"appId\":7,\"id\":1001,\"name\":\"mset\"},8:{\"appId\":8,\"id\":1001,\"name\":\"mset\"},9:{\"appId\":9,\"id\":1001,\"name\":\"mset\"},10:{\"appId\":10,\"id\":1001,\"name\":\"mset\"},11:{\"appId\":11,\"id\":1001,\"name\":\"mset\"},12:{\"appId\":12,\"id\":1001,\"name\":\"mset\"},13:{\"appId\":13,\"id\":1001,\"name\":\"mset\"},14:{\"appId\":14,\"id\":1001,\"name\":\"mset\"},15:{\"appId\":15,\"id\":1001,\"name\":\"mset\"},16:{\"appId\":16,\"id\":1001,\"name\":\"mset\"},17:{\"appId\":17,\"id\":1001,\"name\":\"mset\"},18:{\"appId\":18,\"id\":1001,\"name\":\"mset\"},19:{\"appId\":19,\"id\":1001,\"name\":\"mset\"}}";
		Map<Integer , TestEntity>  map = JSON.parseObject( str , new TypeReference< Map<Integer , TestEntity> >(){} );
		System.out.println( map ) ;
	
	
	}
}
