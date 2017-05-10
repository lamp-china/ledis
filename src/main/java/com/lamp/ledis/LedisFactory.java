package com.lamp.ledis;

import java.util.HashMap ;
import java.util.Map ;

import com.lamp.ledis.configuration.SingleConfiguration ;

public class LedisFactory {

	private SingleConfiguration  defaultSingleConfiguration;
	
	private Map<String , SingleConfiguration> singleConfigurationMap =  new HashMap<>();

	public SingleConfiguration getDefaultSingleConfiguration ( ) {
		return defaultSingleConfiguration ;
	}

	public void setDefaultSingleConfiguration ( SingleConfiguration singleConfiguration ) {
		this.defaultSingleConfiguration = singleConfiguration ;
	}
	
	public void addSingleConfiguration( SingleConfiguration singleConfiguration ){
		this.singleConfigurationMap.put( singleConfiguration.getName( )  , singleConfiguration );
	}
	
	
	public void init(){
		
	}
}
 