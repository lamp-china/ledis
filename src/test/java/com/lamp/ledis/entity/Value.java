package com.lamp.ledis.entity;

public interface Value<K,V,T> {

	T setValue(K k , V v);
}
