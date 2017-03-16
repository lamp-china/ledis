package com.lamp.ledis.serialize;

import java.nio.ByteBuffer ;

import com.alibaba.fastjson.JSON;

public class JsonDeToSerialize implements Deserialize , Serialize{


	private static final JsonDeToSerialize jsonDeToSerialize = new JsonDeToSerialize();
	
	public static final Serialize SERIALIZE_DEFAULT = jsonDeToSerialize;
	
	public static final Deserialize DESERIALIZE_DEFAULT = jsonDeToSerialize;
	
	@Override
	public ByteBuffer execute(Object o) {
		if(o instanceof String){
			
		}else {
			
		}
		return JSON.toJSONString(o);
	}

	@Override
	public byte[] executeByte ( Object o ) {
		// TODO 自动生成的方法存根
		return null ;
	}


	@Override
	public String executeString ( Object o ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	public <T>T execute(byte[] by, Class<T> clazz) {
		return JSON.parseObject(by, clazz);
	}






}
