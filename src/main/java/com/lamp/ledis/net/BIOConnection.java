package com.lamp.ledis.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.net.ssl.SSLSocket;

import com.lamp.ledis.utils.LedisInputStream;

public class BIOConnection extends AbstractConnection {
	private Socket socket;
	private OutputStream outputStream;
	private LedisInputStream inputStream;
	
	BIOConnection(NetConfigure configure) {
		super(configure);
		connect();
	}
	private void connect() {
		try {
			socket = new Socket();
			socket.setReuseAddress(true);
			socket.setKeepAlive(true);
			socket.setTcpNoDelay(true);
			socket.setSoLinger(true, 0);
			socket.connect(new InetSocketAddress(configure.getHost(), configure.getPost()), 2000 );
			socket.setSoTimeout( 2000 );

			if (configure.isSsl()) {
				socket = configure.getSllSocketFactory().createSocket(socket, configure.getHost(), configure.getPost(), true);
				if (null != configure.getSslParameters()) {
					((SSLSocket) socket).setSSLParameters( configure.getSslParameters() );
				}
				if ((null != configure.getHostnameVerifier()) && (!configure.getHostnameVerifier().verify(configure.getHost(), ((SSLSocket) socket).getSession()))) {
					String message = String.format("The connection to '%s' failed ssl/tls hostname verification.",
							configure.getHost());
					throw new RuntimeException(message);
				}
			}
			outputStream = socket.getOutputStream();
			outputStream = new StringOutputStream(outputStream);
			inputStream = new LedisInputStream(socket.getInputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
			
		}
	}

	@Override
	public LedisInputStream getInputStream() {
		return inputStream;
	}

	@Override
	public OutputStream getOutputStream() {
		return outputStream;
	}

	@Override
	public void close() throws IOException {
		this.socket.close();
	}
	
	private static class StringOutputStream  extends OutputStream{

		private OutputStream outputStream;
		
		private ByteArrayOutputStream bais = new ByteArrayOutputStream();
		
		StringOutputStream(OutputStream outputStream){
			this.outputStream = outputStream;
			
		}
		@Override
		public void write(int b) throws IOException {
			bais.write(b);
			outputStream.write(b);
		}
		
		
		public void flush() throws IOException{
			//System.out.println( bais.toString());
			outputStream.flush();
		}
	}
	
	
}
