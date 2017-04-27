package com.lamp.ledis.utils;

import java.util.List ;

import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.protocol.DataConversion ;

public final class DataConversionUtils {

	public static final <T>List<DataConversion> getDataConversionListKey(Object object , Object value , Object valueTwo ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( value  );
		dataList.get( 2 ) .setObjectAndKeyCreate( valueTwo  );
		return dataList;	
	}
	
	public static final <T>List<DataConversion> getDataConversionListKey(Object object ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object , keyCreate  );
		return dataList;	
	}
	
	
	public static final <T>List<DataConversion> getDataConversionListIsKey(Object object ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( object  );
		return dataList;	
		
	}
	
	public static final <T>List<DataConversion> getDataConversionListIsKey(Object object , Object value ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( object  );
		dataList.get( 2 ) .setObjectAndKeyCreate( value  );
		return dataList;	
		
	}
	
	public static final <T>List<DataConversion> getDataConversionListIsKey(Object object , Object value , Object valueTwo ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( object  );
		dataList.get( 2 ) .setObjectAndKeyCreate( value  );
		dataList.get( 3 ) .setObjectAndKeyCreate( valueTwo  );
		return dataList;	
		
	}
	
	
	
	public static final List<DataConversion> getDataConversionList(Object key){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		return dataList;	
	}
	
	public static final List<DataConversion> getDataConversionList(Object key , Object field){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		dataList.get( 1 ) .setObjectAndKeyCreate( field  );
		return dataList;	
	}
	
	public static final List<DataConversion> getDataConversionList(Object key , Object field , Object fileds){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		dataList.get( 1 ) .setObjectAndKeyCreate( field  );
		dataList.get( 2 ) .setObjectAndKeyCreate( fileds  );
		return dataList;	
	}
	
	public static final List<DataConversion> getDataConversionList(Object key , Object field , Object fileds , Object value){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		dataList.get( 1 ) .setObjectAndKeyCreate( field  );
		dataList.get( 2 ) .setObjectAndKeyCreate( fileds  );
		dataList.get( 2 ) .setObjectAndKeyCreate( value  );
		return dataList;	
	}
	
	public static final <T>List<DataConversion> getHashObjectToDataConversion( T t , KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( t , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( t , keyCreate.getKeyCreate( )  );
		return dataList;	
	}
	
	public static final <T>List<DataConversion> getHashToDataConversion( Object object , T t ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object   );
		dataList.get( 1 ) .setObjectAndKeyCreate( t , keyCreate.getKeyCreate( )  );
		return dataList;	
	}
}
