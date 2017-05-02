package com.lamp.ledis.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer ;
import java.util.ArrayList ;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;
import com.lamp.ledis.serialize.JsonDeToSerialize ;

/**
 * 每个comm 
 * @author laohu
 *
 */
public class AgreementPretreatment {

	private static final List<ListReferenceAgreementPretreatment>  REFERNCE_LIST = new ArrayList<>( 10 );
	
	
	static {
		REFERNCE_LIST.add( new OneListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new TwoListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new ThreeListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new FourListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new FiveListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new SixListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new SevenListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new EightListReferenceAgreementPretreatment( ) );
		REFERNCE_LIST.add( new NineListReferenceAgreementPretreatment( ) );
	}
	
	private byte[ ] perteatment;
	private boolean boo;
	private int length;
	
	private EecutionMode executioMode;
	
	public AgreementPretreatment( int length , String comman ) {
		this( length , comman , true ,EecutionMode.DEFAULT);
	}

	public AgreementPretreatment( int length , String comman , boolean boo , EecutionMode executioMode) {
		this.length = length-2;
		if ( boo ) {
			this.perteatment = ProtocolUtil.getCommanByte( length , comman );
		} else {
			this.perteatment = ProtocolUtil.getCommanByte( comman );
		}
		this.boo = boo;
		this.executioMode = executioMode;
	}
	
	
	
	public int getLength(){
		return this.length;
	}

	
	
	
	public EecutionMode getExecutioMode ( ) {
		return executioMode ;
	}

	public void setExecutioMode ( EecutionMode executioMode ) {
		this.executioMode = executioMode ;
	}

	public void perteatmentOut( OutputStream os , int length ) throws IOException {
		if ( !boo ) {
			os.write( ProtocolUtil.getNumberByte( length  ) );
		}
		os.write( perteatment );
	}


	
	public <T> void referenceAgreementPretreatment(OutputStream os , List<T> comman , List<T> data , KeyCreate< T > mapKey){
		
	}


	public final static void ListReferenceAgreementPretreatment( OutputStream os ,  List< DataConversion > list , int num ) throws IOException {
			REFERNCE_LIST.get( num ).execute( os , list );
	}

	public final static <T> void ListReferenceAgreementPretreatment( OutputStream out , List< DataConversion > list , List<T> objectList ,int num ,KeyCreate< T > keyCreate) throws IOException{
		ProtocolUtil.write( out , list.get( 0 ).getWriteByteBuffer( ) );
		int i = objectList.size( );
		ByteBuffer bb;
		for( ; ; ){
			if( keyCreate != null){
				bb= DataConversion.getBuffer( );
				keyCreate.getKeySuffixBuffer( objectList.get( --i) , bb);
				ProtocolUtil.write( out ,  bb) ;
			}else{
				ProtocolUtil.write( out , JsonDeToSerialize.SERIALIZE_DEFAULT.execute( objectList.get( --i) ) );
			}
			if( i == 0){
				break;
			}
		}
		if( num != 0)
			REFERNCE_LIST.get( num ).execute( out , list );
	}
	
	public final static <T> void HashReferenceAgreementPretreatment( OutputStream out , List< DataConversion > list , List<?> objectList , KeyCreate<  T > keyCreate) throws IOException{
		ProtocolUtil.write( out , list.get( 0 ).getWriteByteBuffer( ) );
		int i = objectList.size( )  , len = 0;
		T o ;
		ByteBuffer bb;
		for( ; ; ){
			o = ( T ) objectList.get( len++ );
			bb= DataConversion.getBuffer( );
			keyCreate.getKeySuffixBuffer( o , bb);
			ProtocolUtil.write( out ,  bb) ;
			ProtocolUtil.write( out , JsonDeToSerialize.SERIALIZE_DEFAULT.execute( o ) );
			if( len == i){
				break;
			}
		}
	}
	
	
	interface ListReferenceAgreementPretreatment{
		
		void execute(OutputStream os ,  List< DataConversion > list) throws IOException;
	}
	
	static class OneListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			
		}
		
	}
	static class TwoListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
		}
	}
	
	static class ThreeListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class FourListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
		}
	}
	
	static class FiveListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class SixListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
		}
	}
	
	static class SevenListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
		}
	}
	
	
	static class EightListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 7 ).getWriteByteBuffer( ) );
		}
	}
	
	static class NineListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) throws IOException {
			ProtocolUtil.write( os , list.get( 0 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 1 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 2 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 3 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 4 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 5 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 6 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 7 ).getWriteByteBuffer( ) );
			ProtocolUtil.write( os , list.get( 8 ).getWriteByteBuffer( ) );
		}
	}
}