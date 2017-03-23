import java.nio.ByteBuffer;

public interface TestInterface<T> {
	public void getKeySuffixBuffer(T t ,ByteBuffer byteBuffer);
}
