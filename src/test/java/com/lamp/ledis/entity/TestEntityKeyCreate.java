package com.lamp.ledis.entity;

import java.nio.ByteBuffer;

import com.lamp.ledis.create.AbstractKeyCreate;

public class TestEntityKeyCreate extends AbstractKeyCreate<TestEntity> {

	public TestEntityKeyCreate(String key) {
		super(key);
	}

	@Override
	public String getKeySuffix(TestEntity t) {
		return getKey(t.getId());
	}

	@Override
	public ByteBuffer getKeySuffixBuffer ( TestEntity t ) {
		// TODO 自动生成的方法存根
		return null ;
	}
}
