package com.lamp.ledis.entity;

import org.junit.Test;

import com.lamp.ledis.utils.KeyCreateUtils;

public class KeyCreateTest {

	
	@Test
	public void testType(){
		new TestEntityKeyCreate("id");
	}
	
	@Test
	public void tsestUtils(){
		KeyCreateUtils kcu =  KeyCreateUtils.getInstance( );
		try {
			kcu.keyCreate("com/lamp/ledis/entity/TestEntity", "getId", "1");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
