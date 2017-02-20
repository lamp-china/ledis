package com.lamp.ledis.create;

import java.util.List ;

import com.alibaba.fastjson.TypeReference ;

public class AmsTypeReference<T> {
	
	private String classAmsName;
	
	private String objectName;
	
	private String clazzName;
	
	private Class<T> clazz;
	
	private String trListObejctName;
	
	private TypeReference<List<T>> trList;

	private String trMapObejctName;
	

	private TypeReference<?> trMap;

	
	
	
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
	
	public Class<T> getClazz ( ) {
		return clazz ;
	}

	public void setClazz ( Class<T> clazz ) {
		this.clazz = clazz ;
	}

	public String getTrListObejctName ( ) {
		return trListObejctName ;
	}

	public void setTrListObejctName ( String trListObejctName ) {
		this.trListObejctName = trListObejctName ;
	}

	public TypeReference<List<T>> getTrList ( ) {
		return trList ;
	}


	public void setTrList ( TypeReference<List<T>> trList ) {
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
