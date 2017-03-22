package com.lamp.ledis.utils ;

import java.io.FileOutputStream ;
import java.lang.reflect.Field ;
import java.util.concurrent.atomic.LongAdder ;

import org.objectweb.asm.ClassWriter ;
import org.objectweb.asm.MethodVisitor ;
import org.objectweb.asm.Opcodes ;

import com.alibaba.fastjson.TypeReference ;
import com.lamp.ledis.create.AmsTypeReference ;
import com.lamp.ledis.create.KeyConfigure ;
import com.lamp.ledis.create.KeyCreate ;
import com.lamp.ledis.create.KeyCreateAndAmsTypeReferenceFactory ;

public class KeyCreateUtils extends ClassLoader implements Opcodes {

	private static final KeyCreateUtils  keyCreateUtils = new KeyCreateUtils();
	
	private KeyCreateUtils(){}
	
	public static final KeyCreateUtils getInstance(){
		return keyCreateUtils;
	}
	
	
	private static String CLASS_NAME = "_KeyCreate" ;

	private static String TYPEREFERENCE_LIST = "_TypeReference_list" ;

	private static String TYPEREFERENCE_MAP = "_TypeReference_map" ;

	private static String TYPEREFERENCE_PACKAGE_PATH = "com/alibaba/fastjson/TypeReference" ;

	private final LongAdder longAdder = new LongAdder( ) ;

	private final static KeyCreateAndAmsTypeReferenceFactory kaaf = KeyCreateAndAmsTypeReferenceFactory.getInstance( ) ;

	public void keyCreate ( String className , String key , String stringKey ) throws Exception {
		String methodName = ClassUtils.getMethodName( key ) ;
		String[] amsName = ClassUtils.amsName( className , methodName ) ;
		Class< ? > clazz = Class.forName( className ) ;
		Field field = clazz.getField( key ) ;
		field.getType( ).getClass( ).getName( ) ;

		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( key , className , longAdder.longValue( ) , CLASS_NAME ) ;

		ClassWriter cw = new ClassWriter( 0 ) ;
		cw.visit( V1_8 , ACC_PUBLIC , amsClassName , "L" + className , "com/lamp/ledis/create/AbstractKeyCreate" ,
				null ) ;
		MethodVisitor mw = cw.visitMethod( ACC_PUBLIC , "<init>" , "(Ljava/lang/String;)V" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitMethodInsn( INVOKESPECIAL , "com/lamp/ledis/create/AbstractKeyCreate" , "<init>" ,
				"(Ljava/lang/String;)V" , false ) ;

		mw.visitInsn( RETURN ) ;
		mw.visitMaxs( 2 , 2 ) ;
		mw.visitEnd( ) ;

		mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffix" , "(L" + className + ";)Ljava/lang/String;" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/entity/TestEntity" , methodName , amsName[0] , false ) ;
		// mw.visitMethodInsn(INVOKEVIRTUAL,
		// "com/lamp/ledis/create/AbstractKeyCreate", "getKey",
		// "(J)Ljava/lang/String;", false);
		mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/AbstractKeyCreate" , "getKey" , amsName[1] ,
				false ) ;
		mw.visitInsn( ARETURN ) ;
		mw.visitMaxs( 3 , 4 ) ;
		mw.visitEnd( ) ;

		mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffix" , "(Ljava/lang/Object;)Ljava/lang/String;" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitTypeInsn( CHECKCAST , className ) ;
		mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/KeyCreate" , "getKeySuffix" , "(L" + className + ";)Ljava/lang/String;" ,
				false ) ;
		mw.visitInsn( ARETURN ) ;
		mw.visitMaxs( 2 , 2 ) ;
		mw.visitEnd( ) ;
		byte[] code = cw.toByteArray( ) ;

		FileOutputStream fos = new FileOutputStream( "FieldExample.class" ) ;
		fos.write( code ) ;
		fos.close( ) ;

		Class< ? > exampleClass = this.defineClass( amsClassName , code , 0 , code.length ) ;
		exampleClass.getConstructor( String.class ).newInstance( stringKey ) ;
		// exampleClass.newInstance();

	}

	public void keyCreate ( String kcKey ,String className , String key , String methodName , String[] amsName , KeyConfigure<?> keyConfigure) throws Exception {

		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( key , className.replace( '.' , '_' ) , longAdder.longValue( ) , CLASS_NAME ) ;

		ClassWriter cw = new ClassWriter( 0 ) ;
		cw.visit( V1_8 , ACC_PUBLIC , amsClassName , "L" + className.replace( '.' , '/' ) , "com/lamp/ledis/create/AbstractKeyCreate" ,
				null ) ;
		MethodVisitor mw = cw.visitMethod( ACC_PUBLIC , "<init>" , "(Lcom/lamp/ledis/create/KeyConfigure;)V" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitMethodInsn( INVOKESPECIAL , "com/lamp/ledis/create/AbstractKeyCreate" , "<init>" ,
				"(Lcom/lamp/ledis/create/KeyConfigure;)V" , false ) ;

		mw.visitInsn( RETURN ) ;
		mw.visitMaxs( 2 , 2 ) ;
		mw.visitEnd( ) ;

		mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffix" , "(L" + className.replace( '.' , '/' ) + ";)Ljava/lang/String;" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitMethodInsn( INVOKEVIRTUAL , className.replace( '.' , '/' ) , methodName , amsName[0] , false ) ;
		// mw.visitMethodInsn(INVOKEVIRTUAL,
		// "com/lamp/ledis/create/AbstractKeyCreate", "getKey",
		// "(J)Ljava/lang/String;", false);
		mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/AbstractKeyCreate" , "getKey" , amsName[1] ,
				false ) ;
		mw.visitInsn( ARETURN ) ;
		mw.visitMaxs( 3 , 4 ) ;
		mw.visitEnd( ) ;

		mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffix" , "(Ljava/lang/Object;)Ljava/lang/String;" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitVarInsn( ALOAD , 1 ) ;
		mw.visitTypeInsn( CHECKCAST , className.replace( '.' , '/' ) ) ;
		mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/KeyCreate" , "getKeySuffix" , "(L" + className.replace( '.' , '/' ) + ";)Ljava/lang/String;" ,
				false ) ;
		mw.visitInsn( ARETURN ) ;
		mw.visitMaxs( 2 , 2 ) ;
		
		{
			mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffixBuffer" , "(L" + className.replace( '.' , '/' ) + ";)Ljava/nio/ByteBuffer;" , null , null ) ;
			mw.visitVarInsn( ALOAD , 0 ) ;
			mw.visitVarInsn( ALOAD , 1 ) ;
			mw.visitMethodInsn( INVOKEVIRTUAL , className.replace( '.' , '/' ) , methodName , amsName[0] , false ) ;
			// mw.visitMethodInsn(INVOKEVIRTUAL,
			// "com/lamp/ledis/create/AbstractKeyCreate", "getKey",
			// "(J)Ljava/lang/String;", false);
			mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/AbstractKeyCreate" , "getKey" , amsName[1] ,
					false ) ;
			mw.visitInsn( ARETURN ) ;
			mw.visitMaxs( 3 , 4 ) ;
			mw.visitEnd( ) ;

			mw = cw.visitMethod( ACC_PUBLIC , "getKeySuffixBuffer" , "(Ljava/lang/Object;)Ljava/nio/ByteBuffer;" , null , null ) ;
			mw.visitVarInsn( ALOAD , 0 ) ;
			mw.visitVarInsn( ALOAD , 1 ) ;
			mw.visitTypeInsn( CHECKCAST , className.replace( '.' , '/' ) ) ;
			mw.visitMethodInsn( INVOKEVIRTUAL , "com/lamp/ledis/create/KeyCreate" , "getKeySuffixBuffer" , "(L" + className.replace( '.' , '/' ) + ";)Ljava/nio/ByteBuffer;" ,
					false ) ;
			mw.visitInsn( ARETURN ) ;
			mw.visitMaxs( 2 , 2 ) ;
		}
		mw.visitEnd( ) ;
		byte[] code = cw.toByteArray( ) ;

		Class< ? > exampleClass = this.defineClass( amsClassName , code , 0 , code.length ) ;
		Object o = exampleClass.getConstructor( KeyConfigure.class ).newInstance( keyConfigure ) ;
		kaaf.putKeyConfigure( kcKey , ( KeyCreate< ? > ) o ) ;
		// exampleClass.newInstance();

	}

	public TypeReference< ? > map ( String keyType , String valueType )
			throws InstantiationException , IllegalAccessException {
		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( keyType , valueType , longAdder.longValue( ) , TYPEREFERENCE_MAP ) ;

		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/Map<L" ) ;
		sb.append( keyType ) ;
		sb.append( ";L" ) ;
		sb.append( valueType ) ;
		sb.append( ";>;>;" ) ;

		ClassWriter cw = new ClassWriter( 0 ) ;
		cw.visit( V1_8 , ACC_PUBLIC , amsClassName , sb.toString( ) , TYPEREFERENCE_PACKAGE_PATH , null ) ;
		MethodVisitor mw = cw.visitMethod( ACC_PUBLIC , "<init>" , "()V" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;
		mw.visitMethodInsn( INVOKESPECIAL , "com/alibaba/fastjson/TypeReference" , "<init>" , "()V" , false ) ;
		mw.visitInsn( RETURN ) ;
		mw.visitMaxs( 1 , 1 ) ;
		mw.visitEnd( ) ;

		byte[] code = cw.toByteArray( ) ;

		Class< ? > exampleClass = this.defineClass( amsClassName , code , 0 , code.length ) ;

		return ( TypeReference< ? > ) exampleClass.newInstance( ) ;
	}

	public TypeReference< ? > list ( String valueType ) throws InstantiationException , IllegalAccessException {
		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( "" , valueType , longAdder.longValue( ) , TYPEREFERENCE_MAP ) ;

		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/List<L" ) ;
		sb.append( valueType ) ;
		sb.append( ";>;>;" ) ;

		ClassWriter cw = new ClassWriter( 0 ) ;
		cw.visit( V1_8 , ACC_PUBLIC , amsClassName , sb.toString( ) , TYPEREFERENCE_PACKAGE_PATH , null ) ;
		MethodVisitor mw = cw.visitMethod( ACC_PUBLIC , "<init>" , "()V" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;

		mw.visitMethodInsn( INVOKESPECIAL , "com/alibaba/fastjson/TypeReference" , "<init>" , "()V" , false ) ;

		mw.visitInsn( RETURN ) ;
		mw.visitMaxs( 1 , 1 ) ;
		mw.visitEnd( ) ;

		byte[] code = cw.toByteArray( ) ;

		Class< ? > exampleClass = this.defineClass( amsClassName , code , 0 , code.length ) ;

		return ( TypeReference< ? > ) exampleClass.newInstance( ) ;
	}

	public KeyCreate createKeyCreate ( String clazzName , String keyName , String prefix ,String hashKeyName , String hashKeyPrefix) throws Exception {
		// clazzName + key 成为唯一值，去缓存里面取
		// 如果不存在就创建KeyConfigure对象
		// 去缓存去AmsTypeReference对象，key是 className
		// 判断是否有AmsTypeReference对象，如果没有就创建
		//

		String kcKey = clazzName + "_" + keyName ;
		// TODO 线程安全的问题
		if ( ! kaaf.isKeyConfigure( kcKey ) ) {
			String keyMethodName = ClassUtils.getMethodName( keyName ) ;
			String[] amsName = ClassUtils.amsName( clazzName , keyMethodName ) ;
			Class< ? > clazz = Class.forName( clazzName ) ;
			Field field = clazz.getDeclaredField( keyName ) ;
			String keyType = field.getType( ).getName( ) ;

			if ( ! kaaf.isAmsTypeReference( clazzName ) ) {

				AmsTypeReference atr = new AmsTypeReference( ) ;
				atr.setClazz( clazz ) ;
				atr.setClazzName( clazzName ) ;
				longAdder.increment( ) ;
				String amsClassName = ClassUtils.className( keyName , clazzName , longAdder.longValue( ) ,CLASS_NAME ) ;
				atr.setClassAmsName( amsClassName ) ;

				longAdder.increment( ) ;
				amsClassName = ClassUtils.className( clazzName , keyType , longAdder.longValue( ) ,
						TYPEREFERENCE_MAP ) ;
				atr.setTrMapObejctName( amsClassName ) ;
				String typeReferenceMapClassName = getTypeReferenceMapCalssName( clazzName.replace( '.' , '/' ) , ClassUtils.typeStrToAmsTypeStr( keyType ) ) ;
				atr.setTrMap( createTypeReference( amsClassName.replace( '.' , '_' ) , typeReferenceMapClassName ) ) ;

				longAdder.increment( ) ;
				amsClassName = ClassUtils.className( "" , clazzName , longAdder.longValue( ) , TYPEREFERENCE_LIST ) ;
				atr.setTrListObejctName( amsClassName ) ;

				String typeReferenceListClassName = getTypeReferenceListClassName( clazzName.replace( '.' , '/' ) ) ;
				atr.setTrList( createTypeReference( amsClassName.replace( '.' , '_' ) , typeReferenceListClassName ) ) ;

				kaaf.putAmsTypeReference( clazzName , atr ) ;
			}
			KeyConfigure keyConfigure = new KeyConfigure( prefix , keyName , keyType , keyMethodName ,kaaf.getAmsTypeReference( clazzName ) ) ;
			keyCreate( kcKey ,clazzName , keyName , keyMethodName , amsName , keyConfigure  ) ;

		}
		return kaaf.getKeyCreate( kcKey ) ;
	}

	private TypeReference< ? > createTypeReference ( String amsClassName , String typeRefernece )
			throws InstantiationException , IllegalAccessException {
		ClassWriter cw = new ClassWriter( 0 ) ;
		cw.visit( V1_8 , ACC_PUBLIC , amsClassName , typeRefernece , TYPEREFERENCE_PACKAGE_PATH , null ) ;
		MethodVisitor mw = cw.visitMethod( ACC_PUBLIC , "<init>" , "()V" , null , null ) ;
		mw.visitVarInsn( ALOAD , 0 ) ;

		mw.visitMethodInsn( INVOKESPECIAL , "com/alibaba/fastjson/TypeReference" , "<init>" , "()V" , false ) ;

		mw.visitInsn( RETURN ) ;
		mw.visitMaxs( 1 , 1 ) ;
		mw.visitEnd( ) ;

		byte[] code = cw.toByteArray( ) ;

		Class< ? > exampleClass = this.defineClass( amsClassName , code , 0 , code.length ) ;

		return ( TypeReference< ? > ) exampleClass.newInstance( ) ;

	}

	private String getTypeReferenceMapCalssName ( String clazzName , String keyType ) {
		longAdder.increment( ) ;
		//String amsClassName = ClassUtils.className( clazzName , keyType , longAdder.longValue( ) , TYPEREFERENCE_MAP ) ;

		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/Map<L" ) ;
		sb.append( clazzName ) ;
		sb.append( ";L" ) ;
		sb.append( keyType ) ;
		sb.append( ";>;>;" ) ;
		return sb.toString( ) ;
	}

	private String getTypeReferenceListClassName ( String clazzName ) {
		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/List<L" ) ;
		sb.append( clazzName ) ;
		sb.append( ";>;>;" ) ;
		return sb.toString( ) ;
	}
}
