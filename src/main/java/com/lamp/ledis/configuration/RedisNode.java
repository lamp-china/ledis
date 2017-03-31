package com.lamp.ledis.configuration;

import com.lamp.ledis.utils.BasicAttributes ;

public class RedisNode {

	
	private String host;
	
	private int    post = BasicAttributes.DEFAULT_POST;
	
	private int    select = -1;

	
	
	public RedisNode(String host) {
		super( ) ;
		this.host = host ;
	}
	
	
	public RedisNode(String host, int post) {
		super( ) ;
		this.host = host ;
		this.post = post ;
	}



	public RedisNode(String host, int post, int select) {
		super( ) ;
		this.host = host ;
		this.post = post ;
		this.select = select ;
	}




	public String getHost ( ) {
		return host ;
	}

	public void setHost ( String host ) {
		this.host = host ;
	}

	public int getPost ( ) {
		return post ;
	}

	public void setPost ( int post ) {
		this.post = post ;
	}

	public int getSelect ( ) {
		return select ;
	}

	public void setSelect ( int select ) {
		this.select = select ;
	}
	
	
}
