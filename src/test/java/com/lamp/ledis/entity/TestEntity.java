package com.lamp.ledis.entity;

/**
 * @author muqi
 *
 */
public class TestEntity {

	private int id;
	
	
	private int appId;
	
	private String name;

	
	
	
	public TestEntity(){
		
	}
	
	public TestEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	
	
	public TestEntity(int id, int appId, String name) {
		super( ) ;
		this.id = id ;
		this.appId = appId ;
		this.name = name ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAppId ( ) {
		return appId ;
	}

	public void setAppId ( int appId ) {
		this.appId = appId ;
	}

	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
