package com.lamp.ledis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap ;
import java.util.List;
import java.util.Map ;

import com.lamp.ledis.annotation.OperationsEntity;
import com.lamp.ledis.commands.CommandsObjectFactory;
import com.lamp.ledis.commands.RedisCommands;
import com.lamp.ledis.configuration.SingleConfiguration ;
import com.lamp.ledis.exception.ConfigureException;
import com.lamp.ledis.net.ConnectionFactory;
import com.lamp.ledis.net.NetAndPoolConfig;
import com.lamp.ledis.net.NetConfigure;
import com.lamp.ledis.net.PoolConfig;

public class LedisFactory {

	private SingleConfiguration  defaultSingleConfiguration;
	
	private Map<String , SingleConfiguration> singleConfigurationMap =  new HashMap<>();

	public SingleConfiguration getDefaultSingleConfiguration ( ) {
		return defaultSingleConfiguration ;
	}

	public void setDefaultSingleConfiguration ( SingleConfiguration singleConfiguration ) {
		this.defaultSingleConfiguration = singleConfiguration ;
	}
	
	public void addSingleConfiguration( SingleConfiguration singleConfiguration ) throws ConfigureException{
		String name = singleConfiguration.getName( );
		if( name == null && "".equals( name )){			
			throw new ConfigureException("非默认 singleConfiguration 必须要有 name，错误配置是：" +  singleConfiguration.toString( ));
		}
		if( this.singleConfigurationMap.containsKey( name )){
			throw new ConfigureException("已经存在 name 的 singleConfiguration ，错误配置是：" +  singleConfiguration.toString( ));
		}
		this.singleConfigurationMap.put( singleConfiguration.getName( )  , singleConfiguration );
	}
	
	
	public void init() throws ConfigureException{
		if( defaultSingleConfiguration == null && this.singleConfigurationMap.isEmpty( ) ){
			throw new ConfigureException("defaultSingleConfiguration 与  singleConfigurationMap 不能都为空");
		}
				
		if( defaultSingleConfiguration == null){
			throw new ConfigureException("defaultSingleConfiguration 不能为空");
		}
		NetAndPoolConfig netAndPoolConfig = getNetAndPoolConfig( defaultSingleConfiguration );
		if( !this.singleConfigurationMap.isEmpty( ) ){
			List<NetAndPoolConfig> list = new ArrayList<>(singleConfigurationMap.size( ) );
			Collection< SingleConfiguration > singleConfigurationCollection = singleConfigurationMap.values( );
			for(SingleConfiguration singleConfiguration  : singleConfigurationCollection){
				list.add( getNetAndPoolConfig( singleConfiguration ) );
			}
			ConnectionFactory.getInstance( ).init( netAndPoolConfig , list );
		}else{
			ConnectionFactory.getInstance( ).init( netAndPoolConfig.getNetConfigure( ) , netAndPoolConfig.getPoolConfig( ) );
		}
	}
	
	private NetAndPoolConfig getNetAndPoolConfig( SingleConfiguration singleConfiguration){
		NetConfigure netConfigure = new NetConfigure( );
		netConfigure.setHost( singleConfiguration.getHost( ) );
		if(singleConfiguration.getPost( ) != 0){
			
			netConfigure.setPost( singleConfiguration.getPost( ) );
		}
		PoolConfig   poolConfig   = new PoolConfig( );
		poolConfig.setConnectionMode( singleConfiguration.getConnectionMode( ) );
		poolConfig.setNetMode( singleConfiguration.getNetMode( ) );
		poolConfig.setMaxTotal( singleConfiguration.getConnectionNum( ) );
		poolConfig.setSelect( singleConfiguration.getSelect( ) );
		
		NetAndPoolConfig netAndPoolConfig = new NetAndPoolConfig( );	
		netAndPoolConfig.setName( singleConfiguration.getName( ) );
		netAndPoolConfig.setNetConfigure( netConfigure );
		netAndPoolConfig.setPoolConfig( poolConfig );
		return netAndPoolConfig;
	}
	
	
	@SuppressWarnings ( "rawtypes" )
	public RedisCommands getRedisCommands( OperationsEntity operationsEntity ){
		return CommandsObjectFactory.getInstance( ).getRedisCommands( operationsEntity );
	}
	
	@SuppressWarnings ( "rawtypes" )
	public RedisCommands getRedisCommands( String name ){
		return CommandsObjectFactory.getInstance( ).getRedisCommands( name );
	}
	
}
 