package com.lamp.ledis.commands;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.net.Connection;
import com.lamp.ledis.net.ConnectionFactory;
import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.DataConversion;
import com.lamp.ledis.serialize.Deserialize;
import com.lamp.ledis.serialize.JsonDeToSerialize;
import com.lamp.ledis.serialize.Serialize;

public abstract class AbstractLedis<T> {

	
	protected Serialize serialize;
	
	protected Deserialize deserialize;
	
	protected KeyCreate<T> keyCreate;
	
	
	public AbstractLedis(Serialize serialize , Deserialize deserialize , KeyCreate<T> keyCreate){
		this.serialize   = serialize == null ? new JsonDeToSerialize():serialize;
		this.deserialize = deserialize;
		this.keyCreate   = keyCreate;
	}
	
	protected void execute(){
		
	}
	
	@SuppressWarnings("unchecked")
	public  final T combination(CombinationElement ce,String key){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , 0 );
			AgreementPretreatment.OneReferenceAgreementPretreatment(out, key);
			out.flush();
			buffer = conn.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);		
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if( buffer != null)
				buffer.clear();
			ConnectionFactory.getInstance().setConnection( conn );
				
		}
	}
	
	@SuppressWarnings("unchecked")
	public  final T combination(CombinationElement ce,String key,String value){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , 0 );
			AgreementPretreatment.TwoReferenceAgreementPretreatment(out, key,value);
			out.flush();
			buffer = conn.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);		
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if( buffer != null)
				buffer.clear();
			ConnectionFactory.getInstance().setConnection( conn );
				
		}
	}
	
	@SuppressWarnings("unchecked")
	public  final T combination(CombinationElement ce,List<DataConversion> dataList ){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , 0 );
			AgreementPretreatment.ListReferenceAgreementPretreatment( out , dataList , ce.getAgreementPretreatment( ).getLength( ) );
			out.flush();
			buffer = conn.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);		
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if( buffer != null)
				buffer.clear();
			ConnectionFactory.getInstance().setConnection( conn );
				
		}
	}
	
	
	
}
