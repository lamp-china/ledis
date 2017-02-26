package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class CombinationElement {
	
	public static CombinationElement newCombinationElement(int length, String comman, ResolveNetProtocol<?> resolveNetProtocol){
		return newCombinationElement( length , comman ,true , resolveNetProtocol ,null);
	}
	
	
	public static CombinationElement newCombinationElement ( int length , String comman  ,boolean boo, ResolveNetProtocol< ? > resolveNetProtocol ) {
		return newCombinationElement( length , comman ,boo , resolveNetProtocol ,null);
	}	
	
	public static CombinationElement newCombinationElement(int length, String comman,ResolveNetProtocol<?> resolveNetProtocol ,ResultHandle resultHandle){
		return newCombinationElement( length , comman ,false , resolveNetProtocol ,resultHandle );
	}
	
	public static CombinationElement newCombinationElement(int length, String comman,boolean boo, ResolveNetProtocol<?> resolveNetProtocol ,ResultHandle resultHandle){
		return newCombinationElement( new AgreementPretreatment( length , comman ,boo) , resolveNetProtocol , resultHandle);
	}
	
	public  static CombinationElement newCombinationElement(AgreementPretreatment agreementPretreatment,ResolveNetProtocol<?> resolveNetProtocol, ResultHandle resultHandle){
		return new CombinationElement(agreementPretreatment , resolveNetProtocol , resultHandle);
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


}
