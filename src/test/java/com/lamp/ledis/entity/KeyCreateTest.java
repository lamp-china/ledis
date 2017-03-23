package com.lamp.ledis.entity;

import org.junit.Test;

import com.lamp.ledis.utils.KeyCreateUtils;

public class KeyCreateTest {
	
	TestEntity testEntity = new TestEntity(1 , "hello , laohu");
	
	@Test
	public void testType(){
		TestEntityKeyCreate tkc = new TestEntityKeyCreate("id");
		tkc.getKeySuffix( testEntity );
		tkc.getKeySuffixBuffer( testEntity );
	}
	
	@Test
	public void tsestUtils(){
		KeyCreateUtils kcu =  KeyCreateUtils.getInstance( );
		try {
			//             com.lamp.ledis.entity
			kcu.createKeyCreate("com.lamp.ledis.entity.TestEntity", "name", "1",null,null);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
