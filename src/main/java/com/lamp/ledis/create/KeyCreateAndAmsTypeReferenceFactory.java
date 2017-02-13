package com.lamp.ledis.create ;

import java.util.concurrent.ConcurrentHashMap ;

public class KeyCreateAndAmsTypeReferenceFactory {

	private static final KeyCreateAndAmsTypeReferenceFactory kaaf = new KeyCreateAndAmsTypeReferenceFactory( ) ;

	private KeyCreateAndAmsTypeReferenceFactory() {
		
	}
	public static final KeyCreateAndAmsTypeReferenceFactory getInstance(){
		return kaaf;
	}
	
	
	private final ConcurrentHashMap< String , KeyCreate<?>>  leyCreateMap = new ConcurrentHashMap<>( );
	
	private final ConcurrentHashMap< String , AmsTypeReference>  amsTypeReferenceMap = new ConcurrentHashMap<>( );
	
	public boolean isKeyConfigure(String key){
		return leyCreateMap.containsKey( key );
	}
	
	public void putKeyConfigure(String key , KeyCreate<?> value){
		leyCreateMap.put( key , value );
	}
	
	public KeyCreate<?> getKeyCreate(String key){
		return leyCreateMap.get( key );
	}
	
	public boolean isAmsTypeReference(String key){
		return amsTypeReferenceMap.containsKey( key );
	}
	
	public void putAmsTypeReference(String key , AmsTypeReference value){
		amsTypeReferenceMap.put( key , value );
	}
	
	public AmsTypeReference getAmsTypeReference(String key){
		return amsTypeReferenceMap.get( key );
	}
	
	public void replace(ConcurrentHashMap< String , Object>   map , String key){
		if( map.containsKey( key )){
			
		}
	}
	
	
	
}
