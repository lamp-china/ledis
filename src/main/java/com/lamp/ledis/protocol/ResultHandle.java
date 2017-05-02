package com.lamp.ledis.protocol;

import java.nio.ByteBuffer;
import java.util.Collections ;

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
	
	public static final ResultHandle   typeReferenceKeyListResultHandle = new TypeReferenceKeyListResultHandle();
	
	
	public <T>T handle(ByteBuffer buffer  , KeyCreate<T> kc);
	
	public <T>T getNullOjbect(KeyCreate< T > keyCreate);
	

	static class ByteResultHandle implements ResultHandle{
		private static final byte[] object = new byte[0];
		
		
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {
			byte[] by = new byte[buffer.position()];
			buffer.get( by );
			return (T)by;
		}

		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect (KeyCreate< T > keyCreate ) {
			return (T)object ;
		}		
	}
	
	static class StringResultHandle implements ResultHandle{
		private static final String object = "";
		
		@Override
		@SuppressWarnings("unchecked")
		public  <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {	
			return (T)new String( buffer.array() , 0 , buffer.position());
		}

		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return (T)object ;
		}		
	}	
	static class ObjcetResultHandle implements ResultHandle{
		
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer,  KeyCreate<T> kc) {
			return (T)JSON.parseObject(buffer.array(), 0, buffer.position(), IOUtils.UTF8, kc.getEntityClass());
		}

		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return keyCreate.getOject( ) ;
		}	
	}
	
	static class TypeReferenceListResultHandle implements ResultHandle{
		
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T) JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceList());
		}
		
		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return (T)Collections.EMPTY_LIST ;
		}
	}
	static class TypeReferenceSetResultHandle implements ResultHandle{	
		
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T)JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceSet());
		}
		
		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return (T)Collections.EMPTY_SET;
		}
	}
	static class TypeReferenceMapResultHandle implements ResultHandle{
		
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T)JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceMap());
		}
		
		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return (T)Collections.EMPTY_MAP ;
		}
	}
	
	static class TypeReferenceKeyListResultHandle implements ResultHandle{
		
		@Override
		@SuppressWarnings("unchecked")
		public <T>T handle(ByteBuffer buffer, KeyCreate<T> kc) {
			return (T) JSON.parseObject( new String(buffer.array(), 0, buffer.position()), kc.getTypeReferenceKeyListResultHandle());
		}
		
		@SuppressWarnings( "unchecked" )
		@Override
		public < T > T getNullOjbect ( KeyCreate< T > keyCreate ) {
			return (T)Collections.EMPTY_LIST ;
		}
	}
}
