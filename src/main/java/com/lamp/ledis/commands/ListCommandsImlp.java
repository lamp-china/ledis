package com.lamp.ledis.commands;

import java.util.List ;

import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.protocol.DataConversion ;
import com.lamp.ledis.serialize.Deserialize ;
import com.lamp.ledis.serialize.Serialize ;
import com.lamp.ledis.utils.DataConversionUtils ;

public class ListCommandsImlp<T> extends BasicsCommandsImlp< T >implements ListCommands< T > {


	public ListCommandsImlp(Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate) {
		super( serialize , deserialize , keyCreate ) ;
		// TODO 自动生成的构造函数存根
	}

	public ListCommandsImlp(
			Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate, String dataSource
	) {
		super( serialize , deserialize , keyCreate , dataSource ) ;
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public T blpop ( T t ) {
		return blpop( t , 0 ) ;
	}

	@Override
	public T blpop ( long t ) {
		return blpop( t , 0 ) ;
	}

	@Override
	public T blpop ( String t ) {
		return blpop( t , 0 ) ;
	}

	@Override
	public T blpop ( T t , int timeout ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionListIsKey( t  ,timeout, this.keyCreate)  ) ;
	}

	@Override
	public T blpop ( long t , int timeout ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionList( t , timeout )  ) ;
	}

	@Override
	public T blpop ( String t , int timeout ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionList( t , timeout )  ) ;
	}

	@Override
	public T brpop ( T t ) {
		return brpop( t , 0 ) ;
	}

	@Override
	public T brpop ( long t ) {
		return brpop( t , 0 ) ;
	}

	@Override
	public T brpop ( String t ) {
		return brpop( t , 0 ) ;
	}

	@Override
	public T brpop ( T t , int timeout ) {
		return combination( ListCommandsElement.BRPOP_SINGLE , DataConversionUtils.getDataConversionListIsKey( t  ,timeout, this.keyCreate)  ) ;
	}

	@Override
	public T brpop ( long t , int timeout ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionList( t  ,timeout)  ) ;
	}

	@Override
	public T brpop ( String t , int timeout ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionList( t  ,timeout)  ) ;
	}

	@Override
	public T brpoplpush ( T source , T destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( long source , long destination ) {
		return combination( ListCommandsElement.BRPOPLPUSH , DataConversionUtils.getDataConversionList( source  ,destination)  ) ;
	}

	@Override
	public T brpoplpush ( String source , String destination ) {
		return combination( ListCommandsElement.BLPOP_SINGLE , DataConversionUtils.getDataConversionList( source  ,destination)  ) ;
	}

	@Override
	public T brpoplpush ( T source , T destination , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( long source , long destination , int timeout ) {
		return combination( ListCommandsElement.BRPOPLPUSH , DataConversionUtils.getDataConversionList( source  ,destination ,timeout)  ) ;
	}

	@Override
	public T brpoplpush ( String source , String destination , int timeout ) {
		return combination( ListCommandsElement.BRPOPLPUSH , DataConversionUtils.getDataConversionList( source  ,destination ,timeout)  ) ;
	}

	@Override
	public T lindex ( T t , int index ) {
		return combination( ListCommandsElement.LINDEX , DataConversionUtils.getDataConversionListKey( t , index , keyCreate )) ;
	}

	@Override
	public T lindex ( long t , int index ) {
		return combination( ListCommandsElement.LINDEX , DataConversionUtils.getDataConversionList( t , index )  ) ;
	}

	@Override
	public T lindex ( String t , int index ) {
		return combination( ListCommandsElement.LINDEX , DataConversionUtils.getDataConversionList( t , index )  ) ;
	}

	@Override
	public long linsert ( String key , String pivot , String value ) {
		return 0 ;
	}

	@Override
	public long llen ( T key ) {
		return combinationReturnLong( ListCommandsElement.LLEN , DataConversionUtils.getDataConversionListIsKey( key , keyCreate ) ) ;
	}

	@Override
	public long llen ( String key ) {
		return combinationReturnLong( ListCommandsElement.LLEN , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public long llen ( long key ) {
		return combinationReturnLong( ListCommandsElement.LLEN , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public T lpop ( T key ) {
		return combination( ListCommandsElement.LPOP , DataConversionUtils.getDataConversionListKey( key , keyCreate ) ) ;
	}

	@Override
	public T lpop ( String key ) {
		return combination( ListCommandsElement.LPOP , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public T lpop ( long key ) {
		return combination( ListCommandsElement.LPOP , DataConversionUtils.getDataConversionList( key  ) ) ;
	}

	@Override
	public long lpush ( T value ) {
		return combination( ListCommandsElement.LPUSH , DataConversionUtils.getDataConversionListIsKey( value , keyCreate ) ) ;
	}

	@Override
	public long lpush ( List< T > value ) {
		return combinationParameterListReturnLong( ListCommandsElement.LPUSH_MORE , DataConversionUtils.getDataConversionListKey( value.get( 0 ) , keyCreate ) , value , null ) ;
	}

	@Override
	public long lpushx ( T value ) {
		return combination( ListCommandsElement.LPUSHX , DataConversionUtils.getDataConversionList( value , keyCreate ) ) ;
	}

	@Override
	public List< T > lrange ( T key , int start , int stop ) {
		return combinationReturnList( ListCommandsElement.LRANGE , DataConversionUtils.getDataConversionListKey( key , start , stop , keyCreate ) ) ;
	}

	@Override
	public List< T > lrange ( String key , int start , int stop ) {
		return combinationReturnList( ListCommandsElement.LRANGE , DataConversionUtils.getDataConversionList( key , start , stop  ) ) ;
	}

	@Override
	public List< T > lrange ( long key , int start , int stop ) {
		return combinationReturnList( ListCommandsElement.LRANGE , DataConversionUtils.getDataConversionList( key , start , stop  ) ) ;
	}

	@Override
	public long lren ( String key , int num , String value ) {
		return combinationReturnLong( ListCommandsElement.LREM, DataConversionUtils.getDataConversionList( key , num , value  ) ) ;
	}

	@Override
	public boolean lset ( T value , int index ) {
		List<DataConversion> dataList = DataConversion.getListDataConversion( );
		dataList.get( 0 ) .setObjectAndKeyCreate( value , keyCreate  );
		dataList.get( 1 ) .setObjectAndKeyCreate( index  );
		dataList.get( 2 ) .setObjectAndKeyCreate( value  );
		return combinationReturnBoolean( ListCommandsElement.LSET, dataList ) ; 
	}

	@Override
	public boolean ltrim ( T key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean ltrim ( String key , int start , int stop ) {
		return combinationReturnBoolean( ListCommandsElement.LREM, DataConversionUtils.getDataConversionList( key , start , stop  ) ) ;
	}

	@Override
	public boolean ltrim ( long key , int start , int stop ) {
		return combinationReturnBoolean( ListCommandsElement.LTRIM, DataConversionUtils.getDataConversionList( key , start , stop  ) ) ;
	}

	@Override
	public T rpop ( T t ) {
		return combination( ListCommandsElement.RPOP, DataConversionUtils.getDataConversionListKey( t , keyCreate )) ;
	}

	@Override
	public T rpop ( long t ) {
		return combination( ListCommandsElement.RPOP, DataConversionUtils.getDataConversionList( t ) ) ;
	}

	@Override
	public T rpop ( String t ) {
		return combination( ListCommandsElement.RPOP, DataConversionUtils.getDataConversionList( t  ) ) ;
	}

	@Override
	public T rpoplpush ( T source , T destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpoplpush ( long source , long destination ) {
		return combination( ListCommandsElement.RPOPLPUSH , DataConversionUtils.getDataConversionList( source , destination )  ) ;
	}

	@Override
	public T rpoplpush ( String source , String destination ) {
		return combination( ListCommandsElement.RPOPLPUSH , DataConversionUtils.getDataConversionList( source , destination )  )  ;
	}

	@Override
	public long rpush ( T value ) {
		return combination( ListCommandsElement.RPUSH , DataConversionUtils.getDataConversionListIsKey( value , keyCreate ));
	}

	@Override
	public long rpush ( List< T > value ) {
		return combinationParameterListReturnLong( ListCommandsElement.RPUSH_MORE , DataConversionUtils.getDataConversionListKey( value.get( 0 ) , keyCreate ) , value , null);
	}

	@Override
	public long rpushx ( T value ) {
		return  combination( ListCommandsElement.RPUSHX , DataConversionUtils.getDataConversionListIsKey( value , keyCreate ));
	}

}
