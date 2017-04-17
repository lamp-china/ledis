package com.lamp.ledis.commands;

import java.util.HashMap ;
import java.util.Map ;

import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.EecutionMode ;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class CombinationElement {
	
	private static final Map<ResolveNetProtocol<?> , ResultHandle> RESOLVENET_RESULT_MAP = new HashMap<>( );
	
	static {
		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveIntNetProtocol             , null);
		
		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveStateNetProtocol            , null);

		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveIntToBooleanNetProtocol     , null);
		
		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveStringNetProtocol     , ResultHandle.stringResultHandle);

		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveManyToListNetProtocol , ResultHandle.typeReferenceListResultHandle);
		
		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveManyToMapNetProtocol  , ResultHandle.typeReferenceMapResultHandle);
		
		RESOLVENET_RESULT_MAP.put( ResolveNetProtocol.resolveSingleNetProtocol     , ResultHandle.objcetResultHandle);
		
		
	}
	
	public static CombinationElement newCombinationElement(int length, String comman, ResolveNetProtocol<?> resolveNetProtocol){
		return newCombinationElement( length , comman ,true , resolveNetProtocol ,null);
	}
	
	
	public static CombinationElement newCombinationElement ( int length , String comman  ,boolean boo, ResolveNetProtocol< ? > resolveNetProtocol ) {
		return newCombinationElement( length , comman ,boo , resolveNetProtocol ,null);
	}	
	
	public static CombinationElement newCombinationElement(int length, String comman,ResolveNetProtocol<?> resolveNetProtocol ,ResultHandle resultHandle){
		return newCombinationElement( length , comman ,true , resolveNetProtocol ,resultHandle );
	}
	
	public static CombinationElement newCombinationElement(int length, String comman,boolean boo, ResolveNetProtocol<?> resolveNetProtocol ,ResultHandle resultHandle){
		//TODO 设计问题
		return newCombinationElement( new AgreementPretreatment( length , comman ,boo,EecutionMode.DEFAULT) , resolveNetProtocol , resultHandle);
	}
	
	public  static CombinationElement newCombinationElement(AgreementPretreatment agreementPretreatment,ResolveNetProtocol<?> resolveNetProtocol, ResultHandle resultHandle){
		return new CombinationElement(agreementPretreatment , resolveNetProtocol , resultHandle);
	}
	
	
	public static final  CombinationElementBuilder create(){
		return new CombinationElementBuilder( );
	}
	
	
	private AgreementPretreatment agreementPretreatment;
	
	private ResolveNetProtocol<?> resolveNetProtocol;
	private ResultHandle resultHandle;
	
	
	
	
	public CombinationElement(AgreementPretreatment agreementPretreatment,
			ResolveNetProtocol<?> resolveNetProtocol, ResultHandle resultHandle) {
		super();
		this.agreementPretreatment = agreementPretreatment;
		this.resolveNetProtocol = resolveNetProtocol;
		this.resultHandle = resultHandle;
	}

	public AgreementPretreatment getAgreementPretreatment() {
		return agreementPretreatment;
	}

	public ResolveNetProtocol<?> getResolveNetProtocol() {
		return resolveNetProtocol;
	}

	public ResultHandle getResultHandle() {
		return resultHandle;
	}

	public boolean isRead(){
		return true;
	}
	
	
	public static class CombinationElementBuilder{
		
		private String comman;
		private boolean boo;
		private int length;
		private EecutionMode executioMode;
		
		private ResolveNetProtocol<?> resolveNetProtocol;
		private ResultHandle resultHandle;
		
		
		
		
		public CombinationElementBuilder setComman ( String comman ) {
			this.comman = comman ;
			return this;
		}




		public CombinationElementBuilder setBoo ( boolean boo ) {
			this.boo = boo ;
			return this;
		}




		public CombinationElementBuilder setLength ( int length ) {
			this.length = length ;
			return this;
		}




		public CombinationElementBuilder setExecutioMode ( EecutionMode executioMode ) {
			this.executioMode = executioMode ;
			return this;
		}




		public CombinationElementBuilder setResolveNetProtocol ( ResolveNetProtocol< ? > resolveNetProtocol ) {
			this.resolveNetProtocol = resolveNetProtocol ;
			return this;
		}




		public CombinationElementBuilder setResultHandle ( ResultHandle resultHandle ) {
			this.resultHandle = resultHandle ;
			return this;
		}


		public CombinationElement buildBoolean(){
			ResolveNetProtocol<?> resolveNetProtocol = this.resolveNetProtocol;
			ResultHandle resultHandle = this.resultHandle;
			if( resolveNetProtocol == null  ){
				resolveNetProtocol = ResolveNetProtocol.resolveIntToBooleanNetProtocol;
			}else{
				if( resultHandle == null ){
					resultHandle = RESOLVENET_RESULT_MAP.get( resolveNetProtocol );
				}
			}
			return new CombinationElement( new AgreementPretreatment( this.length , this.comman ,this.executioMode != null ? false : true	, this.executioMode)  , resolveNetProtocol , resultHandle);
		}


		public CombinationElement build(){
			ResolveNetProtocol<?> resolveNetProtocol = this.resolveNetProtocol;
			ResultHandle resultHandle = this.resultHandle;
			if( resolveNetProtocol == null  ){
				resolveNetProtocol = ResolveNetProtocol.resolveIntNetProtocol;
			}else{
				if( resultHandle == null ){
					resultHandle = RESOLVENET_RESULT_MAP.get( resolveNetProtocol );
				}
			}
			return new CombinationElement( new AgreementPretreatment( this.length , this.comman ,this.executioMode != null ? false : true	, this.executioMode)  , resolveNetProtocol , resultHandle);
		}
	}
	
	
	
}
