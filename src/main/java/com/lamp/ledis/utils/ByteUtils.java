package com.lamp.ledis.utils;

/**
 * Created by vp on 2016/8/6.
 */
public class ByteUtils {



    public static byte[] addBytes(byte[] data1, byte[] data2) {
    	if( data1 == null){
    		return data2;
    	}
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;

    }
    public static byte[] intToByteArray(int a) {
        return new byte[] {
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }


    public static byte[] longToByteArray(long a) {
        return new byte[] {
                (byte) ((a >> 56) & 0xFF),
                (byte) ((a >> 48) & 0xFF),
                (byte) ((a >> 40) & 0xFF),
                (byte) ((a >> 32) & 0xFF),
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    public static long byteArrayToLong(byte[] b) {
        return   b[7] & 0xFF |
                (b[6] & 0xFF) << 8  |
                (b[5] & 0xFF) << 16 |
                (b[4] & 0xFF) << 24 |
                (b[3] & 0xFF) << 32 |
                (b[2] & 0xFF) << 40 |
                (b[1] & 0xFF) << 48 |
                (b[0] & 0xFF) << 56
                ;
    }

    public static byte[] StringToByte(String string){
    	return string.getBytes();
    }

    public static byte[] IngeterToByte(Integer in){
    	return StringToByte( in.toString());
    }
    
    public static void main( String[] args){
        byte[] byteArray = intToByteArray(100);
        int   num = byteArrayToInt( byteArray );
        System.out.println( num +"");

        byteArray = longToByteArray(234);
        long longNum = byteArrayToLong( byteArray );
        System.out.println( longNum +"");
    }

}
