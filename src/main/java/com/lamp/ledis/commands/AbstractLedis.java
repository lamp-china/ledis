package com.lamp.ledis.commands;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.net.Connection;
import com.lamp.ledis.net.ConnectionFactory;
import com.lamp.ledis.net.ConnectionPattern ;
import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.DataConversion;
import com.lamp.ledis.serialize.Deserialize;
import com.lamp.ledis.serialize.JsonDeToSerialize;
import com.lamp.ledis.serialize.Serialize;

public abstract class AbstractLedis<T> {

	
	protected Serialize serialize;
	
	protected Deserialize deserialize;
	
	protected KeyCreate<T> keyCreate;
	
	
	private ConnectionPattern connectionPattern;
	
	public AbstractLedis(Serialize serialize , Deserialize deserialize , KeyCreate<T> keyCreate){
		this( serialize , deserialize , keyCreate , null );
	}
		
	
	
	public AbstractLedis(
			Serialize serialize, Deserialize deserialize, KeyCreate< T > keyCreate, String dataSource
	) {
		super( ) ;
		this.serialize = serialize ;
		this.deserialize = deserialize ;
		this.keyCreate = keyCreate ;
		if( dataSource == null){
			this.connectionPattern = ConnectionFactory.getInstance( ).getConnectionPattern( ) ;
		}else{
			this.connectionPattern = ConnectionFactory.getInstance( ).getConnectionPattern( dataSource );
		}
	}



	@SuppressWarnings("unchecked")
	public  final T combination(CombinationElement ce,List<DataConversion> dataList ,List<Object> list){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = connectionPattern.getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , dataList.size( )+ list.size( ) );
			AgreementPretreatment.ListReferenceAgreementPretreatment( out , dataList , ce.getAgreementPretreatment( ).getLength( ) );
			out.flush();
			buffer = conn.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);		
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if( buffer != null)
				buffer.clear();
			connectionPattern.setConnection( conn );
				
		}
	}
	
	@SuppressWarnings("unchecked")
	public  final T combination(CombinationElement ce,List<DataConversion> dataList ){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = connectionPattern.getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , 0 );
			AgreementPretreatment.ListReferenceAgreementPretreatment( out , dataList , ce.getAgreementPretreatment( ).getLength( ) );
			out.flush();
			buffer = conn.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);		
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if( buffer != null)
				buffer.clear();
			connectionPattern.setConnection( conn );
				
		}
	}
	
	
}
