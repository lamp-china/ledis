package com.lamp.ledis.spring;

import org.springframework.beans.factory.FactoryBean ;

import com.lamp.ledis.annotation.OperationsEntity ;
import com.lamp.ledis.commands.CommandsObjectFactory ;
/**
 * 还是不延迟加载了，如果asm异常怎么办
 * 这种异常应该在 初始化的时候就应该检测出来
 * 是否设定一个值，来处理
 * @author laohu
 *
 * @param <T>
 */
public class MapperFactoryBean<T> implements FactoryBean<T>{

	private T comm;
	
	private OperationsEntity operationsEntity;
	
	public void init(){
		operationsEntity.getName( );
	}
	
	@Override
	public T getObject ( ) throws Exception {
		return CommandsObjectFactory.getInstance( ).getRedisCommands( operationsEntity ) ;
	}

	@Override
	public Class< ? > getObjectType ( ) {
		return null ;
	}

	@Override
	public boolean isSingleton ( ) {
		return true ;
	}

	public void setComm ( T comm ) {
		this.comm = comm ;
	}

	public void setOperationsEntity ( OperationsEntity operationsEntity ) {
		this.operationsEntity = operationsEntity ;
	}

	 
}
