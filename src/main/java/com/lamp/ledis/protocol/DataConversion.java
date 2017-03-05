package com.lamp.ledis.protocol;

import com.lamp.ledis.create.KeyCreate;

public class DataConversion {
	
	private static final ThreadLocal< DataConversion  >
	
	public static final  DataConversion getDataConversion(String data){
		
	}
	
	public static final  DataConversion getDataConversion(Object object ,KeyCreate< Object > keyCreate){
		
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

	public void setObject( Object object ) {
		this.object = object;
	}

	public void setKeyCreate( KeyCreate< Object > keyCreate ) {
		this.keyCreate = keyCreate;
	}
	
	
}
