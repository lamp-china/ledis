package com.lamp.ledis.utils;

import org.junit.Test ;

public class UtilsTest {

	@Test
	public void byteToString(){
		byte[] by = new byte[]{0, 49, 0, 13, 10, 103, 101, 116, 0, 36, 48, 13, 10, 13, 10};
		System.out.println(  new String(by) ) ;
	}
}
