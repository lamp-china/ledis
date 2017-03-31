package com.lamp.ledis.configuration ;

import java.util.ArrayList ;
import java.util.List ;

import com.lamp.ledis.utils.BasicAttributes ;

public class SentinelConfiguration extends SingleConfiguration {

	private boolean separate;
	
	private List< RedisNode > nodeList = new ArrayList<>( ) ;

	public SentinelConfiguration addNode ( String host ) {
		this.addNode( host , BasicAttributes.DEFAULT_POST , -1 );
		return this ;
	}

	public SentinelConfiguration addNode ( String host , int post ) {
		this.addNode( host , post , -1 );
		return this ;
	}

	public SentinelConfiguration addNode ( String host , int post , int select ) {
		this.nodeList.add( new RedisNode( host , post , select ) );
		return this ;
	}

	public List< RedisNode > getNodeList ( ) {
		return nodeList ;
	}

	public void setNodeList ( List< RedisNode > nodeList ) {
		this.nodeList = nodeList ;
	}

	public boolean isSeparate ( ) {
		return separate ;
	}

	public void setSeparate ( boolean separate ) {
		this.separate = separate ;
	}

    

}
