package com.lamp.ledis.commands;
import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.Deserialize;
import com.lamp.ledis.serialize.Serialize;

import redis.clients.jedis.Client;

public abstract class AbstractLedis<T> {

	protected Serialize serialize;
	
	protected Deserialize deserialize;
	
	protected KeyCreate<T> keyCreate;
	
	protected Client client;
	
	protected Class clazz;
	
	public AbstractLedis(Client client ,Serialize serialize , Deserialize deserialize , KeyCreate<T> keyCreate){
		this.serialize   = serialize;
		this.deserialize = deserialize;
		this.keyCreate   = keyCreate;
		this.client      = client;
	}
	

	@SuppressWarnings("unchecked")
	protected T getOjbect(){
		byte[] by = client.getBinaryBulkReply();
		return (T)deserialize.execute( by , clazz);		
	}
}
