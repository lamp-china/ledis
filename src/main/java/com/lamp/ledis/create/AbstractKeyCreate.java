package com.lamp.ledis.create ;

import java.nio.ByteBuffer;
import java.util.Set ;

import com.alibaba.fastjson.TypeReference ;
import com.lamp.ledis.protocol.ProtocolUtil;
import com.lamp.ledis.utils.ClassUtils ;

public abstract class AbstractKeyCreate< T > implements KeyCreate< T > {

	private String stringKey ;

	private byte[] byteKey ;

	private Class< T > clazz ;
	
	private byte[] prefix;
	
	private byte separator;
	
	private T object;

	private KeyCreate<T> keyCreate;
	
	private KeyConfigure<T> keyConfigure ;

	public AbstractKeyCreate(KeyConfigure<T> keyConfigure) {
		this.keyConfigure = keyConfigure ;
		this.clazz = keyConfigure.getAtr( ).getClazz( ) ;
		this.stringKey   = keyConfigure.getPrefix( );
		if( keyConfigure.getPrefix( ) != null && "".equals(  keyConfigure.getPrefix( ) )){
			this.prefix      = keyConfigure.getPrefix( ).getBytes( );
		}
		try {
			this.object = clazz.newInstance( );
		} catch ( InstantiationException | IllegalAccessException e ) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}



	public T getOject(){
		return object;
	}
	
	public ByteBuffer getKeySuffixBuffer(T t){
		return null;
	}
	
	
	void setByteBufferPrefix(ByteBuffer byteBuffer){
		if(this.prefix != null){		
			byteBuffer.put( prefix );
		}
	}
	
	public void getKey ( int key , ByteBuffer byteBuffer ) {
		setByteBufferPrefix( byteBuffer );
		ProtocolUtil.getChars( key , byteBuffer );
	}

	public void getKey ( long key , ByteBuffer byteBuffer) {
		setByteBufferPrefix( byteBuffer );
		ProtocolUtil.getChars( key , byteBuffer );
	}



	public void getKey ( Integer key , ByteBuffer byteBuffer) {
		 getKey( key.intValue( ) ,  byteBuffer) ;
	}

	public void getKey ( Long key , ByteBuffer byteBuffer) {
		
		 getKey( key.longValue( ) ,  byteBuffer) ;
	}
	
	public void getKey ( String key , ByteBuffer byteBuffer) {
		setByteBufferPrefix( byteBuffer );
		byteBuffer.put( key.getBytes( ) );
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

	public KeyCreate< T > getKeyCreate ( ) {
		return keyCreate ;
	}

	public void setKeyCreate(KeyCreate< T > keyCreate){
		this.keyCreate = keyCreate;
	}
	
	public TypeReference< ? > getTypeReferenceKeyListResultHandle(){
		return ClassUtils.getTypeReferenceList( keyConfigure.getKeyType( ) );
	}
}
