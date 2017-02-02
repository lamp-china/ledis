package com.lamp.ledis.create;

import com.alibaba.fastjson.TypeReference ;

public class AmsTypeReference {
	
	private String classAmsName;
	
	private String objectName;
	
	private String clazzName;
	
	@SuppressWarnings( "rawtypes" )
	private Class clazz;
	
	private String trListObejctName;
	
	@SuppressWarnings( "rawtypes" )
	private TypeReference trList;

	private String trMapObejctName;
	
	@SuppressWarnings( "rawtypes" )
	private TypeReference trMap;

	
	
	
	public String getClassAmsName ( ) {
		return classAmsName ;
	}

	public void setClassAmsName ( String classAmsName ) {
		this.classAmsName = classAmsName ;
	}

	public String getObjectName ( ) {
		return objectName ;
	}

	public void setObjectName ( String objectName ) {
		this.objectName = objectName ;
	}

	public String getClazzName ( ) {
		return clazzName ;
	}

	public void setClazzName ( String clazzName ) {
		this.clazzName = clazzName ;
	}

	@SuppressWarnings( "rawtypes" )
	public Class getClazz ( ) {
		return clazz ;
	}

	@SuppressWarnings( "rawtypes" )
	public void setClazz ( Class clazz ) {
		this.clazz = clazz ;
	}

	public String getTrListObejctName ( ) {
		return trListObejctName ;
	}

	public void setTrListObejctName ( String trListObejctName ) {
		this.trListObejctName = trListObejctName ;
	}

	@SuppressWarnings( "rawtypes" )
	public TypeReference getTrList ( ) {
		return trList ;
	}

	@SuppressWarnings( "rawtypes" )
	public void setTrList ( TypeReference trList ) {
		this.trList = trList ;
	}

	public String getTrMapObejctName ( ) {
		return trMapObejctName ;
	}

	public void setTrMapObejctName ( String trMapObejctName ) {
		this.trMapObejctName = trMapObejctName ;
	}

	@SuppressWarnings( "rawtypes" )
	public TypeReference getTrMap ( ) {
		return trMap ;
	}

	@SuppressWarnings( "rawtypes" )
	public void setTrMap ( TypeReference trMap ) {
		this.trMap = trMap ;
	}

	
	
}
