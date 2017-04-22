package com.lamp.ledis.commands;

import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.protocol.DataConversion ;
import com.lamp.ledis.serialize.Deserialize;
import com.lamp.ledis.serialize.Serialize;

public class StringCommandsImlp< T > extends AbstractLedis< T > implements StringCommands< T > {

	public StringCommandsImlp( Serialize serialize , Deserialize deserialize , KeyCreate< T > ledis ) {
		super( serialize , deserialize , ledis );
	}

	@Override
	public T get( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combination(StringCommandsElement.GET_ELEMENT, list );
	}

	@Override
	public T get( String t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t  );
		return combination(StringCommandsElement.GET_ELEMENT, list );
	}

	@Override
	public T get( long t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t  );
		return combination(StringCommandsElement.GET_ELEMENT, list );
	}

	@Override
	public T getSet( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ) .setObjectAndKeyCreate( t  );
		return combination(StringCommandsElement.GETSET_ELEMENT, list );
	}

	@Override
	public List< T > mGet( List< T > keys ) {
		return combinationReturnList( StringCommandsElement.MGET_ELEMENT ,  DataConversion.getListDataConversion( ) , keys );
	}

	@Override
	public List< T > mGetString( List< String > keys ) {
		return combinationReturnListString( StringCommandsElement.MGET_ELEMENT ,  DataConversion.getListDataConversion( ) , keys );
	}
	@Override
	public List< T > mGetNumber( List< ? extends Number > keys ) {
		return combinationReturnListLong( StringCommandsElement.MGET_ELEMENT ,  DataConversion.getListDataConversion( ) , keys );
	}

	@Override
	public void set( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( t );
		combination(StringCommandsElement.SET_ELEMENT, list );
	}

	@Override
	public Boolean setNX( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( t );
		return combinationReturnBoolean(StringCommandsElement.SETNX_ELEMENT, list );
	}

	@Override
	public Boolean setNX( T t , Object o ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( o );
		return combinationReturnBoolean(StringCommandsElement.SETNX_ELEMENT, list );
	}

	@Override
	public Boolean setEX( T t, long  seconds ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( seconds );
		list.get( 2 ).setObjectAndKeyCreate( t );
		return combinationReturnBoolean(StringCommandsElement.SETEX_ELEMENT, list );
	}

	@Override
	public Boolean setEX( T t , Object o , long  seconds) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( seconds );
		list.get( 2 ).setObjectAndKeyCreate( o );
		return combinationReturnBoolean(StringCommandsElement.SETEX_ELEMENT, list );
	}

	@Override
	public void pSetEX( byte[ ] key , long milliseconds , byte[ ] value ) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mSet( List< T > tuple ) {
		combination( StringCommandsElement.MSET_ELEMENT ,  DataConversion.getListDataConversion( ) , tuple );

	}

	@Override
	public Boolean mSetNX( List< T > tuple ) {
		return combinationParameterListReturnBooblean( StringCommandsElement.MSETNX_ELEMENT ,  DataConversion.getListDataConversion( ) , tuple , this.keyCreate);
	}

	@Override
	public Long incr(T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combinationReturnLong(StringCommandsElement.INCR_ELEMENT, list );
	}

	@Override
	public Long incrBy(T t, long value ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( value );
		return combinationReturnLong(StringCommandsElement.INCRBY_ELEMENT, list );
	}

	@Override
	public Double incrBy(T t, double value ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long decr( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combinationReturnLong(StringCommandsElement.DECR_ELEMENT, list );
	}

	@Override
	public Long decrBy(T t, long value ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		list.get( 1 ).setObjectAndKeyCreate( value );
		return combinationReturnLong(StringCommandsElement.DECRBY_ELEMENT, list );
	}

	@Override
	public Long strLen( T t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combinationReturnLong(StringCommandsElement.STRLEN_ELEMENT, list );
	}

}
