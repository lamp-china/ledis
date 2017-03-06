package com.lamp.ledis.protocol;

import java.util.List ;

import com.lamp.ledis.create.KeyCreate;

public class DataConversion {
	
	
	
	
	
	public static final  void setDataConversion(String data){
		
	}
	
	public static final  void setDataConversion(Object object , KeyCreate< Object > keyCreateb){
		
	}
	
	public static final List<DataConversion> getListDataConversion(){
		return null;
	}
	
	
	private String data;
	
	private Object object;
	
	private KeyCreate< Object > keyCreate;

	public byte[] getWriteData(){
		byte[] returnData;
		if(data != null){
			returnData = data.getBytes( );
		}else{
			returnData = keyCreate.getKeySuffix( object ).getBytes( );
		}
		return returnData;
	}
	
	public void setData( String data ) {
		this.data = data;
	}

	public void setObjectAndKeyCreate( Object object ,KeyCreate< Object > keyCreate) {
		this.object = object;
		this.keyCreate = keyCreate;
	}
	
}
