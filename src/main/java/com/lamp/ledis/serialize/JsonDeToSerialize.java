package com.lamp.ledis.serialize;

import com.alibaba.fastjson.JSON;

public class JsonDeToSerialize implements Deserialize , Serialize{

	@Override
	public String execute(Object o) {
		return JSON.toJSONString(o);
	}


	public <T>T execute(byte[] by, Class<T> clazz) {
		return JSON.parseObject(by, clazz);
	}

}
