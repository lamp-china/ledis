package com.lamp.ledis.annotation;

public class OperationEntity {

	private String name;

	private String prefix;
	
	private String separator;
	
	private String key;
	
	private String mapPrefix;
	
	private String mapKey; 
	
	private String dataSource;
	
	private Pattern[] pattern;
	
	private String sliceKey;

	private Class<?> clazz;
	

	public OperationEntity(
			String name, String prefix, String separator, String key, String mapPrefix, String mapKey, String dataSource,
			Pattern[] pattern, String sliceKey, Class< ? > clazz
	) {
		super( ) ;
		this.name = name ;
		this.prefix = prefix ;
		this.separator = separator ;
		this.key = key ;
		this.mapPrefix = mapPrefix ;
		this.mapKey = mapKey ;
		this.dataSource = dataSource ;
		this.pattern = pattern ;
		this.sliceKey = sliceKey ;
		this.clazz = clazz ;
	}

	public String getName ( ) {
		return name ;
	}

	public void setName ( String name ) {
		this.name = name ;
	}

	public String getPrefix ( ) {
		return prefix ;
	}

	public void setPrefix ( String prefix ) {
		this.prefix = prefix ;
	}

	public String getSeparator ( ) {
		return separator ;
	}

	public void setSeparator ( String separator ) {
		this.separator = separator ;
	}

	public String getKey ( ) {
		return key ;
	}

	public void setKey ( String key ) {
		this.key = key ;
	}

	public String getMapPrefix ( ) {
		return mapPrefix ;
	}

	public void setMapPrefix ( String mapPrefix ) {
		this.mapPrefix = mapPrefix ;
	}

	public String getMapKey ( ) {
		return mapKey ;
	}

	public void setMapKey ( String mapKey ) {
		this.mapKey = mapKey ;
	}


	public String getDataSource ( ) {
		return dataSource ;
	}

	public void setDataSource ( String dataSource ) {
		this.dataSource = dataSource ;
	}

	public Pattern[] getPattern ( ) {
		return pattern ;
	}

	public void setPattern ( Pattern[] pattern ) {
		this.pattern = pattern ;
	}

	public String getSliceKey ( ) {
		return sliceKey ;
	}

	public void setSliceKey ( String sliceKey ) {
		this.sliceKey = sliceKey ;
	}

	public Class< ? > getClazz ( ) {
		return clazz ;
	}

	public void setClazz ( Class< ? > clazz ) {
		this.clazz = clazz ;
	}
	
	
}
