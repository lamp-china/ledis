package com.lamp.ledis.annotation ;

import java.util.HashMap ;
import java.util.Map ;

import com.lamp.ledis.commands.Commands ;

public class OperationsEntity {

	private static HashMap< Class< ? > , OperationsEntity > operationsEntity_map = new HashMap<>( ) ;

	public static OperationsEntity getOperationEntity ( Class< ? > clazz ) {
		if ( ! operationsEntity_map.containsKey( clazz ) ) {
			operationsEntity_map.put( clazz , new OperationsEntity( clazz ) ) ;
		}
		return operationsEntity_map.get( clazz ) ;
	}

	private Class< ? > clazz ;

	private Map< String , OperationList > operationListMap = new HashMap<>( ) ;

	public OperationsEntity(Class< ? > clazz) {
		super( ) ;
		this.clazz = clazz ;
	}

	public Class< ? > getClazz ( ) {
		return clazz ;
	}

	public void setClazz ( Class< ? > clazz ) {
		this.clazz = clazz ;
	}

	public Map< String , OperationList > getOperationListMap ( ) {
		return operationListMap ;
	}

	/**
	 * 数据检测与校验不放在这里处理
	 * @param operationsObject
	 */
	public void setOperationListMap (OperationsObject operationsObject ) {
		 String name = operationsObject.name( );
		if (name != null && "".equals( name ) && operationListMap.containsKey( name ) ) {
			throw new RuntimeException( "class name : " + clazz.getName( ) + " is to name :" + name ) ;
		}
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
		
		
		OperationList operationList = new OperationList( ) ;
		operationList.setString(    setOperationEntity( defaults , string    , Commands.STRING    ) );
		operationList.setHash(      setOperationEntity( defaults , hash      , Commands.HASH      ) );
		operationList.setList(      setOperationEntity( defaults , list      , Commands.LIST      ) );
		operationList.setPubSub(    setOperationEntity( defaults , pubSub    , Commands.PUBSUB    ) );
		operationList.setSet(       setOperationEntity( defaults , set       , Commands.SET       ) );
		operationList.setSortedSet( setOperationEntity( defaults , sortedSet , Commands.SORTEDSET ) );
		operationListMap.put( name  , operationList ) ;
	}

	
	
	public OperationEntity setOperationEntity(Operation defaults,Operation operation  , Commands commands){
		if(operation == null){
			return null;
		}
		OperationEntity  oe = new OperationEntity();
		
		oe.setDataSource(        operation.dataSource( ) != null ? operation.dataSource( ) :  defaults!=null ? defaults.dataSource( ) : null );
		oe.setKey(               operation.key( )        != null ? operation.key( )        :  defaults!=null ? defaults.key( )        : null );
		oe.setMapKey(            operation.mapKey( )     != null ? operation.mapKey( )     :  defaults!=null ? defaults.mapKey( )     : null );
		oe.setMapPrefix(         operation.mapPrefix( )  != null ? operation.mapPrefix( )  :  defaults!=null ? defaults.mapPrefix( )  : null );
		oe.setName(              operation.name( )       != null ? operation.name( )       :  defaults!=null ? defaults.name( )       : null );
		oe.setPattern(           operation.pattern( )    != null ? operation.pattern( )    :  defaults!=null ? defaults.pattern( )    : null );
		oe.setPrefix(            operation.prefix( )     != null ? operation.prefix( )     :  defaults!=null ? defaults.prefix( )     : null );
		oe.setSeparator(         operation.separator( )  != null ? operation.separator( )  :  defaults!=null ? defaults.separator( )  : null );
		oe.setSliceKey(          operation.sliceKey( )   != null ? operation.sliceKey( )   :  defaults!=null ? defaults.sliceKey( )   : null );
		oe.setValue(             operation.value( )      != null ? operation.value( )      :  defaults!=null ? defaults.value( )      : null );
		oe.setSeparator(         operation.separator( )  != null ? operation.separator( )  :  defaults!=null ? defaults.separator( )  : null );
		return oe;
	}
	
	static class OperationList {

		String name ;

		OperationEntity operations ;

		OperationEntity string ;

		OperationEntity hash ;

		OperationEntity list ;

		OperationEntity set ;

		OperationEntity sortedSet ;

		OperationEntity pubSub ;

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

	}

}
