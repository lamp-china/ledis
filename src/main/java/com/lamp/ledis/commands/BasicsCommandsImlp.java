package com.lamp.ledis.commands;

import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.serialize.Deserialize ;
import com.lamp.ledis.serialize.Serialize ;

public class BasicsCommandsImlp<T> extends AbstractLedis< T > implements BasicsCommands< T > {

	
	public BasicsCommandsImlp(Serialize serialize , Deserialize deserialize , KeyCreate<T> keyCreate){
		this( serialize , deserialize , keyCreate , null );
	}
	
	public BasicsCommandsImlp(
			Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate, String dataSource
	) {
		super( serialize , deserialize , keyCreate , dataSource ) ;
		// TODO 自动生成的构造函数存根
	}

	@Override
	public boolean del ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean del ( String t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean del ( Long t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( String t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( Long t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( T key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( String key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( Long key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( T key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( String key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( Long key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( T key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( String key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( Long key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( T key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( String key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( Long key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean persist ( T key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean persist ( String key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean persist ( Long key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( T key , T newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( String key , String newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( Long key , Long newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( T key , T newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( String key , String newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( Long key , Long newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

}
