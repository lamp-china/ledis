package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class HashCommandsElement {

    /*
     * Hdel single
     */
 	public static final CombinationElement HDEL_SINGLE      =  CombinationElement.newCombinationElement(  3 , "hdel"        , ResolveNetProtocol.resolveIntNetProtocol   );
 	
 	/*
 	 * more
 	 */
 	public static final CombinationElement HDEL_MORE        =  CombinationElement.newCombinationElement(  3 , "hdel"        , ResolveNetProtocol.resolveIntNetProtocol   );
 	
 	/*
 	 * Hexists
 	 */
 	public static final CombinationElement HEXISTS          =  CombinationElement.newCombinationElement(  3 , "hexists"      , ResolveNetProtocol.resolveIntNetProtocol   );

     /*
      * Hget
      */
  	public static final CombinationElement HGET             =  CombinationElement.newCombinationElement(  3 , "hget"        , ResolveNetProtocol.resolveSingleNetProtocol    , ResultHandle.objcetResultHandle  );
  	
  	
  	/*
  	 * Hgetall 
  	 */
  	public static final CombinationElement HGETALL          =  CombinationElement.newCombinationElement(  2 , "hgetall"     , ResolveNetProtocol.resolveManyToMapNetProtocol , ResultHandle.typeReferenceMapResultHandle);
  	
  	
  	 /*
  	  * Hincrby 
  	  */
     public static final CombinationElement HINCRBY         =  CombinationElement.newCombinationElement(  3 , "hincrby"     , ResolveNetProtocol.resolveIntNetProtocol);
     /*
      * Hincrbyfloat 
      */
     public static final CombinationElement HINCRBYFLOAT    =  CombinationElement.newCombinationElement(  3 , "hincrbyfloat", ResolveNetProtocol.resolveIntNetProtocol);
     /*
      * Hkeys 
      */
     public static final CombinationElement HKEYS           =  CombinationElement.newCombinationElement(  2 , "hkey"        , ResolveNetProtocol.resolveManyToListNetProtocol ,ResultHandle.typeReferenceListResultHandle);
     
     /*
      * Hlen 
      */
     public static final CombinationElement HLEN            =  CombinationElement.newCombinationElement(  2 , "hlen"        , ResolveNetProtocol.resolveIntNetProtocol);
     /*
      * Hmget
      */
     public static final CombinationElement HMGET           =  CombinationElement.newCombinationElement(  2 , "hmget"        , ResolveNetProtocol.resolveManyToListNetProtocol ,ResultHandle.typeReferenceListResultHandle);
     
     /*
      * Hmset 
      */
     public static final CombinationElement HMSET           =  CombinationElement.newCombinationElement(  2 , "hmset"        , ResolveNetProtocol.resolveManyToListNetProtocol );
     /*
      * Hset 
      */
     public static final CombinationElement HSET            =  CombinationElement.newCombinationElement(  4 , "hset"        , ResolveNetProtocol.resolveIntNetProtocol );
     /*
      * Hsetnx
      */
     public static final CombinationElement HSETNX          =  CombinationElement.newCombinationElement(  4 , "hsetnx"        , ResolveNetProtocol.resolveIntNetProtocol );
     /*
      * Hvals 
      */
     public static final CombinationElement HVALS           =  CombinationElement.newCombinationElement(  2 , "hvals"        , ResolveNetProtocol.resolveManyToListNetProtocol ,ResultHandle.typeReferenceListResultHandle);
     

}
