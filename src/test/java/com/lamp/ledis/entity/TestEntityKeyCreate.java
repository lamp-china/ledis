package com.lamp.ledis.entity;

import com.lamp.ledis.create.AbstractKeyCreate;

public class TestEntityKeyCreate extends AbstractKeyCreate<TestEntity> {

	public TestEntityKeyCreate(String key) {
		super(key);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public byte[] getKeySuffix(TestEntity t) {
		// TODO 自动生成的方法存根
		return getKey(t.getId());
	}

}
