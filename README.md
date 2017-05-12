# 欢迎大家，来到lamp小组的ledis项目

## lamp介绍

## ledis介绍
### ledis注重点是redis命令与对象之间的映射。
### 解决命令，结果与对象之间复杂操作目的。
### 使操作更加简单，代码更加优雅，结构更加清晰
### 与其他框架贴近
##  ledis所有操作都是线程安全的。 所以在这方面ledis更加健壮，更加方便
```
    Jedis jedis;
    try{
        jedis = new Jedis();
        jedis.get( 1 );
    }fallay{
        jedis.clone();
    }
```
### ledis
```
;
    OperationEntity operationEntity = new OperationEntity();
    operationEntity.setKey("id");
    operationEntity.setClass(User.class);
    StringCommands stringCommands = CommandsObjectFactory.getInstance.getRedisCommands(operationEntity);
    
    stringCommands.set( 1 );//线程安全
    
```
### 1. 解决命令参数传递复杂性，基于对象传递
### jedis，
```java
;
    User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    jedis.set( user.getId().toString() , JSON.toString( user ));
    
```
### spring-redis 更加复杂，这里不做演示
### ledis
```
    ;
    User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    stringCommands.set( user );
```

### 2. 返回结果自动映射
### jedis
```
;
    User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    String str = jedis.get( user.getId().toString());
    user = JSON.parseObject( str , User.class )    
    
```
### ledis
```
;
    User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    user = stringCommands.get(user);
```

### 3. 支持 List 批量操作, 
### jedis
```
    List<User> userList = new ArrayList<>();
    for(User user : userList){
         jedis.set( user.getId().toString() , JSON.toString( user ));
    }
```
### ledis
```
    List<User> userList = new ArrayList<>();
    stringCommands.set( userList );
```
### 4. 支持 key前缀与分隔符。同样的id，可能会保存不同的其他对象数据。然后你需要在命令操作的时候进行 key的组装。ledis只需要你配置就可以。修改key组合十分方便。
### jedis
```
     User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    jedis.set( "user"+"_"+user.getId().toString() , JSON.toString( user ));
```
### ledis
```
    OperationEntity operationEntity = new OperationEntity();
    operationEntity.setKey("id");
    operationEntity.setClass(User.class);
    operationEntity.setPrefix("user");
    operationEntity.setSeparator("_");
    StringCommands stringCommands = CommandsObjectFactory.getInstance.getRedisCommands(operationEntity);
    
    User user = new User();
    user.setId( 1 );
    user.setName("ledis");
    stringCommands.set( user );
```
### 5. 方便的script操作（设计完成，等待实现）
### 6. 完整 Object Relational Mapping（初步方案带完善）
### 7. 基于注解操作
```
    @Mapper
@OperationList( operationsObject = {
		@OperationsObject( name = "test" , operations = @Operation( key = "id" , mapKey = "appId" ) ) } )
public class TestEntity {
    
}
```
### 8. 努力与其他框架整合
#### spring （完成）
#### spring-boot （等待）
#### shiro（等待）
### 9. 多源操作
### 10. 高性能。除了序列化操作之外。ledis，使用缓存，重用对象（一个命令，几乎没有任何的对象创建）等等
### 11. 对response outputStream（待设计）

## ledis 的不足
### 1. 因为加入对象操作，又保持原声的string类型 key。为了方便与性能加入 long类型 key。
### a. Ledis 对 long类型进行优化操作，
### b. 致使一些命名就有 三个方法。方法过多。
```
;
    T get(T t);
    T get(String t);
    T get(long t);
```
### c. 致使接口过多
### d. 现在考虑是否 不支持long类型key
### c. long,int,Integer,long 之间兼容问题，真烦。
### d. 是否创建一个新的体系。方法的出现
### 2. 异常体系不够健全
### 3. 现在无日志体系。想借鉴durid的日志体系。实现一套。
### 4. 一些命令无法很好的支持。命令支持待完善中
### 5. 对获得操作的类型过于单一，目前打算使用 T<T>, 的方式进行处理。由Ledis自动识别返回数据类型
### 5. 只实现jdk8以上下单注解方式，以后会实现jdk8的注释方式


### 关于Ladis，
#### 使用 Apache Licence 2.0，出名之后，希望捐赠给apache。
#### 目前由老胡用业余时间开发与维护，可以保证库的质量与进度。
### Ladis 时刻表
#### 1.0以下的版本号，是无bug，非健全版本，有bug会立马修护。尽量在四个月左右Ladis健全，稳定，功能齐全。
#### 四个月以后，内部代码会进行一次重构，性能优化。尽量保证使用方式与接口向前兼容
#### 发布一年左右，进入稳定期。只进行日常维护。功能与版本号将会同redis功能与版本号看齐。
###  
