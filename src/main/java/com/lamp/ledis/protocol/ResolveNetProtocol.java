package com.lamp.ledis.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.lamp.ledis.utils.LedisInputStream;
/**
 * 网络协议解析器，
 * redis是一个比较简单的数据库，所以返回的数据，规范不是很明确，造成了这个解析器设计非常纠结
 * 
 * @author muqi
 *
 * @param <T>
 */
public interface ResolveNetProtocol<T> {

	public static final ResolveNetProtocol<Boolean> 	resolveStateNetProtocol 		= new ResolveStateNetProtocol();
	
	public static final ResolveNetProtocol<Long>    	resolveIntNetProtocol   		= new ResolveIntNetProtocol();
	
	public static final ResolveNetProtocol<Boolean>		resolveIntToBooleanNetProtocol  = new ResolveIntToBooleanNetProtocol();
	
	public static final ResolveNetProtocol<Long>        resolveSingleNetProtocol        = new ResolveSingleNetProtocol();
	
	public static final ResolveNetProtocol<Long>        resolveStringNetProtocol        = resolveSingleNetProtocol;
	
	public static final ResolveNetProtocol<Long>		resolveManyToListNetProtocol    = new ResolveManyToListNetProtocol();
	
	public static final ResolveNetProtocol<Long>		resolveManyToMapNetProtocol     = new ResolveManyToMapNetProtocol();

	
	
	public T analysis(LedisInputStream in,ByteBuffer buffer) throws IOException;
	
	
	
	abstract class ResolveExceedinglyNetProtocol<T> implements ResolveNetProtocol<T> {

		@SuppressWarnings("unused")
		private static final String ASK_RESPONSE = "ASK";
		@SuppressWarnings("unused")
		private static final String MOVED_RESPONSE = "MOVED";
		@SuppressWarnings("unused")
		private static final String CLUSTERDOWN_RESPONSE = "CLUSTERDOWN";
		@SuppressWarnings("unused")
		private static final String BUSY_RESPONSE = "BUSY";
		@SuppressWarnings("unused")
		private static final String NOSCRIPT_RESPONSE = "NOSCRIPT";

		void execcdingly(LedisInputStream in , byte head) throws IOException{
			int i = in.readHead();
			if( i != head){
				if( i== '-'){
					analysis(in);					
				}else{
					//异常
				}
			} 
		}
		
		String getString(ByteBuffer buffer){
			String str = new String( buffer.array(),0,buffer.position());
			buffer.clear();
			return str;
		}
		public T analysis(LedisInputStream in) throws IOException {
			ByteBuffer buffer = ByteBuffer.allocate( 8148 );
			in.readLindBytes( buffer );
			String str = new String( buffer.array(),0,buffer.position());
			buffer.clear();
			throw new RuntimeException( str );
		}
	}
	public static  class ResolveStateNetProtocol extends ResolveExceedinglyNetProtocol<Boolean>{		
		private final static byte head = '+';		
		public Boolean analysis(LedisInputStream in,ByteBuffer buffer) throws IOException {
			execcdingly(in, head);
			return in.readOKCrLf();
		}
	}
	public static class ResolveIntNetProtocol extends ResolveExceedinglyNetProtocol<Long>{
		private static final byte head = ':';
		public Long analysis(LedisInputStream in,ByteBuffer buffer) throws IOException {
			execcdingly(in, head);
			return in.readLongCrLf();	
		}

	}
	public static class ResolveIntToBooleanNetProtocol extends ResolveExceedinglyNetProtocol<Boolean>{
		private final static byte head = ':';	
		public Boolean analysis(LedisInputStream in,ByteBuffer buffer) throws IOException {
			execcdingly(in, head);
			return in.readLongCrLf() == 1;
		}
	}
	
	
	abstract class ResolveManyNetProtocol extends ResolveExceedinglyNetProtocol<Long> {
		private final static byte head = '*';	
		byte divisionSymblo(){
			return ',';
		}	
		byte stringDistinguish(){
			return '"';
		}	
		abstract byte startSymbol();	
		abstract byte endSymbol();		
		void getData( LedisInputStream in ,ByteBuffer buffer) throws IOException{
			if(in.readHead() == ':'){
				buffer.putLong( in.readLongCrLf() );
			}else{	
				buffer.put( stringDistinguish());
				in.readLind(buffer);	
				buffer.put( stringDistinguish());
			}
		}
		
		/**
		 * 数组 [1，2]
		 * map {1：2 , 3:3}
		 * 开始与结束符 ，
		 * 分隔符
		 * map 的分隔符，
		 * 字符串双引号
		 * @throws IOException 
		 */
		public Long analysis(LedisInputStream in,ByteBuffer buffer) throws IOException {
			execcdingly(in, head);
			buffer.put( startSymbol());
			long i = in.readLongCrLf();
			for ( ; ; ){
				supplement(in, buffer);
				if(--i >0){
					buffer.put( divisionSymblo() );
				}else{
					buffer.put( endSymbol());
					return null;
				}
			}
		}	
		abstract void supplement(LedisInputStream in ,ByteBuffer buffer) throws IOException;
		
	}

	public static class ResolveManyToListNetProtocol extends ResolveManyNetProtocol{

		@Override
		byte startSymbol() {
			return '[';
		}
		@Override
		byte endSymbol() {
			return ']';
		}
		@Override
		void supplement(LedisInputStream in, ByteBuffer buffer) throws IOException {	
			getData(in, buffer);
		}
	}


	public static class ResolveManyToMapNetProtocol extends ResolveManyNetProtocol{

		private static final byte semicolon = ':';
		@Override
		byte startSymbol() {
			return '{';
		}
		@Override
		byte endSymbol() {
			return '}';
		}
		@Override
		void supplement(LedisInputStream in, ByteBuffer buffer) throws IOException {
			getData(in, buffer);
			buffer.put( semicolon );
			getData(in, buffer);		
		}
	}

	
	public  class ResolveSingleNetProtocol extends ResolveExceedinglyNetProtocol<Long> {
		private static final byte head = '$';		
		boolean getByte( LedisInputStream in,ByteBuffer buffer) throws IOException{
			execcdingly(in, head);
			return in.readLind(buffer);
		}
		public Long analysis(LedisInputStream in,ByteBuffer buffer) throws IOException {
			if(in.readHead() == ':'){
				return in.readLongCrLf() ;
			}else{	
				in.readLind(buffer);
				return null;
			}
		}
	}	
}

