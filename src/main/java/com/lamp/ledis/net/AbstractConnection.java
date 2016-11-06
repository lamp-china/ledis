/*package com.lamp.ledis.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.RedisInputStream;
import redis.clients.util.RedisOutputStream;

public abstract class AbstractConnection implements Connection{

	  private static final byte[][] EMPTY_ARGS = new byte[0][];

	  private String host = Protocol.DEFAULT_HOST;
	  private int port = Protocol.DEFAULT_PORT;
	  private Socket socket;
	  private RedisOutputStream outputStream;
	  private RedisInputStream inputStream;
	  private int pipelinedCommands = 0;
	  private int connectionTimeout = Protocol.DEFAULT_TIMEOUT;
	  private int soTimeout = Protocol.DEFAULT_TIMEOUT;
	  private boolean broken = false;
	  private boolean ssl;
	  private SSLSocketFactory sslSocketFactory;
	  private SSLParameters sslParameters;
	  private HostnameVerifier hostnameVerifier;

	
	
	public void connect() {
	    if (!isConnected()) {
	      try {
	        socket = new Socket();
	        // ->@wjw_add
	        socket.setReuseAddress(true);
	        socket.setKeepAlive(true); // Will monitor the TCP connection is
	        // valid
	        socket.setTcpNoDelay(true); // Socket buffer Whetherclosed, to
	        // ensure timely delivery of data
	        socket.setSoLinger(true, 0); // Control calls close () method,
	        // the underlying socket is closed
	        // immediately
	        // <-@wjw_add

	        socket.connect(new InetSocketAddress(host, port), connectionTimeout);
	        socket.setSoTimeout(soTimeout);

	        if (ssl) {
	          if (null == sslSocketFactory) {
	            sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
	          }
	          socket = (SSLSocket) sslSocketFactory.createSocket(socket, host, port, true);
	          if (null != sslParameters) {
	            ((SSLSocket) socket).setSSLParameters(sslParameters);
	          }
	          if ((null != hostnameVerifier) &&
	              (!hostnameVerifier.verify(host, ((SSLSocket) socket).getSession()))) {
	            String message = String.format(
	                "The connection to '%s' failed ssl/tls hostname verification.", host);
	            throw new JedisConnectionException(message);
	          }
	        }

	        outputStream = new RedisOutputStream(socket.getOutputStream());
	        inputStream = new RedisInputStream(socket.getInputStream());
	      } catch (IOException ex) {
	        broken = true;
	        throw new JedisConnectionException(ex);
	      }
	    }
	  }
}
*/