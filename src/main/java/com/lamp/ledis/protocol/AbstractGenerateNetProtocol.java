package com.lamp.ledis.protocol;

import java.nio.ByteBuffer;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.Serialize;

public abstract class AbstractGenerateNetProtocol implements GenerateNetProtocol{

	private ByteBuffer byteBuffer;
	
	/**
	 * 这样的设计是为了不要出现过多的对象创建，与操作。
	 * 提高性能
	 * @param key
	 */
	public void setByteBuffer(ByteBuffer byteBuffer){
		this.byteBuffer = byteBuffer;
	}
	
	public byte[] parameter(String str){
		read( str );
		return ProtocolUtil.getNumberByte( 1 );
	}
	
	public byte[] parameter(long number){
		return parameter(  Long.toString( number ));
	}
	
	public byte[] parameter( Object t , KeyCreate<Object> keyCreate ){
		//read( keyCreate.getKeyPrefix(), keyCreate.getKey( t ));
		return ProtocolUtil.getNumberByte( 1 );
	}
	
	
	public byte[] parameterList(  List<String> list ){
		int i = 0 , leng = list.size();
		for(; ;){
			parameter ( list.get( i ) );
			if( ++ i == leng){
				break;
			}
		}
		return ProtocolUtil.getNumberByte( i );
	}
	
	public byte[] parameterLongList(  List<Long>  list ){
		int i = 0 , leng = list.size();
		for(; ;){
			parameter ( list.get( i ) );
			if( ++ i == leng){
				break;
			}
		}
		return null;
	}
	
	public byte[] parameterList(  List< Object > list ,KeyCreate<Object> keyCreate){
		int i = 0 , leng = list.size();
		for(; ;){
			parameter( list.get( i ) , keyCreate);
			if( ++ i == leng){
				break;
			}
		}
		return null;
	}
	
	
	public byte[] parameterSet( Object t , KeyCreate<Object> ceyCreate){
		return null;
	}
	
	public byte[] parameterListSet(  List< Object > list ,KeyCreate<Object> ceyCreate , Serialize serialize){
		
		return null;
	}
	
	void inputCommands(byte[] commands) {
		byteBuffer.put( commands );		
	}
	
	void inputKey(byte[] key){
		read( key );
	}
	
	public void read(String str){		
		read(str.getBytes());
	}
	
	
	public void read(byte[] by , byte [] bytwo){	
		byteBuffer.put( ProtocolUtil.getLongGegreeByte( by == null? 0 : by.length + bytwo.length ) );
		warp();
		if(by != null)
			byteBuffer.put( by );
		byteBuffer.put( bytwo );
		warp();
	}
	public void read(byte[] by){
		byteBuffer.put( ProtocolUtil.getLongGegreeByte( by.length) );
		warp();
		byteBuffer.put( by );
		warp();
	}
	
	private void warp(){
		byteBuffer.put( ProtocolUtil.ENTER );
		byteBuffer.put( ProtocolUtil.WARP );
	}
	
	@SuppressWarnings("unused")
	private void readData( byte[] by ){
		if( by != null){
			byteBuffer.put( by );
		}		
	}
}
