package com.lamp.ledis.protocol ;

public enum EecutionMode {

	DEFAULT ( 10000 ) ,

	STRING_MSET ( 10010 ,2 ,1) , STRING_MGET ( 10020 ) ,

	MAP_MSET ( 10110 ,2 ,2) , MAP_MGET ( 10120 ,1,2),
	
	GET_VALUE(10210 , 1,1)
	
	;

	private int ecutionMode ;

	private int multiple;
	
	private int base;
	
	
	EecutionMode(int ecutionMode ) {
		this( ecutionMode , 1  , 1);
	}
	
	EecutionMode(int ecutionMode , int multiple , int base) {
		this.ecutionMode = ecutionMode ;
		this.multiple = multiple;
		this.base     = base;
	}

	public int getEcutionMode ( ) {
		return ecutionMode ;
	}


	public int getMultiple ( ) {
		return multiple ;
	}


	public int getBase ( ) {
		return base ;
	}


	
	
}
