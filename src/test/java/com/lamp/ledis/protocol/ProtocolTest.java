package com.lamp.ledis.protocol;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.lamp.ledis.utils.LedisInputStream;

public class ProtocolTest {

	@Test
	public void ResolveStateNetProtocolTest(){
		ResolveNetProtocol<Boolean> psnp = new ResolveNetProtocol.ResolveStateNetProtocol();
		try{
			String  data = "+OK\r\n";
			LedisInputStream  is = new LedisInputStream(  new ByteArrayInputStream( data.getBytes()) );
			boolean b =  psnp.analysis( is ,null);
			System.out.println( b );
		}catch (Exception e) {
			
		}
	}
	
	@Test
	public void ResolveExceedinglyNetProtocolTest(){
		ResolveNetProtocol<Boolean> psnp = new ResolveNetProtocol.ResolveStateNetProtocol();
		try{
			String  data = "-ERR unknown command 'foobar'\r\n";
			LedisInputStream  is = new LedisInputStream(  new ByteArrayInputStream( data.getBytes()) );
			boolean b =  psnp.analysis( is , null );
			System.out.println( b );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ResolveIntToLongNetProtocolTest(){
		ResolveNetProtocol<Long> psnp = new ResolveNetProtocol.ResolveIntNetProtocol();
		try{
			String  data = ":1000\r\n";
			LedisInputStream  is = new LedisInputStream(  new ByteArrayInputStream( data.getBytes()) );
			long b =  psnp.analysis( is , null );
			System.out.println( b );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void ResolveIntToBooleanNetProtocolTest(){
		ResolveNetProtocol<Boolean> psnp = new ResolveNetProtocol.ResolveIntToBooleanNetProtocol();
		try{
			String  data = ":1\r\n";
			LedisInputStream  is = new LedisInputStream(  new ByteArrayInputStream( data.getBytes()) );
			boolean b =  psnp.analysis( is , null );
			System.out.println( b );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
