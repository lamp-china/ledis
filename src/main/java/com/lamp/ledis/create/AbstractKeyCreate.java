package com.lamp.ledis.create ;

import java.nio.ByteBuffer;
import java.util.Set ;

import com.alibaba.fastjson.TypeReference ;
import com.lamp.ledis.protocol.ProtocolUtil;

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

	public ByteBuffer getKeySuffixBuffer(T t){
		return null;
	}
	
	
	void setByteBufferPrefix(ByteBuffer byteBuffer){
		byteBuffer.put( byteKey );
	}
	
	public void getKey ( int key , ByteBuffer byteBuffer ) {
		ProtocolUtil.getChars( key , byteBuffer );
	}

	public void getKey ( long key , ByteBuffer byteBuffer) {
		ProtocolUtil.getChars( key , byteBuffer );
	}



	public void getKey ( Integer key , ByteBuffer byteBuffer) {
		 getKey( key.intValue( ) ,  byteBuffer) ;
	}

	public void getKey ( Long key , ByteBuffer byteBuffer) {
		
		 getKey( key.longValue( ) ,  byteBuffer) ;
	}

	
	
	public byte[] getByteKey ( ) {
		return byteKey ;
	}

	public String getKey ( T t ) {
		return getKeySuffix( t ) ;
	}

	public String getKey ( String key ) {
		if(stringKey != null){
			key = stringKey+key;
		}
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
