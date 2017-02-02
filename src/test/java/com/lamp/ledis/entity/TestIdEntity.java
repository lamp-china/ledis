package com.lamp.ledis.entity;

import com.lamp.ledis.create.AbstractKeyCreate ;

public class TestIdEntity {
	private int intId;
	
	private long longId;
	
	private String strId;
	
	private Integer integerId;
	
	private Long    longPackingId;

	public int getIntId ( ) {
		return intId ;
	}

	public void setIntId ( int intId ) {
		this.intId = intId ;
	}

	public long getLongId ( ) {
		return longId ;
	}

	public void setLongId ( long longId ) {
		this.longId = longId ;
	}

	public String getStrId ( ) {
		return strId ;
	}

	public void setStrId ( String strId ) {
		this.strId = strId ;
	}

	public Integer getIntegerId ( ) {
		return integerId ;
	}

	public void setIntegerId ( Integer integerId ) {
		this.integerId = integerId ;
	}

	public Long getLongPackingId ( ) {
		return longPackingId ;
	}

	public void setLongPackingId ( Long longPackingId ) {
		this.longPackingId = longPackingId ;
	}
	
	
	static class TestIntId extends AbstractKeyCreate< TestIdEntity >{

		public TestIntId(String key) {
			super( key ) ;
			
		}

		@Override
		public String getKeySuffix ( TestIdEntity t ) {
			return getKey( t.getIntId( ) ) ;
		}
		
	}
	
	
	static class TestLongId extends AbstractKeyCreate< TestIdEntity >{

		public TestLongId(String key) {
			super( key ) ;
			
		}

		@Override
		public String getKeySuffix ( TestIdEntity t ) {
			// TODO 自动生成的方法存根
			return null ;
		}
		
	}
	
	static class TestStrId extends AbstractKeyCreate< TestIdEntity >{

		public TestStrId(String key) {
			super( key ) ;
			
		}

		@Override
		public String getKeySuffix ( TestIdEntity t ) {
			return getKey( t.getStrId( ) ) ;
		}
		
	}
	
	static class TestIntegerIdId extends AbstractKeyCreate< TestIdEntity >{

		public TestIntegerIdId(String key) {
			super( key ) ;
			
		}

		@Override
		public String getKeySuffix ( TestIdEntity t ) {
			// TODO 自动生成的方法存根
			return null ;
		}
		
	}
	
	
	static class LongPackingIdId extends AbstractKeyCreate< TestIdEntity >{

		public LongPackingIdId(String key) {
			super( key ) ;
		}

		@Override
		public String getKeySuffix ( TestIdEntity t ) {
			
			return null ;
		}
		
	}
	
	
}
