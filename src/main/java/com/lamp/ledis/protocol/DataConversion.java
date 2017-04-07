package com.lamp.ledis.protocol;

import java.nio.ByteBuffer ;
import java.util.ArrayList;
import java.util.List ;

import com.lamp.ledis.commands.AbstractLedis ;
import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.JsonDeToSerialize ;

public class DataConversion {
	
	
	private static final int LIST_SIZE = 10;
	
	
	public static final  void setDataConversion(String data){
		
	}
	
	public static final  void setDataConversion(Object object , KeyCreate< Object > keyCreateb){
		
	}
	
	private static final ThreadLocal< List<DataConversion> >   LIST_DATACONVERSION_LOCAL = new ThreadLocal<>( );
	public static final List<DataConversion> getListDataConversion(){
		List< DataConversion > list = LIST_DATACONVERSION_LOCAL.get( );
		if( list == null){
			list = new ArrayList<>( );
			for(int i = 0 ; i < LIST_SIZE ; i++){
				list.add( new DataConversion( ) );
			}
			LIST_DATACONVERSION_LOCAL.set( list );
		}
		return list;
	}	
	
	private static final ThreadLocal< ByteBuffer > BUFFER_LOCAL = new ThreadLocal<>( );
	
	
	public static final ByteBuffer getBuffer(){
		ByteBuffer buffer = BUFFER_LOCAL.get( );
		if( buffer == null){
			buffer = ByteBuffer.allocate( 1024 <<4 );
			BUFFER_LOCAL.set( buffer );
		}
		buffer.clear( );
		return buffer; 
	}
	
	private String data;
	
	private Object object;
	
	private KeyCreate< Object > keyCreate;
	
	private boolean isWrite ;

	public byte[] getWriteData(){
		byte[] returnData;
		if(keyCreate == null){
			returnData = JsonDeToSerialize.SERIALIZE_DEFAULT.executeByte( object );
		}else{
			returnData = keyCreate.getKeySuffix( object ).getBytes( );
			object = null;
			keyCreate = null;
		}
		this.isWrite = false;
		return returnData;
	}
	
	public ByteBuffer getWriteByteBuffer(){
		if( !this.isWrite )
			return null;
		ByteBuffer byteBuffer;
		if(keyCreate == null){
			byteBuffer = JsonDeToSerialize.SERIALIZE_DEFAULT.execute( object );
		}else{
			byteBuffer = getBuffer();
			keyCreate.getKeySuffixBuffer( object  , byteBuffer );
			keyCreate = null;
		}
		object = null;
		this.isWrite = false;
		return byteBuffer;
	}
	
	public DataConversion setData( String data ) {
		this.data = data;
		this.isWrite = true;
		return this;
	}

	public  DataConversion setObjectAndKeyCreate( Object object ) {
		this.object = object;
		this.isWrite = true;
		return this;
	}
	
	@SuppressWarnings( "unchecked" )
	public <T> DataConversion setObjectAndKeyCreate( Object object ,KeyCreate< T > keyCreate) {
		this.object = object;
		this.keyCreate = (KeyCreate< Object >)keyCreate;
		this.isWrite = true;
		return this;
	}

}
