package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class CombinationElement {
	private AgreementPretreatment agreementPretreatment;
	
	private ResolveNetProtocol<Object> resolveNetProtocol;
	private ResultHandle resultHandle;
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CombinationElement(AgreementPretreatment agreementPretreatment,
			ResolveNetProtocol resolveNetProtocol, ResultHandle resultHandle) {
		super();
		this.agreementPretreatment = agreementPretreatment;
		this.resolveNetProtocol = resolveNetProtocol;
		this.resultHandle = resultHandle;
	}

	public AgreementPretreatment getAgreementPretreatment() {
		return agreementPretreatment;
	}

	public ResolveNetProtocol<Object> getResolveNetProtocol() {
		return resolveNetProtocol;
	}

	public ResultHandle getResultHandle() {
		return resultHandle;
	}	
}
