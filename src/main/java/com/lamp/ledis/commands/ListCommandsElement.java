package com.lamp.ledis.commands;

import com.lamp.ledis.protocol.ResolveNetProtocol;
import com.lamp.ledis.protocol.ResultHandle;

/**
 * B 是阻塞
 * L 是头
 * R 是为
 * pop 是 获得
 * pash 是 添加
 * @author laohu
 *
 */
public final class ListCommandsElement {
	
	/**
	 *  Blpop 命令移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	public static final CombinationElement BLPOP_SINGLE     =  CombinationElement.newCombinationElement(  3 , "blpop"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	/**
	 *  Blpop 命令移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 *  
	 *  阻塞多个队列
	 */
	public static final CombinationElement BLPOP_MORE       =  CombinationElement.newCombinationElement(  3 , "blpop"          , false ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	/**
	 *  Brpop 命令移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	public static final CombinationElement BRPOP_SINGLE     =  CombinationElement.newCombinationElement(  3 , "brpop"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	/**
	 *  Brpop 命令移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 *  
	 *  阻塞多个队列
	 */
	public static final CombinationElement BRPOP_MORE       =  CombinationElement.newCombinationElement(  2 , "brpop"          , false ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	/**
	 * Brpoplpush
	 * 阻塞（b）获得（pop） 第一个队列的最后一个元素（r），加入(push)第二个队列头部（l）
	 */
	public static final CombinationElement BRPOPLPUSH       =  CombinationElement.newCombinationElement(  3 , "brpoplpush"     , false ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	

	/**
	 * Lindex
	 * 通过下标获得 数据，当时不会删除数据
	 * 返回 object
	 */
    public static final CombinationElement LINDEX           =  CombinationElement.newCombinationElement( 3  , "lindex"         , ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
    /**
     * 插入到指定元素前后
     * berore 前
     * after  后
     * 返回插入的 下标
     */
    public static final CombinationElement LINSERT          =  CombinationElement.newCombinationElement( 5  , "linser"         , ResolveNetProtocol.resolveIntNetProtocol    );
    
    /**
     * 获得list的长度
     */
    public static final CombinationElement LLEN             =  CombinationElement.newCombinationElement( 5  , "llen"           , ResolveNetProtocol.resolveIntNetProtocol    );
    
    
	/**
	 *  Lpop 命令移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 */
	public static final CombinationElement LPOP             =  CombinationElement.newCombinationElement(  3 , "lpop"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
    
	/**
	 * Lpush
	 * 从头部加入元素
	 */
	public static final CombinationElement LPUSH            =  CombinationElement.newCombinationElement(  3 , "lpush"         ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);

	/**
	 * Lpush
	 * 从头部加入元素
	 */
	public static final CombinationElement LPUSHX           =  CombinationElement.newCombinationElement(  3 , "lpushx"         ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);

    
    
    /**
	 *  Lrange 
	 *  返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。 
	 *  你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 */
	public static final CombinationElement LRANGE       =  CombinationElement.newCombinationElement(  4 , "lrange"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
    
	/**
	 * Redis Lrem 根据参数 COUNT 的值，移除列表中与参数 VALUE 相等的元素。
	 * COUNT 的值可以是以下几种
	 *     count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
	 *     count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
	 *     count = 0 : 移除表中所有与 VALUE 相等的值。
	 *     lrem key count value
	 *  返回删除 数量 long
	 */
	public static final CombinationElement LREM            =  CombinationElement.newCombinationElement(  4 , "lrem"         ,  ResolveNetProtocol.resolveIntNetProtocol  );

	/**
	 *  把元素插入到加入到指定下标
	 *  LSET KEY_NAME INDEX VALUE
	 *  返回状态
	 */
	public static final CombinationElement LSET            =  CombinationElement.newCombinationElement(  4 , "lset"         ,  ResolveNetProtocol.resolveStateNetProtocol  );
	
	
	/**
	 * Redis Ltrim 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
	 * 下标 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 */
	public static final CombinationElement LTRIM            =  CombinationElement.newCombinationElement(  4 , "ltrim"         ,  ResolveNetProtocol.resolveIntNetProtocol  );

    
    
    
	/**
	 *  Rpop 命令移出并获取列表的z最后一个元素
	 */
	public static final CombinationElement RPOP             =  CombinationElement.newCombinationElement(  3 , "rpop"          ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
	
	public static final CombinationElement RPOPLPUSH        =  CombinationElement.newCombinationElement(  3 , "rpopLpush"     ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);
	
    
	/**
	 * Rpush
	 * 从头部加入元素
	 */
	public static final CombinationElement RPUSH            =  CombinationElement.newCombinationElement(  3 , "rpush"         ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);

	/**
	 * Rpush
	 * 从头部加入元素
	 */
	public static final CombinationElement RPUSHX           =  CombinationElement.newCombinationElement(  3 , "rpushx"         ,  ResolveNetProtocol.resolveSingleNetProtocol, ResultHandle.objcetResultHandle);


}
