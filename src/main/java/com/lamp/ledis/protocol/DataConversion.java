package com.lamp.ledis.protocol;

import java.util.ArrayList;
import java.util.List ;

import com.lamp.ledis.create.KeyCreate;

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
	
	private String data;
	
	private Object object;
	
	private KeyCreate< Object > keyCreate;

	public byte[] getWriteData(){
		byte[] returnData;
		if(data != null){
			returnData = data.getBytes( );
			data = null;
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
