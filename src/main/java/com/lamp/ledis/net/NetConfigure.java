package com.lamp.ledis.net;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;

/**
 * http://blog.chinaunix.net/uid/29075379/abstract/1.html
 * @author muqi
 *
 */
public class NetConfigure {

	private String host = "127.0.0.1";
	
	private int    post = 6379;
	
	/**
	 * 只要是解决在网络堵塞的时候，保证数据传输安装的协议，但是在现在的网络，基本没用了。
	 */
	private boolean KeepAlive = false;
	

	
	/**
	 * 直接禁用
	 * 在这之前，我们先说说nagle缓存算法，有些应用程序在网络通讯的时候会发送很少的字节，
	 * 比如说一个字节，那么再加TCP协议本身，实际上发的要41个字节，这样的效率是很低的。
	 * 这时候nagle算法就应运而生了，它将要发送的数据存放在缓存里，当积累到一定量或一定时间，再将它们发送出去。
	 * 这里TCP_NODELAY就是nagle启用与否的开关，所以下面的指令的效果就是禁用nagle算法，也即不缓存数据。
	 * redis 本身传递的数据就不多，就没有必要打开。
	 * redis对数据及时性要求高，直接关闭
	 */
	private boolean tcpNodelay = false;	
	
	/**
	 * 默认是禁止的
	 * 他需要与 sendUrgentData 方法一起使用。
	 * sendUrgentData 发送 的数据就立即发送，不会等待flush方法，
	 * 注意：1，需要两端都开启OOBInline，
	 * http://blog.csdn.net/huang_xw/article/details/7340637
	 */
	private boolean OOBInline  = false;
	
	private int performancePreferencesConnectionTime;
	
	private int performancePreferencesLatency;
	
	private int performancePreferencesBandwidth;
	
	/**
	 * 在 内核中，这个socket 的读缓冲区大小
	 */
	private int receiveBufferSize;
	
	/**
	 * http://www.cnblogs.com/qq78292959/archive/2013/01/18/2865926.html
	 * 一般来说，一个端口释放后会等待两分钟之后才能再被使用，SO_REUSEADDR是让端口释放后立即就可以被再次使用。
	 * SO_REUSEADDR用于对TCP套接字处于TIME_WAIT状态下的socket，才可以重复绑定使用。server程序总是应该在调用bind()之前设置SO_REUSEADDR套接字选项。
	 * TCP，先调用close()的一方会进入TIME_WAIT状态
	 */
	private boolean reuseaddr=true;
	/**
	 * 在 内核中，这个socket 的写缓冲区大小
	 */
	private int sendBufferSize;
	
	/**
	 * 调用close方法的时候，是否立即关闭连接。true是立即，false是持续一段时间。
	 * 为什么需要持续了，在关闭的时候，在socket内存中的读写缓冲区里面，还有数据存在
	 * http://www.cnblogs.com/javawebsoa/p/3201324.html
	 */
	private boolean soLinger;
	
	/**
	 * 持续时长，
	 */
	private int     soLingerTime;
	
	/**
	 * 读超时时间，毫秒
	 * 就是调用 read 方法，多久没有获得数据，就爆异常
	 * 0，就是永远不报错
	 */
	private int     soTimeout;
	
	/**
	 * 连接超时时间
	 */
	private int  connectionTimeout;
	
	
	private boolean ssl = false;

	private SSLSocketFactory sllSocketFactory;
	
	private SSLParameters sslParameters;
	
	private HostnameVerifier hostnameVerifier;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public boolean isKeepAlive() {
		return KeepAlive;
	}

	public void setKeepAlive(boolean keepAlive) {
		KeepAlive = keepAlive;
	}

	public boolean isTcpNodelay() {
		return tcpNodelay;
	}

	public void setTcpNodelay(boolean tcpNodelay) {
		this.tcpNodelay = tcpNodelay;
	}

	public boolean isOOBInline() {
		return OOBInline;
	}

	public void setOOBInline(boolean oOBInline) {
		OOBInline = oOBInline;
	}

	public int getPerformancePreferencesConnectionTime() {
		return performancePreferencesConnectionTime;
	}

	public void setPerformancePreferencesConnectionTime(int performancePreferencesConnectionTime) {
		this.performancePreferencesConnectionTime = performancePreferencesConnectionTime;
	}

	public int getPerformancePreferencesLatency() {
		return performancePreferencesLatency;
	}

	public void setPerformancePreferencesLatency(int performancePreferencesLatency) {
		this.performancePreferencesLatency = performancePreferencesLatency;
	}

	public int getPerformancePreferencesBandwidth() {
		return performancePreferencesBandwidth;
	}

	public void setPerformancePreferencesBandwidth(int performancePreferencesBandwidth) {
		this.performancePreferencesBandwidth = performancePreferencesBandwidth;
	}

	public int getReceiveBufferSize() {
		return receiveBufferSize;
	}

	public void setReceiveBufferSize(int receiveBufferSize) {
		this.receiveBufferSize = receiveBufferSize;
	}

	public boolean isReuseaddr() {
		return reuseaddr;
	}

	public void setReuseaddr(boolean reuseaddr) {
		this.reuseaddr = reuseaddr;
	}

	public int getSendBufferSize() {
		return sendBufferSize;
	}

	public void setSendBufferSize(int sendBufferSize) {
		this.sendBufferSize = sendBufferSize;
	}

	public boolean isSoLinger() {
		return soLinger;
	}

	public void setSoLinger(boolean soLinger) {
		this.soLinger = soLinger;
	}

	public int getSoLingerTime() {
		return soLingerTime;
	}

	public void setSoLingerTime(int soLingerTime) {
		this.soLingerTime = soLingerTime;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public SSLSocketFactory getSllSocketFactory() {
		return sllSocketFactory;
	}

	public void setSllSocketFactory(SSLSocketFactory sllSocketFactory) {
		this.sllSocketFactory = sllSocketFactory;
	}

	public SSLParameters getSslParameters() {
		return sslParameters;
	}

	public void setSslParameters(SSLParameters sslParameters) {
		this.sslParameters = sslParameters;
	}

	public HostnameVerifier getHostnameVerifier() {
		return hostnameVerifier;
	}

	public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
		this.hostnameVerifier = hostnameVerifier;
	}
	
	
}
