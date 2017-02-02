package com.lamp.ledis.net;

import org.junit.Before;
import org.junit.Test;

public class ConnectionFactoryTest {

	@Before
	public void info() {
		ConnectionFactory.getInstance().init();
	}

	@Test
	public void connectionTest() {

	}

}
