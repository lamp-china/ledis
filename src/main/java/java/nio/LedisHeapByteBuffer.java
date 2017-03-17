package java.nio;

public class LedisHeapByteBuffer extends HeapByteBuffer {

	public LedisHeapByteBuffer( byte[ ] bytes ) {
		this(bytes , 0 , bytes.length);
	}
	
	LedisHeapByteBuffer( byte[ ] buf , int off , int len ) {
		super( buf , off , len );
	}

	

}
