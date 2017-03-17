package com.lamp.ledis.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.lamp.ledis.create.KeyCreate;

/**
 * 每个comm 
 * @author laohu
 *
 */
public class AgreementPretreatment {

	private byte[ ] perteatment;
	private boolean boo;

	
	
	public AgreementPretreatment( int length , String comman ) {
		this( length , comman , true );
	}

	public AgreementPretreatment( int length , String comman , boolean boo ) {
		if ( boo ) {
			this.perteatment = ProtocolUtil.getCommanByte( length , comman );
		} else {
			this.perteatment = ProtocolUtil.getCommanByte( comman );
		}
		this.boo = boo;
	}

	public void perteatmentOut( OutputStream os , int length ) throws IOException {
		if ( !boo ) {

		}
		os.write( perteatment );
	}


	
	public <T> void referenceAgreementPretreatment(OutputStream os , List<T> comman , List<T> data , KeyCreate< T > mapKey){
		
	}
	
	public final static void OneReferenceAgreementPretreatment( OutputStream os , String one ) throws IOException {
		ProtocolUtil.write( os , one );
	}

	public final static void TwoReferenceAgreementPretreatment( OutputStream os , String one , String two )
			throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
	}

	public final static void ThreeReferenceAgreementPretreatment( OutputStream os , String one , String two ,
			String three ) throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
		ProtocolUtil.write( os , three );
	}

	public final static void FourReferenceAgreementPretreatment( OutputStream os , String one , String two ,
			String three , String four ) throws IOException {
		ProtocolUtil.write( os , one );
		ProtocolUtil.write( os , two );
		ProtocolUtil.write( os , three );
		ProtocolUtil.write( os , four );
	}

	public final static void ListReferenceAgreementPretreatment( OutputStream os ,  List< DataConversion > list , int num ) {
			
	}

	
	interface ListReferenceAgreementPretreatment{
		
		void execute(OutputStream os ,  List< DataConversion > list);
	}
	
	static class OneListReferenceAgreementPretreatment implements ListReferenceAgreementPretreatment{

		@Override
		public void execute( OutputStream os , List< DataConversion > list ) {
			ProtocolUtil.write( os , list.get( 0 ). );
			
		}
		
	}
}