package com.lamp.ledis.serialize;

import com.alibaba.fastjson.JSON;

public class JsonDeToSerialize implements Deserialize , Serialize{

	@Override
	public byte[] execute(Object o) {
		return JSON.toJSONBytes(o);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(byte[] by, Class clazz) {
		return JSON.parseObject(by, clazz);
	}

}
