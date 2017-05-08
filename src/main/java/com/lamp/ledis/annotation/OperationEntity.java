package com.lamp.ledis.annotation;

import com.lamp.ledis.commands.Commands ;

/**
 * @author muqi
 *
 */
public class OperationEntity {

	private String name;

	private String prefix;
	
	private String separator;
	
	private String key;
	
	private String combinationKey;
	
	private String mapPrefix;
	
	private String mapKey; 
	
	private String dataSource;
	
	private Pattern[] pattern;
	
	private String sliceKey;

	private Class<?> clazz;
	
	private String value;

	
	private Commands commands;
	
	public String getName ( ) {
		return name ;
	}

	public OperationEntity setName ( String name ) {
		this.name = name ;
		return this;
	}

	public String getPrefix ( ) {
		return prefix ;
	}

	public OperationEntity setPrefix ( String prefix ) {
		this.prefix = prefix ;
		return this;
	}

	public String getSeparator ( ) {
		return separator ;
	}

	public OperationEntity setSeparator ( String separator ) {
		this.separator = separator ;
		return this;
	}

	public String getKey ( ) {
		return key ;
	}

	public OperationEntity setKey ( String key ) {
		this.key = key ;
		return this;
	}

	public String getMapPrefix ( ) {
		return mapPrefix ;
	}

	public OperationEntity setMapPrefix ( String mapPrefix ) {
		this.mapPrefix = mapPrefix ;
		return this;
	}

	public String getMapKey ( ) {
		return mapKey ;
	}

	public OperationEntity setMapKey ( String mapKey ) {
		this.mapKey = mapKey ;
		return this;
	}


	public String getDataSource ( ) {
		return dataSource ;
	}

	public OperationEntity setDataSource ( String dataSource ) {
		this.dataSource = dataSource ;
		return this;
	}

	public Pattern[] getPattern ( ) {
		return pattern ;
	}

	public OperationEntity setPattern ( Pattern[] pattern ) {
		this.pattern = pattern ;
		return this;
	}

	public String getSliceKey ( ) {
		return sliceKey ;
	}

	public OperationEntity setSliceKey ( String sliceKey ) {
		this.sliceKey = sliceKey ;
		return this;
	}

	public Class< ? > getClazz ( ) {
		return clazz ;
	}

	public OperationEntity setClazz ( Class< ? > clazz ) {
		this.clazz = clazz ;
		return this;
	}

	public String getValue ( ) {
		return value ;
	}

	public OperationEntity setValue ( String value ) {
		this.value = value ;
		return this;
	}
	
	
	public String getCombinationKey ( ) {
		return combinationKey ;
	}

	public void setCombinationKey ( String combinationKey ) {
		this.combinationKey = combinationKey ;
	}

	public Commands getCommands ( ) {
		return commands ;
	}

	public void setCommands ( Commands commands ) {
		this.commands = commands ;
	}

	public static final OperationEntity create(){
		return new OperationEntity( );
	}
	
	
	
	
}
