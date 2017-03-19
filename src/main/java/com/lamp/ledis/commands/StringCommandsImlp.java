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
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combination(StringCommandsElement.GET_ELEMENT, list );
	}

	@Override
	public T get( long t ) {
		List<DataConversion> list = DataConversion.getListDataConversion( );
		list.get( 0 ) .setObjectAndKeyCreate( t , keyCreate );
		return combination(StringCommandsElement.GET_ELEMENT, list );
	}

	@Override
	public T getSet( T t ) {
		return null;
	}

	@Override
	public List< T > mGet( List< T > keys ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List< T > mGetString( List< String > keys ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List< T > mGetNumber( List< Number > keys ) {
		// TODO 自动生成的方法存根
		return null;
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
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setNX( T t , Object o ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setEx( T t ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setEx( T t , Object o ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void pSetEx( byte[ ] key , long milliseconds , byte[ ] value ) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mSet( List< T > tuple ) {
		// TODO 自动生成的方法存根

	}

	@Override
	public Boolean mSetNX( List< T > tuple ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long incr( ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long incrBy( long value ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Double incrBy( double value ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long decr( ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long decrBy( long value ) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long strLen( T t ) {
		// TODO 自动生成的方法存根
		return null;
	}

}
