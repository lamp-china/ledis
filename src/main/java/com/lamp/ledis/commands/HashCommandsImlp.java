package com.lamp.ledis.commands;

import java.util.List ;
import java.util.Map ;

import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.protocol.DataConversion ;
import com.lamp.ledis.serialize.Deserialize ;
import com.lamp.ledis.serialize.Serialize ;
import com.lamp.ledis.utils.DataConversionUtils ;

public class HashCommandsImlp<K,T> extends BasicsCommandsImlp<T> implements HashCommands<K,T> {

	public HashCommandsImlp(Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate) {
		this( serialize , deserialize , keyCreate , null ) ;
	}

	
	public HashCommandsImlp(
			Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate, String dataSource
	) {
		super( serialize , deserialize , keyCreate , dataSource ) ;
	}
	


	@Override
	public boolean hdel ( T key ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key , keyCreate.getKeyCreate( ) );
		return combination( HashCommandsElement.HDEL_SINGLE , dataList ) ;
	}

	@Override
	public boolean hdel ( String key , K field ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key  );
		return combination( HashCommandsElement.HDEL_SINGLE , dataList ) ;
	}

	@Override
	public boolean hdel ( Long key , K field ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key  );
		return combination( HashCommandsElement.HDEL_SINGLE , dataList ) ;
	}

	@Override
	public boolean hdel ( List< T > key ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key.get( 0 ) , keyCreate );
		return combinationParameterListReturnBooblean( HashCommandsElement.HDEL_MORE , dataList ,key , this.keyCreate.getKeyCreate( )) ;
	}

	@Override
	public boolean hexists ( T key ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key , keyCreate.getKeyCreate( ) );
		return combination( HashCommandsElement.HEXISTS , dataList ) ;
	}

	@Override
	public boolean hexists ( String key , String field ) {
		return combination( HashCommandsElement.HEXISTS , DataConversionUtils.getDataConversionList( key , field ) ) ;
	}

	@Override
	public boolean hexists ( long key , long field ) {
		return combination( HashCommandsElement.HEXISTS , DataConversionUtils.getDataConversionList( key , field ) ) ;
	}

	@Override
	public T hget ( T key ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key , keyCreate.getKeyCreate( ) );
		return combination( HashCommandsElement.HGET , dataList ) ;
	}

	@Override
	public T hget ( String key , String field ) {
		return combination( HashCommandsElement.HGET , DataConversionUtils.getDataConversionList( key , field ) ) ;
	}

	@Override
	public T hget ( long key , long field ) {
		return combination( HashCommandsElement.HGET , DataConversionUtils.getDataConversionList( key , field ) ) ;
	}

	@Override
	public Map< K , T > hgetall ( T key ) {
		return combination( HashCommandsElement.HGETALL , DataConversionUtils.getDataConversionListKey( key  , keyCreate) ) ;
	}

	@Override
	public Map< K , T > hgetall ( String key ) {
		return combination( HashCommandsElement.HGETALL , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public Map< K , T > hgetall ( long key ) {
		return combination( HashCommandsElement.HGETALL , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public long hincrby ( T key , long increment ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( key , keyCreate );
		dataList.get( 1 ) .setObjectAndKeyCreate( key , keyCreate.getKeyCreate( ) );
		dataList.get( 2 ) .setObjectAndKeyCreate( increment );
		return combination( HashCommandsElement.HINCRBY , dataList ) ;
	}

	@Override
	public long hincrby ( String key , String field , long increment ) {
		return  combination( HashCommandsElement.HINCRBY , DataConversionUtils.getDataConversionList( key ,field,increment  ) ) ; 
	}

	@Override
	public long hincrby ( Long key , Long field , long increment ) {
		return  combination( HashCommandsElement.HINCRBY , DataConversionUtils.getDataConversionList( key ,field,increment  ) ) ; 
	}

	@Override
	public List< K > hkeys ( T key ) {
		return combination( HashCommandsElement.HKEYS , DataConversionUtils.getDataConversionListKey( key  , keyCreate) ) ; 
	}

	@Override
	public List< K > hkeys ( String key ) {
		return combination( HashCommandsElement.HKEYS , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public List< K > hkeys ( long key ) {
		return combination( HashCommandsElement.HKEYS , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public List< T > hvals ( T key ) {
		return combination( HashCommandsElement.HVALS , DataConversionUtils.getDataConversionListKey( key  , keyCreate) ) ;
	}

	@Override
	public List< T > hvals ( String key ) {
		return combination( HashCommandsElement.HVALS , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public List< T > hvals ( long key ) {
	    return combination( HashCommandsElement.HVALS , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public long hlen ( T key ) {
		return combination( HashCommandsElement.HLEN , DataConversionUtils.getDataConversionListKey( key , keyCreate ) ) ;
	}

	@Override
	public long hlen ( String key ) {
		return combination( HashCommandsElement.HLEN , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public long hlen ( long key ) {
		return combination( HashCommandsElement.HLEN , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public List< T > hmget ( List< T > t ) {
		return combinationHash( HashCommandsElement.HMGET , DataConversionUtils.getDataConversionListKey( (Object)t.get( 0 ) , keyCreate) ,t ,keyCreate.getKeyCreate( ))  ;
	}

	@Override
	public List< T > hmget ( String key , List< T > t ) {
		return combinationHash( HashCommandsElement.HMGET , DataConversionUtils.getDataConversionList( key  ),t ,keyCreate.getKeyCreate( )) ;
	}

	@Override
	public List< T > hmget ( Number key , List< T > t ) {
		return combinationHash( HashCommandsElement.HMGET , DataConversionUtils.getDataConversionList( key  ),t ,keyCreate.getKeyCreate( )) ;
	}

	@Override
	public boolean hmset ( List< T > t ) {
		return combinationParameterListReturnBooblean( HashCommandsElement.HMSET , DataConversionUtils.getDataConversionListKey( (Object)t.get( 0 ) , keyCreate) , t , keyCreate.getKeyCreate( )) ;
	}

	@Override
	public boolean hmset ( String key , List< T > t ) {
		return combinationParameterListReturnBooblean( HashCommandsElement.HMGET , DataConversionUtils.getDataConversionList( key  ),t ,keyCreate.getKeyCreate( )) ;
	}

	@Override
	public boolean hmset ( Number key , List< T > t ) {
		return combinationParameterListReturnBooblean( HashCommandsElement.HMGET , DataConversionUtils.getDataConversionList( key  ),t ,keyCreate.getKeyCreate( )) ;
	}

	@Override
	public boolean hset ( T t ) {
		return combinationReturnBoolean( HashCommandsElement.HSET , DataConversionUtils.getHashObjectToDataConversion( t , keyCreate )) ; 
	}

	@Override
	public boolean hset ( String key , T  t ) {
		return combinationReturnBoolean( HashCommandsElement.HSET , DataConversionUtils.getHashToDataConversion(key , t , keyCreate )) ; 
	}

	@Override
	public boolean hset ( Number key ,T t ) {
		return combinationReturnBoolean( HashCommandsElement.HSET , DataConversionUtils.getHashToDataConversion(key , t , keyCreate )) ; 
	}

	@Override
	public boolean hsetnx ( T t ) {
		return combinationReturnBoolean( HashCommandsElement.HSETNX , DataConversionUtils.getHashObjectToDataConversion( t , keyCreate )) ; 
	}

	@Override
	public boolean hsetnx ( String key , T  t ) {
		return combinationReturnBoolean( HashCommandsElement.HSETNX , DataConversionUtils.getHashToDataConversion(key , t , keyCreate )) ; 
	}

	@Override
	public boolean hsetnx ( Number key ,  T  t ) {
		return combinationReturnBoolean( HashCommandsElement.HSETNX , DataConversionUtils.getHashToDataConversion(key , t , keyCreate )) ; 
	}




}
