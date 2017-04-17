package com.lamp.ledis.utils;

import java.util.List ;

import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.protocol.DataConversion ;

public final class DataConversionUtils {

	public static final List<DataConversion> getDataConversionList(Object key){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		return dataList;	
	}
	
	public static final List<DataConversion> getDataConversionList(Object key , Object field){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		dataList.get( 0 ) .setObjectAndKeyCreate( field  );
		return dataList;	
	}
	
	public static final List<DataConversion> getDataConversionList(Object key , Object field , Object fileds){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key  );
		dataList.get( 0 ) .setObjectAndKeyCreate( field  );
		return dataList;	
	}
	
	public static final <T>List<DataConversion> getHashObjectToDataConversion( T t , KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( t , keyCreate  );
		dataList.get( 0 ) .setObjectAndKeyCreate( t , keyCreate.getKeyCreate( )  );
		return dataList;	
	}
	
	public static final <T>List<DataConversion> getHashToDataConversion( Object object , T t ,KeyCreate< T > keyCreate){
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( object   );
		dataList.get( 0 ) .setObjectAndKeyCreate( t , keyCreate.getKeyCreate( )  );
		return dataList;	
	}
}
