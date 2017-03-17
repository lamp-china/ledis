package com.lamp.ledis.serialize;

import java.nio.ByteBuffer ;
import java.nio.LedisHeapByteBuffer;

import com.alibaba.fastjson.JSON;
import com.lamp.ledis.protocol.DataConversion;

public class JsonDeToSerialize implements Deserialize , Serialize{


	private static final JsonDeToSerialize jsonDeToSerialize = new JsonDeToSerialize();
	
	public static final Serialize SERIALIZE_DEFAULT = jsonDeToSerialize;
	
	public static final Deserialize DESERIALIZE_DEFAULT = jsonDeToSerialize;
	
	@Override
	public ByteBuffer execute(Object o) {
		if(o instanceof String){
			return new LedisHeapByteBuffer( ( (String) o).getBytes( ));
		}else {
			return new LedisHeapByteBuffer( JSON.toJSONBytes( o  ) );
		}
	}

	@Override
	public byte[] executeByte ( Object o ) {
		return JSON.toJSONBytes( o  ) ;
	}


	@Override
	public String executeString ( Object o ) {
		return JSON.toJSONString(o) ;
	}

	public <T>T execute(byte[] by, Class<T> clazz) {
		return JSON.parseObject(by, clazz);
	}






}
