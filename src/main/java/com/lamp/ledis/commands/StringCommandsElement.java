package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class StringCommandsElement {
	
	public static final CombinationElement getElement = new CombinationElement(new AgreementPretreatment(2 , "get" , true ), ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	public static final CombinationElement setElement = new CombinationElement(new AgreementPretreatment(3 , "set" , true ), ResolveNetProtocol.resolveStateNetProtocol , null);
}
