package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.AgreementPretreatment;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class StringCommandsElement {
	
	
	/**
	 *在字符串后面添加数据
	 */
	public static final CombinationElement APPEND_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "append" , true ), ResolveNetProtocol.resolveIntNetProtocol, null);
	
	public static final CombinationElement BITCOUNT_ELEMENT = new CombinationElement(new AgreementPretreatment(2 , "bitcount" , true ), ResolveNetProtocol.resolveIntNetProtocol, null);
	
	/**
	 * 占时不支持
	 */
	public static final CombinationElement BITOP_ELEMENT = new CombinationElement(new AgreementPretreatment(2 , "bitcount" , true ), ResolveNetProtocol.resolveIntNetProtocol, null);
	
	
	/**
	 * 递减 decr
	 */
	public static final CombinationElement DECR_ELEMENT = new CombinationElement(new AgreementPretreatment(2 , "decr" , true ), ResolveNetProtocol.resolveSingleNetProtocol , null);
	
	/**
	 * 减去 设定值
	 */
	public static final CombinationElement DECRBY_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "decrby" , true ), ResolveNetProtocol.resolveSingleNetProtocol , null);
	
	
	public static final CombinationElement GET_ELEMENT = new CombinationElement(new AgreementPretreatment(2 , "get" , true ), ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	public static final CombinationElement GETBIT_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "getbit" , true ), ResolveNetProtocol.resolveIntNetProtocol , null);
	
	public static final CombinationElement GETRANGE_ELEMENT = new CombinationElement(new AgreementPretreatment(4 , "getrange" , true ), ResolveNetProtocol.resolveIntNetProtocol , ResultHandle.stringResultHandle);
	
	public static final CombinationElement GETSET_ELEMENT = new CombinationElement(new AgreementPretreatment(4 , "getset" , true ), ResolveNetProtocol.resolveIntNetProtocol , ResultHandle.objcetResultHandle);
	
	public static final CombinationElement INCR_ELEMENT = new CombinationElement(new AgreementPretreatment(2 , "incr" , true ), ResolveNetProtocol.resolveIntNetProtocol , null);
	
	public static final CombinationElement INCRBY_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "incrby" , true ), ResolveNetProtocol.resolveIntNetProtocol , null);
	
	public static final CombinationElement INCRBYFLOAT_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "incrbyfloat" , true ), ResolveNetProtocol.resolveIntNetProtocol , null);
	
	public static final CombinationElement MGET_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "mget" , false ), ResolveNetProtocol.resolveIntNetProtocol , ResultHandle.typeReferenceListResultHandle);
	
	public static final CombinationElement MSET_ELEMENT = new CombinationElement(new AgreementPretreatment(3 , "mset" , false ), ResolveNetProtocol.resolveIntToBooleanNetProtocol , null);
	
	public static final CombinationElement MSETNX_ELEMENT = new CombinationElement( new AgreementPretreatment(3 , "msetnx" , false ), ResolveNetProtocol.resolveIntToBooleanNetProtocol , null );
	
	public static final CombinationElement PSETNX_ELEMENT = new CombinationElement( new AgreementPretreatment(4 , "psetnx" , true ), ResolveNetProtocol.resolveIntNetProtocol , null );
	
	public static final CombinationElement SET_ELEMENT = new CombinationElement( new AgreementPretreatment(3 , "set" , true ), ResolveNetProtocol.resolveStateNetProtocol , null );
	
	public static final CombinationElement SETBIT_ELEMENT = new CombinationElement( new AgreementPretreatment(3 , "setbit" , true ), ResolveNetProtocol.resolveStateNetProtocol , null );
	
	public static final CombinationElement SETEX_ELEMENT = new CombinationElement( new AgreementPretreatment(4 , "setex" , true ), ResolveNetProtocol.resolveStateNetProtocol , null );
	
	public static final CombinationElement SETEN_ELEMENT = new CombinationElement( new AgreementPretreatment(3 , "seten" , true ), ResolveNetProtocol.resolveStateNetProtocol , null );
	
	public static final CombinationElement SETRANGE_ELEMENT = new CombinationElement( new AgreementPretreatment(3 , "setrange" , true ), ResolveNetProtocol.resolveIntNetProtocol , null );
	
	public static final CombinationElement STRLEN_ELEMENT = new CombinationElement( new AgreementPretreatment(2 , "strlen" , true ), ResolveNetProtocol.resolveIntNetProtocol , null );
	
	
	
	
	
	

	
	
	
	
	
	public static final CombinationElement setElement = new CombinationElement(new AgreementPretreatment(3 , "set" , true ), ResolveNetProtocol.resolveStateNetProtocol , null);
	

	
	
	
}
