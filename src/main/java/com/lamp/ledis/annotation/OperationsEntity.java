package com.lamp.ledis.annotation ;

import com.lamp.ledis.commands.Commands ;

public class OperationsEntity {

	/**
	 * 数据检测与校验不放在这里处理
	 * @param operationsObject
	 */
	public void setOperationListMap (OperationsObject operationsObject , Class< ? > clazz) {
		String name = operationsObject.name( );
		Operation defaults,string, hash , list,set,sortedSet,pubSub;
		defaults  = operationsObject.operations( ) ;
		string    = operationsObject.string( ) ;
		hash      = operationsObject.hash( ) ;
		list      = operationsObject.list( ) ;
		set       = operationsObject.set( ) ;
		sortedSet = operationsObject.sortedSet( ) ;
		pubSub    = operationsObject.pubSub( ) ;
		if ( defaults == null && string == null && hash == null && list == null && set == null && sortedSet == null
				&& pubSub == null ) {
			throw new RuntimeException( "class name : " + clazz.getName( ) + " is to name :" + name ) ;
		}
		
		
		
		setClazz( clazz );
		OperationEntity oe = setOperationEntity(defaults, defaults, null,null ,clazz);
		setString(    setOperationEntity( defaults , string    , Commands.STRING    , oe  , clazz ) );
		setHash(      setOperationEntity( defaults , hash      , Commands.HASH      , oe  , clazz ) );
		setList(      setOperationEntity( defaults , list      , Commands.LIST      , oe  , clazz ) );
		setPubSub(    setOperationEntity( defaults , pubSub    , Commands.PUBSUB    , oe  , clazz ) );
		setSet(       setOperationEntity( defaults , set       , Commands.SET       , oe  , clazz ) );
		setSortedSet( setOperationEntity( defaults , sortedSet , Commands.SORTEDSET , oe  , clazz ) );
	}

	
	
	public OperationEntity setOperationEntity(Operation defaults,Operation operation  , Commands commands , OperationEntity operationEntity ,  Class< ? > clazz){
		if(operation == null){
			return operationEntity;
		}
		OperationEntity  oe = new OperationEntity();
		oe.setClazz( clazz );
		oe.setDataSource( assignment( operation.dataSource( ) , operation.dataSource( ) ));
		oe.setKey(        assignment( operation.key( )        , defaults.key( )         ));
		oe.setMapKey(     assignment( operation.mapKey( )     , defaults.mapKey( )      ));
		oe.setMapPrefix(  assignment( operation.mapPrefix( )  , defaults.mapPrefix( )   ));
		oe.setName(       assignment( operation.name( )       , defaults.name( )        ));
		oe.setPattern(    assignment( operation.pattern( )    , defaults.pattern( )     ));
		oe.setPrefix(     assignment( operation.prefix( )     , defaults.prefix( )      ));
		oe.setSeparator(  assignment( operation.separator( )  , defaults.separator( )   ));
		oe.setSliceKey(   assignment( operation.sliceKey( )   , defaults.sliceKey( )    ));
		oe.setValue(      assignment( operation.value( )      , defaults.value( )       ));
		oe.setSeparator(  assignment( operation.separator( )  , defaults.separator( )   ));
		return oe;
	}
	
	public Pattern[] assignment(Pattern[] original , Pattern[] defaults ){
		if(original.length == 0){
			return defaults;
		}
		return original;
	}
	
	public String assignment(String original , String defaults ){
		if( original != null && "".equals( original )  ){
			return original;
		}
		return defaults;
	}
		String name ;

		OperationEntity operations ;

		OperationEntity string ;

		OperationEntity hash ;

		OperationEntity list ;

		OperationEntity set ;

		OperationEntity sortedSet ;

		OperationEntity pubSub ;
		
		Class< ? >  Clazz;

		public String getName ( ) {
			return name ;
		}

		public void setName ( String name ) {
			this.name = name ;
		}

		public OperationEntity getOperations ( ) {
			return operations ;
		}

		public void setOperations ( OperationEntity operations ) {
			this.operations = operations ;
		}

		public OperationEntity getString ( ) {
			return string ;
		}

		public void setString ( OperationEntity string ) {
			this.string = string ;
		}

		public OperationEntity getHash ( ) {
			return hash ;
		}

		public void setHash ( OperationEntity hash ) {
			this.hash = hash ;
		}

		public OperationEntity getList ( ) {
			return list ;
		}

		public void setList ( OperationEntity list ) {
			this.list = list ;
		}

		public OperationEntity getSet ( ) {
			return set ;
		}

		public void setSet ( OperationEntity set ) {
			this.set = set ;
		}

		public OperationEntity getSortedSet ( ) {
			return sortedSet ;
		}

		public void setSortedSet ( OperationEntity sortedSet ) {
			this.sortedSet = sortedSet ;
		}

		public OperationEntity getPubSub ( ) {
			return pubSub ;
		}

		public void setPubSub ( OperationEntity pubSub ) {
			this.pubSub = pubSub ;
		}

		public Class< ? > getClazz ( ) {
			return Clazz ;
		}

		public void setClazz ( Class< ? > clazz ) {
			Clazz = clazz ;
		}

		

}
