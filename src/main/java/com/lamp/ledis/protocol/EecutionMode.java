package com.lamp.ledis.protocol ;

public enum EecutionMode {

	DEFAULT ( 10000 ) ,

	STRING_MSET ( 10010 ,2) , STRING_MGET ( 10020 ) ,

	MAP_MSET ( 10110 ,2) , MAP_MGET ( 10120 );

	private int ecutionMode ;

	private int multiple;
	
	
	EecutionMode(int ecutionMode ) {
		this( ecutionMode , 1 );
	}
	
	EecutionMode(int ecutionMode , int multiple) {
		this.ecutionMode = ecutionMode ;
		this.multiple = multiple;
	}

	public int getEcutionMode ( ) {
		return ecutionMode ;
	}

	public void setEcutionMode ( int ecutionMode ) {
		this.ecutionMode = ecutionMode ;
	}

	public int getMultiple ( ) {
		return multiple ;
	}

	public void setMultiple ( int multiple ) {
		this.multiple = multiple ;
	}
}
