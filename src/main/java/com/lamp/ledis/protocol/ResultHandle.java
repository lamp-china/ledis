package com.lamp.ledis.protocol;

import java.nio.ByteBuffer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import com.lamp.ledis.create.KeyCreate;

public interface ResultHandle {
	
	public static final ResultHandle   byteResultHandle   = new ByteResultHandle();
	
	public static final ResultHandle   stringResultHandle = new StringResultHandle();
	
	public static final ResultHandle   objcetResultHandle = new ObjcetResultHandle();
	
	public static final ResultHandle   typeReferenceListResultHandle = new TypeReferenceListResultHandle();
	
	public static final ResultHandle   typeReferenceSetResultHandle  = new TypeReferenceSetResultHandle();
	
	public static final ResultHandle   typeReferenceMapResultHandle  = new TypeReferenceMapResultHandle();
	
	
	public <T>T handle(ByteBuffer buffer  , KeyCreate<T> kc);
	

	static class ByteResultHandle implements ResultHandle{
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {
			byte[] by = new byte[buffer.position()];
			buffer.get( by );
			return (T)by;
		}		
	}
	
	static class StringResultHandle implements ResultHandle{
		@Override
		@SuppressWarnings("unchecked")
		public  <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {	
			return (T)new String( buffer.array() , 0 , buffer.position());
		}		
	}	
	static class ObjcetResultHandle implements ResultHandle{
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {
			return (T)JSON.parseObject(buffer.array(), 0, buffer.position(), IOUtils.UTF8, kc.getEntityClass());
		}		
	}
	
	static class TypeReferenceListResultHandle implements ResultHandle{
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T) JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceList());
		}
	}
	static class TypeReferenceSetResultHandle implements ResultHandle{
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T)JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceSet());
		}
	}
	static class TypeReferenceMapResultHandle implements ResultHandle{
		
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T)JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceMap());
		}
	}
}
