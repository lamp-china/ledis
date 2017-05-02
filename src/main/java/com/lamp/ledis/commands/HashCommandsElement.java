package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.EecutionMode ;
import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

public class HashCommandsElement {

    /*
     * Hdel single
     */
 	public static final CombinationElement HDEL_SINGLE      =  CombinationElement.newCombinationElement(  3 , "hdel"        , ResolveNetProtocol.resolveIntToBooleanNetProtocol   );
 	
 	/*
 	 * more
 	 */
 	public static final CombinationElement HDEL_MORE        =  CombinationElement.create( ).setComman( "hdel" ).setExecutioMode( EecutionMode.STRING_MGET ).buildBoolean();
 			                                                   
 	
 	/*
 	 * Hexists
 	 */
 	public static final CombinationElement HEXISTS          =  CombinationElement.newCombinationElement(  3 , "hexists"      , ResolveNetProtocol.resolveIntToBooleanNetProtocol   );

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
     public static final CombinationElement HKEYS           =  CombinationElement.newCombinationElement(  2 , "hkeys"        , ResolveNetProtocol.resolveManyToListNetProtocol ,ResultHandle.typeReferenceKeyListResultHandle);
     
     /*
      * Hlen 
      */
     public static final CombinationElement HLEN            =  CombinationElement.newCombinationElement(  2 , "hlen"        , ResolveNetProtocol.resolveIntNetProtocol);
     /*
      * Hmget
      */
     public static final CombinationElement HMGET           =   CombinationElement.create( ).setComman( "hmget" ).setExecutioMode( EecutionMode.MAP_MGET ).setResolveNetProtocol( ResolveNetProtocol.resolveManyToListNetProtocol ).build( );
    
     /*
      * Hmset 
      */
     public static final CombinationElement HMSET           =  CombinationElement.create( ).setComman( "hmset" ).setExecutioMode( EecutionMode.MAP_MSET ).setResolveNetProtocol( ResolveNetProtocol.resolveStateNetProtocol ).build( );
    		 												 
     /*
      * Hset 
      */
     public static final CombinationElement HSET            =  CombinationElement.newCombinationElement(  4 , "hset"        , ResolveNetProtocol.resolveIntToBooleanNetProtocol );
     /*
      * Hsetnx
      */
     public static final CombinationElement HSETNX          =  CombinationElement.newCombinationElement(  4 , "hsetnx"        , ResolveNetProtocol.resolveIntNetProtocol );
     /*
      * Hvals 
      */
     public static final CombinationElement HVALS           =  CombinationElement.newCombinationElement(  2 , "hvals"        , ResolveNetProtocol.resolveManyToListNetProtocol ,ResultHandle.typeReferenceListResultHandle);
     

}
