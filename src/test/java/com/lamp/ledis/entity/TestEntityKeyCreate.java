package com.lamp.ledis.entity;

import java.nio.ByteBuffer;

import com.lamp.ledis.create.AbstractKeyCreate;
import com.lamp.ledis.create.KeyConfigure;

public class TestEntityKeyCreate extends AbstractKeyCreate<TestEntity> {



	public TestEntityKeyCreate( KeyConfigure< TestEntity > keyConfigure ) {
		super( keyConfigure );
		// TODO 自动生成的构造函数存根
	}


	@Override
	public String getKeySuffix(TestEntity t) {
		return getKey(t.getId());
	}


	@Override
	public void getKeySuffixBuffer ( TestEntity t , ByteBuffer byteBuffer ) {
		this.getKey( t.getId( ) , byteBuffer );
	}
}
