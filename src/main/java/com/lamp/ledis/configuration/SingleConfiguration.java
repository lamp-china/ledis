package com.lamp.ledis.configuration;

import com.lamp.ledis.exception.ConfigureException;
import com.lamp.ledis.utils.BasicAttributes;

/**
 * @author vp
 *
 */
public class SingleConfiguration {
	
	public static SingleConfigurationBuilder create(){
		return new SingleConfigurationBuilder();
	}
	
	
	private String name;
	
	private String host;
	
	private int    post = BasicAttributes.DEFAULT_POST;
	
	private int    select;
	
	private int    connectionMode;
	
	private int    netMode;
	
	private int    connectionNum;
	
	private int    keepAliveTime;

	public String getHost ( ) {
		return host ;
	}

	public void setHost ( String host ) {
		this.host = host ;
		
	}

	public int getPost ( ) {
		return post ;
	}

	public void setPost ( int post ) {
		this.post = post ;
		
	}

	public int getSelect ( ) {
		return select ;
	}

	public void setSelect ( int select ) {
		this.select = select ;		
	}

	public int getConnectionMode ( ) {
		return connectionMode ;
	}

	public void setConnectionMode ( int connectionMode ) {
		this.connectionMode = connectionMode ;		
	}

	public int getNetMode ( ) {
		return netMode ;
	}

	public void setNetMode ( int netMode ) {
		this.netMode = netMode ;		
	}

	public int getConnectionNum ( ) {
		return connectionNum ;
	}

	public void setConnectionNum ( int connectionNum ) {
		this.connectionNum = connectionNum ;		
	}

	public String getName ( ) {
		return name ;
	}

	public void setName ( String name ) {
		this.name = name ;		
	}

	public int getKeepAliveTime( ) {
		return keepAliveTime;
	}

	public void setKeepAliveTime( int keepAliveTime ) {
		this.keepAliveTime = keepAliveTime;		
	}
	
	
	
	
	
	@Override
	public String toString( ) {
		return "SingleConfiguration [name=" + name + ", host=" + host + ", post=" + post + ", select=" + select
				+ ", connectionMode=" + connectionMode + ", netMode=" + netMode + ", connectionNum=" + connectionNum
				+ ", keepAliveTime=" + keepAliveTime + "]";
	}





	public static class SingleConfigurationBuilder{
		private String name;
		
		private String host;
		
		private int    post;
		
		private int    select;
		
		private int    connectionMode;
		
		private int    netMode;
		
		private int    connectionNum;
		
		private int    keepAliveTime;

		public String getHost ( ) {
			return host ;
		}

		public SingleConfigurationBuilder setHost ( String host ) {
			this.host = host ;
			return this;
			
		}

		public int getPost ( ) {
			return post ;
		}

		public SingleConfigurationBuilder setPost ( int post ) {
			this.post = post ;
			return this;
		}

		public int getSelect ( ) {
			return select ;
		}

		public SingleConfigurationBuilder setSelect ( int select ) {
			this.select = select ;
			return this;
		}

		public int getConnectionMode ( ) {
			return connectionMode ;
		}

		public SingleConfigurationBuilder setConnectionMode ( int connectionMode ) {
			this.connectionMode = connectionMode ;
			return this;
		}

		public int getNetMode ( ) {
			return netMode ;
		}

		public SingleConfigurationBuilder setNetMode ( int netMode ) {
			this.netMode = netMode ;
			return this;
		}

		public int getConnectionNum ( ) {
			return connectionNum ;
		}

		public SingleConfigurationBuilder setConnectionNum ( int connectionNum ) {
			this.connectionNum = connectionNum ;
			return this;
		}

		public String getName ( ) {
			return name ;
		}

		public SingleConfigurationBuilder setName ( String name ) {
			this.name = name ;
			return this;
		}

		public int getKeepAliveTime( ) {
			return keepAliveTime;
		}

		public SingleConfigurationBuilder setKeepAliveTime( int keepAliveTime ) {
			this.keepAliveTime = keepAliveTime;
			return this;
		}
		
		public SingleConfiguration builder() throws ConfigureException{
			SingleConfiguration singleConfiguration = new SingleConfiguration();
			if( host == null){
				throw new ConfigureException(" host 不能为空" );
			}
			if( connectionMode == 0 && connectionNum == 0){
				throw new ConfigureException(" nolock 模式下， 连接数量不能为0" );
			}
			singleConfiguration.setHost( host );
			if( post != 0){
				singleConfiguration.setPost( post );
			}
			singleConfiguration.setName( name );
			singleConfiguration.setConnectionMode( connectionMode );
			singleConfiguration.setConnectionNum( connectionNum );
			singleConfiguration.setNetMode( netMode );
			singleConfiguration.setSelect( select );
			singleConfiguration.setKeepAliveTime( keepAliveTime == 0 ? 2000 : keepAliveTime );
			return singleConfiguration;
		}

		@Override
		public String toString( ) {
			return "SingleConfigurationBuilder [name=" + name + ", host=" + host + ", post=" + post + ", select="
					+ select + ", connectionMode=" + connectionMode + ", netMode=" + netMode + ", connectionNum="
					+ connectionNum + ", keepAliveTime=" + keepAliveTime + "]";
		}
		
		
		
		
	}
	
}
