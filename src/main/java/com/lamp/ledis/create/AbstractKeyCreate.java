package com.lamp.ledis.create ;

import java.util.Set ;

import com.alibaba.fastjson.TypeReference ;

public abstract class AbstractKeyCreate< T > implements KeyCreate< T > {

	private String stringKey ;

	private byte[] byteKey ;

	private Class< T > clazz ;

	private KeyConfigure<T> keyConfigure ;

	public AbstractKeyCreate(KeyConfigure<T> keyConfigure) {
		this.keyConfigure = keyConfigure ;
		this.clazz = keyConfigure.getAtr( ).getClazz( ) ;
		this.stringKey   = keyConfigure.getKeyName( );
	}

	public AbstractKeyCreate(String key) {
		this.stringKey = key ;
		if ( key != null )
			this.byteKey = stringKey.getBytes( ) ;
	}

	public byte[] getByteKey ( ) {
		return byteKey ;
	}

	public String getKey ( T t ) {
		return getKeySuffix( t ) ;
	}

	public String getKey ( String key ) {
		return key ;
	}

	public String getKey ( int key ) {
		return getKey( Integer.toString( key ) ) ;
	}

	public String getKey ( long key ) {
		return getKey( Long.toString( key ) ) ;
	}

	public String getKeyPrefix ( ) {
		return stringKey ;
	}

	public String getKey ( Integer key ) {
		return getKey( key.longValue( ) ) ;
	}

	public String getKey ( Long key ) {
		return getKey( key.longValue( ) ) ;
	}

	public Class< T > getEntityClass ( ) {
		return clazz ;
	}

	@Override
	public TypeReference< ? > getTypeReferenceList ( ) {
		return keyConfigure.getAtr( ).getTrList( ) ;
	}

	@Override
	public TypeReference< Set< T > > getTypeReferenceSet ( ) {
		return null ;
	}

	@Override
	public TypeReference< ? > getTypeReferenceMap ( ) {
		return keyConfigure.getAtr( ).getTrMap( ) ;
	}

}
