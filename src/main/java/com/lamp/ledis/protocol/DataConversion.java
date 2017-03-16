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
		return buffer; 
	}
	
	private String data;
	
	private Object object;
	
	private KeyCreate< Object > keyCreate;

	public byte[] getWriteData(){
		byte[] returnData;
		if(keyCreate == null){
			returnData = JsonDeToSerialize.SERIALIZE_DEFAULT.execute( object );
		}else{
			returnData = keyCreate.getKeySuffix( object ).getBytes( );
			object = null;
			keyCreate = null;
		}
		return returnData;
	}
	
	public DataConversion setData( String data ) {
		this.data = data;
		return this;
	}

	public DataConversion setObjectAndKeyCreate( Object object ,KeyCreate< Object > keyCreate) {
		this.object = object;
		this.keyCreate = keyCreate;
		return this;
	}
	
}
