package com.lamp.ledis.commands;

import java.util.List ;
import java.util.Map ;

import com.lamp.ledis.annotation.OperationsEntity ;

public class RedisCommandsImlp< K , T > implements RedisCommands< K , T >{

	private StringCommands< T >   sc;
	
	private HashCommands< K , T > hc;
	
	private ListCommands< T >     lc;
	
	private OperationsEntity operationsEntity;
	
	public RedisCommandsImlp( OperationsEntity operationsEntity){
		this.operationsEntity = operationsEntity;
		
	}
	
	
	
	
	
	
	@Override
	public T blpop ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T blpop ( long t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T blpop ( String t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T blpop ( T t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T blpop ( long t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T blpop ( String t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( long t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( String t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( T t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( long t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpop ( String t , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( T source , T destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( long source , long destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( String source , String destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( T source , T destination , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( long source , long destination , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T brpoplpush ( String source , String destination , int timeout ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T lindex ( T t , int index ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T lindex ( long t , int index ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T lindex ( String t , int index ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long linsert ( String key , String pivot , String value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long llen ( T key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long llen ( String key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long llen ( long key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public T lpop ( T key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T lpop ( String key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T lpop ( long key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long lpush ( T value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long lpush ( List< T > value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long lpushx ( T value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public List< T > lrange ( T key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > lrange ( String key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > lrange ( long key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long lren ( String key , int num , String value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public boolean lset ( T value , int index ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean ltrim ( T key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean ltrim ( String key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean ltrim ( long key , int start , int stop ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public T rpop ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpop ( long t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpop ( String t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpoplpush ( T source , T destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpoplpush ( long source , long destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T rpoplpush ( String source , String destination ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long rpush ( T value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long rpush ( List< T > value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long rpushx ( T value ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public boolean del ( Long t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( Long t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( Long key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( Long key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( Long key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( Long key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean persist ( String key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( Long key , Long newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( Long key , Long newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean del ( String t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( String t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( String key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( String key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( String key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( String key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( String key , String newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( String key , String newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean del ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean exists ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expire ( T key , int seconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpire ( T key , int milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean expireat ( T key , long timestamp ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean pexpireat ( T key , long milliseconds ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean persist ( T key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean rename ( T key , T newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean renamenx ( T key , T newkey ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hdel ( T key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hdel ( String key , K field ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hdel ( Long key , K field ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hdel ( List< T > key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hexists ( T key ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hexists ( String key , String field ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hexists ( long key , long field ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public T hget ( T key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T hget ( String key , String field ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T hget ( long key , long field ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Map< K , T > hgetall ( T key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Map< K , T > hgetall ( String key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Map< K , T > hgetall ( long key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long hincrby ( T key , long increment ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long hincrby ( String key , String field , long increment ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long hincrby ( Long key , Long field , long increment ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public List< K > hkeys ( T key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< K > hkeys ( String key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< K > hkeys ( long key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > hvals ( T key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > hvals ( String key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > hvals ( long key ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public long hlen ( T key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long hlen ( String key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public long hlen ( long key ) {
		// TODO 自动生成的方法存根
		return 0 ;
	}

	@Override
	public List< T > hmget ( List< T > t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > hmget ( String key , List< T > t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > hmget ( Number key , List< T > t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public boolean hmset ( List< T > t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hmset ( String key , List< T > t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hmset ( Number key , List< T > t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hset ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hset ( String key , T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hset ( Number key , T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hsetnx ( T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hsetnx ( String key , T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public boolean hsetnx ( Number key , T t ) {
		// TODO 自动生成的方法存根
		return false ;
	}

	@Override
	public T get ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T get ( String t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T get ( long t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public T getSet ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > mGet ( List< T > keys ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > mGetString ( List< String > keys ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public List< T > mGetNumber ( List< ? extends Number > keys ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public void set ( T t ) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Boolean setNX ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Boolean setNX ( T t , Object o ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Boolean setEX ( T t , long seconds ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Boolean setEX ( T t , Object o , long seconds ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public void pSetEX ( byte[] key , long milliseconds , byte[] value ) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mSet ( List< T > tuple ) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Boolean mSetNX ( List< T > tuple ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Long incr ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Long incrBy ( T t , long value ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Double incrBy ( T t , double value ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Long decr ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Long decrBy ( T t , long value ) {
		// TODO 自动生成的方法存根
		return null ;
	}

	@Override
	public Long strLen ( T t ) {
		// TODO 自动生成的方法存根
		return null ;
	}

}
