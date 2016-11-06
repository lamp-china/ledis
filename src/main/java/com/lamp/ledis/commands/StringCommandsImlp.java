package com.lamp.ledis.commands;

import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.Deserialize;
import com.lamp.ledis.serialize.Serialize;

import redis.clients.jedis.Client;

public class StringCommandsImlp<T> extends AbstractLedis<T> implements StringCommands<T>{

	public StringCommandsImlp(Client client, Serialize serialize, Deserialize deserialize, KeyCreate<T> ledis) {
		super(client, serialize, deserialize, ledis);
	}

	@Override
	public T get(T t) {
		client.get( keyCreate.getKey(t) );
		return getOjbect();
	}

	@Override
	public T get(String t) {
		client.get( keyCreate.getKey(t) );
		return getOjbect();
	}

	@Override
	public T get(Number t) {
		client.get( keyCreate.getKey(t) );
		return getOjbect();
	}

	@Override
	public T getSet(T t) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<T> mGet(T... keys) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<T> mGet(List<T> keys) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<T> mGetString(List<String> keys) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<T> mGetNumber(List<Number> keys) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void set(T t) {
		client.set(keyCreate.getKey( t ), serialize.execute( t ));	
		getOjbect();
	}

	@Override
	public Boolean setNX(T t) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setNX(T t, Object o) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setEx(T t) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Boolean setEx(T t, Object o) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void pSetEx(byte[] key, long milliseconds, byte[] value) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mSet(List<T> tuple) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Boolean mSetNX(List<T> tuple) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long incr() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long incrBy(long value) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Double incrBy(double value) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long decr() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long decrBy(long value) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Long strLen(T t) {
		// TODO 自动生成的方法存根
		return null;
	}

}
