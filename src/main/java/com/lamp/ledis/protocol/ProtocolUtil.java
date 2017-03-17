package com.lamp.ledis.protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ProtocolUtil {

	private final static int  numberLimit             =  101;
	private final static int  longGegreeLimit         =  1001;
	
	private final static int  NUM_STRING_BYTE_LIMIT   =  10000;
	
	private final static byte[][] number              = new byte[ numberLimit - 1 ][];
	
	private final static byte[][] longGegree          = new byte[ longGegreeLimit - 1 ][];
	
	private final static byte[][] NUM_STRING_BYTE     = new byte[ NUM_STRING_BYTE_LIMIT - 1 ][];
	
	
	private final static char numberSymbolString      ='*';

	private final static byte numberSymbolByte        = (byte)numberSymbolString;
	
	
	private final static char longGegreeSymbolString  ='$';

	private final static byte longGegreeSymbolByte    = (byte)longGegreeSymbolString;
	
	
	public final static byte ENTER = '\r';
	
	public final static byte WARP = '\n';
	
	
	
	private final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999,Integer.MAX_VALUE };

	private final static byte [] DigitTens = {
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
            } ;

	private final static byte [] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            } ;

    private final static byte[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
        };
	
	
	static{
		for(int i = 0 ;i< numberLimit-1 ; i++){
			number[ i ] = getNumberAndLongByte( i , numberSymbolByte);
		}
		
		for(int i = 0 ;i<  longGegreeLimit-1 ; i++){
			longGegree[ i ] = getNumberAndLongByte( i , longGegreeSymbolByte);
		}
		for(int i = 0 ;i<  NUM_STRING_BYTE_LIMIT-1 ; i++){
			NUM_STRING_BYTE[ i ] = getNumberAndLongByte( i );
		}
	}
	
	public final static byte[] getNumberByte( int i){		
		if( i < numberLimit){
			return number[ i ];
		}		
		return getNumberAndLongByte( i , numberSymbolByte);
	}
	
	public final static byte[] getLongGegreeByte( int i){
		if( i < longGegreeLimit ){
			return longGegree[ i ];
		}		
		return getNumberAndLongByte( i , longGegreeSymbolByte);
	}
	
	public final static byte[] getNumStringByteArray( int i){
		if( i < NUM_STRING_BYTE_LIMIT ){
			return NUM_STRING_BYTE[ i ];
		}		
		return getNumberAndLongByte( i );
	}
	
	private final static byte[] getNumberAndLongByte( long i){
	     byte[] buf = new byte[ stringSizeArray(i) ];
	     getChars(i, buf.length, buf);    
	     return buf;
	}
	
	
	private final static byte[] getNumberAndLongByte( long i , byte symbol){
		 int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
	     byte[] buf = new byte[size+3];
	     buf[0] = symbol;
	     getChars(i, size, buf);
	     buf[ ++size ] = '\r';
		 buf[ ++size ] = '\n';
	     
	     return buf;

	}
	
	
	public final static byte[] getCommanByte(String comman){
		int commanLeng = stringSize( comman.length() );
		byte[] buf = new byte[ commanLeng +3 + comman.length()+2];
		int index = 0;
		buf[ ++index] = longGegreeSymbolString;
		getChars( commanLeng , index = index +  commanLeng, buf);
		buf[ ++index ] = '\r';
		buf[ ++index ] = '\n';
		byte[] strbyte = comman.getBytes();
		for( int i = 0 ; i< strbyte.length ; i++){
			buf[ ++index ] = strbyte[ i ];
		}		
		return buf;
	}
	
	
	public final static byte[] getCommanByte(int length , String comman){
		int size = (length < 0) ? stringSize(-length) + 1 : stringSize(length);
		int commanLeng = stringSize( comman.length() );
		byte[] buf = new byte[ size + 3 + commanLeng +3 + comman.length()+2];
		int index = 0;
		buf[ index ] = numberSymbolString;
		getChars( length , (index = index + size)+1, buf);
		buf[ ++index ] = '\r';
		buf[ ++index ] = '\n';
		buf[ ++index] = longGegreeSymbolString;
		getChars( comman.length() , (index = index +  commanLeng )+1, buf);
		buf[ ++index ] = '\r';
		buf[ ++index ] = '\n';
		byte[] strbyte = comman.getBytes();
		for( int i = 0 ; i< strbyte.length ; i++){
			buf[ ++index ] = strbyte[ i ];
		}
		buf[ ++index ] = '\r';
		buf[ ++index ] = '\n';
		return buf;
	}
	
	
	public final static void write(OutputStream os ,String str ) throws IOException{
		if( str == null){
			return;
		}
		byte[] b = str.getBytes();
		
		os.write( longGegreeSymbolString );
		//TODO    ,,这里要优化啊
		os.write( Long.toString(str.getBytes().length).getBytes());
		//getChars( b.length ,  os );
		os.write('\r');
		os.write('\n');
		os.write( b );
		os.write('\r');
		os.write('\n');
	}
	
	public final static void write(OutputStream os ,byte[] b ) throws IOException{
		
		os.write( longGegreeSymbolString );
		//TODO    ,,这里要优化啊
		os.write( Long.toString(b.length).getBytes());
		//getChars( b.length ,  os );
		os.write('\r');
		os.write('\n');
		os.write( b );
		os.write('\r');
		os.write('\n');
	}
	
	public final static void write(OutputStream os ,ByteBuffer bytebuffer) throws IOException{
		os.write( longGegreeSymbolString );
		//TODO    ,,这里要优化啊
		os.write( Long.toString(bytebuffer.position( )).getBytes());
		//getChars( b.length ,  os );
		os.write('\r');
		os.write('\n');
		os.write( bytebuffer.array( ) , 0 ,  bytebuffer.position( ));
		os.write('\r');
		os.write('\n');
		bytebuffer.clear( );
	}
	
    private final static int stringSize(long x) {
        long p = 10;
        for (int i=1; i<19; i++) {
            if (x < p)
                return i;
            p = 10*p;
        }
        return 19;
    }
	
   private final static int stringSizeArray(long x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    } 
    static void getChars(long i, int index, byte[] buf) {
        long q;
        int r;
        int charPos = index;
        byte sign = 0;
        if (i < 0) {
            sign = '-';
            i = -i;
        }
        // Get 2 digits/iteration using longs until quotient fits into an int
        while (i > Integer.MAX_VALUE) {
            q = i / 100;
            // really: r = i - (q * 100);
            r = (int)(i - ((q << 6) + (q << 5) + (q << 2)));
            i = q;
            buf[--charPos] = DigitOnes[r];
            buf[--charPos] = DigitTens[r];
        }
        // Get 2 digits/iteration using ints
        int q2;
        int i2 = (int)i;
        while (i2 >= 65536) {
            q2 = i2 / 100;
            // really: r = i2 - (q * 100);
            r = i2 - ((q2 << 6) + (q2 << 5) + (q2 << 2));
            i2 = q2;
            buf[--charPos] = DigitOnes[r];
            buf[--charPos] = DigitTens[r];
        }
        // Fall thru to fast mode for smaller numbers
        // assert(i2 <= 65536, i2);
        for (;;) {
            q2 = (i2 * 52429) >>> (16+3);
            r = i2 - ((q2 << 3) + (q2 << 1));  // r = i2-(q2*10) ...
            buf[--charPos] = digits[r];
            i2 = q2;
            if (i2 == 0) break;
        }
        if (sign != 0) {
            buf[--charPos] = sign;
        }
    }
    
    public static final void getChars(long i, ByteBuffer byteBuffer) {
    	
    	getChars( i , byteBuffer.position( ) + stringSizeArray(i) , byteBuffer.array( ) );
    }
    
    
    static void getChars(long i, OutputStream os) throws IOException {
        long q;
        int r;
        byte sign = 0;
        if (i < 0) {
            sign = '-';
            i = -i;
        }
        while (i > Integer.MAX_VALUE) {
            q = i / 100;
            r = (int)(i - ((q << 6) + (q << 5) + (q << 2)));
            i = q;
            os.write( DigitOnes[r]);
            os.write( DigitTens[r]);
        }
        int q2;
        int i2 = (int)i;
        while (i2 >= 65536) {
            q2 = i2 / 100;
            r = i2 - ((q2 << 6) + (q2 << 5) + (q2 << 2));
            i2 = q2;
            os.write( DigitOnes[r]);
            os.write( DigitTens[r]);
        }
        for (;;) {
            q2 = (i2 * 52429) >>> (16+3);
            r = i2 - ((q2 << 3) + (q2 << 1));  // r = i2-(q2*10) ...
            os.write( DigitOnes[r]);
            i2 = q2;
            if (i2 == 0) break;
        }
        if (sign != 0) {
        	os.write( sign );
        }
    }

    public static long getNumLeng(long num){
    	return num;
    }
    
}
