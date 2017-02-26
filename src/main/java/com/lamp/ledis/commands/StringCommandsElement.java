package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class StringCommandsElement {
	
	
	/**
	 *在字符串后面添加数据
	 */
	public static final CombinationElement APPEND_ELEMENT      =  CombinationElement.newCombinationElement(  3 , "append"        , ResolveNetProtocol.resolveIntNetProtocol   );
	
	public static final CombinationElement BITCOUNT_ELEMENT    =  CombinationElement.newCombinationElement(  2 , "bitcount"     ,  ResolveNetProtocol.resolveIntNetProtocol   );
	
	/**
	 * 占时不支持
	 */
	public static final CombinationElement BITOP_ELEMENT       =  CombinationElement.newCombinationElement(  2 , "bitcount"     ,  ResolveNetProtocol.resolveIntNetProtocol    );
	
	
	/**
	 * 递减 decr
	 */
	public static final CombinationElement DECR_ELEMENT        =  CombinationElement.newCombinationElement(  2 , "decr"         ,  ResolveNetProtocol.resolveSingleNetProtocol );
	
	/**
	 * 减去 设定值
	 */
	public static final CombinationElement DECRBY_ELEMENT      =  CombinationElement.newCombinationElement(  3 , "decrby"       ,  ResolveNetProtocol.resolveSingleNetProtocol );
	
	
	public static final CombinationElement GET_ELEMENT         =  CombinationElement.newCombinationElement(  2 , "get"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	public static final CombinationElement GETBIT_ELEMENT      =  CombinationElement.newCombinationElement(  3 , "getbit"       ,  ResolveNetProtocol.resolveIntNetProtocol   );
	
	public static final CombinationElement GETRANGE_ELEMENT    =  CombinationElement.newCombinationElement(  4 , "getrange"     ,  ResolveNetProtocol.resolveIntNetProtocol , ResultHandle.stringResultHandle);
	
	public static final CombinationElement GETSET_ELEMENT      =  CombinationElement.newCombinationElement(  4 , "getset"       ,  ResolveNetProtocol.resolveIntNetProtocol , ResultHandle.objcetResultHandle);
	
	public static final CombinationElement INCR_ELEMENT        =  CombinationElement.newCombinationElement(  2 , "incr"         ,  ResolveNetProtocol.resolveIntNetProtocol   );
	
	public static final CombinationElement INCRBY_ELEMENT      =  CombinationElement.newCombinationElement(  3 , "incrby"       ,  ResolveNetProtocol.resolveIntNetProtocol   );
	
	public static final CombinationElement INCRBYFLOAT_ELEMENT =  CombinationElement.newCombinationElement(  3 , "incrbyfloat"  ,  ResolveNetProtocol.resolveIntNetProtocol   );
	
	public static final CombinationElement MGET_ELEMENT        =  CombinationElement.newCombinationElement(  3 , "mget"         , false ,  ResolveNetProtocol.resolveManyToListNetProtocol , ResultHandle.typeReferenceListResultHandle);
	
	public static final CombinationElement MSET_ELEMENT 	   =  CombinationElement.newCombinationElement(  3 , "mset"         , false ,  ResolveNetProtocol.resolveIntToBooleanNetProtocol  );
	
	public static final CombinationElement MSETNX_ELEMENT 	   =  CombinationElement.newCombinationElement(  3 , "msetnx"       , false ,  ResolveNetProtocol.resolveIntToBooleanNetProtocol  );
	
	public static final CombinationElement PSETNX_ELEMENT 	   =  CombinationElement.newCombinationElement(  4 , "psetnx"       ,  ResolveNetProtocol.resolveIntNetProtocol    );
	
	public static final CombinationElement SET_ELEMENT         =  CombinationElement.newCombinationElement(  3 , "set"          ,  ResolveNetProtocol.resolveStateNetProtocol  );
	
	public static final CombinationElement SETBIT_ELEMENT      =  CombinationElement.newCombinationElement(  3 , "setbit"       ,  ResolveNetProtocol.resolveStateNetProtocol  );
	
	public static final CombinationElement SETEX_ELEMENT       =  CombinationElement.newCombinationElement(  4 , "setex"        ,  ResolveNetProtocol.resolveStateNetProtocol  );
	
	public static final CombinationElement SETEN_ELEMENT       =  CombinationElement.newCombinationElement(  3 , "seten"        ,  ResolveNetProtocol.resolveStateNetProtocol  );
	
	public static final CombinationElement SETRANGE_ELEMENT    =  CombinationElement.newCombinationElement(  3 , "setrange"     ,  ResolveNetProtocol.resolveIntNetProtocol    );
	
	public static final CombinationElement STRLEN_ELEMENT      =  CombinationElement.newCombinationElement(  2 , "strlen"       ,  ResolveNetProtocol.resolveIntNetProtocol    );
		
}
