package com.lamp.ledis.commands;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.net.Connection;
import com.lamp.ledis.net.ConnectionFactory;
import com.lamp.ledis.net.ConnectionPattern ;
import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.DataConversion;
import com.lamp.ledis.protocol.EecutionMode ;
import com.lamp.ledis.serialize.Deserialize;
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
	
	
	
	public  final Boolean combinationReturnBoolean(CombinationElement ce,List<DataConversion> dataList ){
		return (Boolean) combination(ce, dataList);
	}
	
	public  final Long combinationReturnLong(CombinationElement ce,List<DataConversion> dataList ){
		return (Long) combination(ce, dataList);
	}
	
	@SuppressWarnings( "unchecked" )
	public  final List<T> combinationReturnList(CombinationElement ce,List<DataConversion> dataList ){
		return (List<T>) combination(ce, dataList);
	}
	

	
	@SuppressWarnings("unchecked")
	public  final <T>T combination(CombinationElement ce,List<DataConversion> dataList ){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			conn = connectionPattern.getConnection();
			OutputStream out = conn.getOutputStream();
			ce.getAgreementPretreatment().perteatmentOut(out , 0 );
			AgreementPretreatment.ListReferenceAgreementPretreatment( out , dataList , ce.getAgreementPretreatment( ).getLength( ) );
			out.flush();
			buffer = DataConversion.getBuffer();
			Object t= ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);
			if( t == null && buffer.position( ) == 0){
				return (T)  ce.getResultHandle().getNullOjbect( keyCreate );
			}
			return (T) ( t == null?ce.getResultHandle().handle( buffer  , keyCreate):t );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( new String( buffer.array( ) ) ) ;
			return (T)  ce.getResultHandle().getNullOjbect( keyCreate );
		}finally {
			if( buffer != null)
				buffer.clear();
			connectionPattern.setConnection( conn );
				
		}
	}
	
	
	
	@SuppressWarnings( "unchecked" )
	public final List<T> combinationReturnList(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList){
		return (List<T>)combination( ce , dataList , objectList);
	}
	
	@SuppressWarnings( "unchecked" )
	public final List<T> combinationReturnListString(CombinationElement ce,List<DataConversion> dataList ,List<String> objectList){
		return (List<T>)combinationString( ce , dataList , objectList);
	}
	
	@SuppressWarnings( "unchecked" )
	public final List<T> combinationReturnListLong(CombinationElement ce,List<DataConversion> dataList ,List<? extends Number > objectList){
		return (List<T>)combinationLong( ce , dataList , objectList);
	}
	
	public final long combinationParameterListReturnLong(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList,KeyCreate< T > keyCreate){
		return (long)combinations( ce , dataList , objectList , keyCreate);
	}
	
	
	public final boolean combinationParameterListReturnBooblean(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList,KeyCreate< T > keyCreate){
		return (boolean)combinations( ce , dataList , objectList , keyCreate);
	}
	
	public final boolean combinationParameterListStringReturnBooblean(CombinationElement ce,List<DataConversion> dataList ,List<String> objectList){
		return (boolean)combinationString( ce , dataList , objectList);
	}
	
	public final boolean combinationParameterListLongReturnBooblean(CombinationElement ce,List<DataConversion> dataList ,List<Number> objectList){
		return (boolean)combinationLong( ce , dataList , objectList);
	}
	
	
	public  final T combination(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList){
		return combinations( ce , dataList , objectList , this.keyCreate );
	}
	
	final T combinations(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList,KeyCreate<T> keyCreate){
		return combination( ce , dataList , objectList ,keyCreate );
	}
	
	@SuppressWarnings( "unchecked" )
	final  List<T> combinationHash(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList,KeyCreate<T> keyCreate){
		return (List< T >)combination( ce , dataList , objectList ,keyCreate );
	}
	
	@SuppressWarnings( "unchecked" )
	public  final T combinationString(CombinationElement ce,List<DataConversion> dataList ,List<String> objectList){
		return combination( ce , dataList ,  (List<T>)objectList , null );
	}
	
	@SuppressWarnings( "unchecked" )
	public  final T combinationLong(CombinationElement ce,List<DataConversion> dataList ,List<? extends Number > objectList){
		return combination( ce , dataList ,  (List<T>)objectList , null );
	}
	
	
	private final <T>T  combination(CombinationElement ce,List<DataConversion> dataList ,List<T> objectList , KeyCreate<T> keyCreate){
		Connection conn   = null;
		ByteBuffer buffer = null;
		try {
			if(objectList.size( ) == 0){
				keyCreate = ( KeyCreate< T > ) this.keyCreate;
				return  ce.getResultHandle().getNullOjbect( keyCreate );
			}
			conn = connectionPattern.getConnection();
			OutputStream out = conn.getOutputStream();
			EecutionMode ecutionMode = ce.getAgreementPretreatment( ).getExecutioMode( );
			ce.getAgreementPretreatment().perteatmentOut(out , ecutionMode.getMultiple( ) * objectList.size( ) + ecutionMode.getBase( ));
			if( ecutionMode  == EecutionMode.STRING_MGET  || ecutionMode == EecutionMode.MAP_MGET ){
				AgreementPretreatment.ListReferenceAgreementPretreatment( out , dataList , objectList , 1 ,  keyCreate );
			}else if ( ecutionMode  == EecutionMode.STRING_MSET || ecutionMode == EecutionMode.MAP_MSET){
				AgreementPretreatment.HashReferenceAgreementPretreatment( out , dataList , objectList , keyCreate );
			}else if ( ecutionMode == EecutionMode.MAP_MSET){
				int index = 0;
				
				for( ; ; ){
				
					objectList.get( index++ );
				}
			}
			out.flush();
			buffer = DataConversion.getBuffer();
			T t= (T)ce.getResolveNetProtocol().analysis(conn.getInputStream(), buffer);
			keyCreate = ( KeyCreate< T > ) this.keyCreate;
			if( t == null && buffer.position( ) == 0){
				return  ce.getResultHandle().getNullOjbect( keyCreate );
			}
			return ( t == null? ce.getResultHandle().handle( buffer  , keyCreate):t );
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
