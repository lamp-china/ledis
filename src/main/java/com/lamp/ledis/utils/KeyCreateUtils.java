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

public class KeyCreateUtils extends ClassLoader implements Opcodes {

	private static String CLASS_NAME = "_KeyCreate" ;

	private static String TYPEREFERENCE_LIST = "_TypeReference_list" ;

	private static String TYPEREFERENCE_MAP = "_TypeReference_map" ;

	private static String TYPEREFERENCE_PACKAGE_PATH = "com/alibaba/fastjson/TypeReference" ;

	private final LongAdder longAdder = new LongAdder( ) ;

	public void keyCreate ( String className , String key , String stringKey ) throws Exception {
		String methodName = ClassUtils.getMethodName( key ) ;
		String[] amsName = ClassUtils.amsName( className , methodName ) ;
		Class clazz = Class.forName( className ) ;
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
		mw.visitMethodInsn( INVOKEVIRTUAL , "KyeCreate" , "getKeySuffix" , "(L" + className + ";)Ljava/lang/String;" ,
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

	public TypeReference map ( String keyType , String valueType ) throws InstantiationException, IllegalAccessException {
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
		
		return (TypeReference) exampleClass.newInstance( );
	}

	public TypeReference list ( String valueType ) throws InstantiationException, IllegalAccessException {
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
		
		return (TypeReference)exampleClass.newInstance( );
	}

	
	public void createKeyConfiguer(String clazzName , String keyName , String prefix) throws Exception{
		String keyMethodName = ClassUtils.getMethodName( keyName ) ;
		String[] amsName = ClassUtils.amsName( clazzName , keyMethodName ) ;
		Class clazz = Class.forName( clazzName ) ;
		Field field = clazz.getField( keyName ) ;
		String keyType = field.getType( ).getClass( ).getName( ) ;
		
		AmsTypeReference atr = new AmsTypeReference( );
		
		atr.setClazz( clazz );
		atr.setClazzName( clazzName );
		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( keyName , clazzName , longAdder.longValue( ) , CLASS_NAME ) ;
		atr.setClassAmsName( amsClassName );
		
		
		
		longAdder.increment( ) ;
		amsClassName = ClassUtils.className( clazzName , keyType , longAdder.longValue( ) , TYPEREFERENCE_MAP ) ;
		atr.setTrMapObejctName( amsClassName );
		String typeReferenceMapClassName = getTypeReferenceMapCalssName( clazzName , keyType );
		atr.setTrMap( createTypeReference( amsClassName , typeReferenceMapClassName ) );
		
		longAdder.increment( ) ;
		amsClassName = ClassUtils.className( "" , clazzName , longAdder.longValue( ) , TYPEREFERENCE_LIST ) ;
		atr.setTrListObejctName( amsClassName );
		
		String typeReferenceListClassName = getTypeReferenceListClassName( clazzName );
		atr.setTrList( createTypeReference( amsClassName , typeReferenceListClassName ) );

		
		KeyConfigure kc = new KeyConfigure( prefix , keyName , keyType , keyMethodName , atr );
	}
	
	
	private TypeReference<Object> createTypeReference(String amsClassName , String typeRefernece) throws InstantiationException, IllegalAccessException{
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
		
		return (TypeReference<Object>)exampleClass.newInstance( );

	}
 	
	
	private String getTypeReferenceMapCalssName( String clazzName , String keyType  ){
		longAdder.increment( ) ;
		String amsClassName = ClassUtils.className( clazzName , keyType , longAdder.longValue( ) , TYPEREFERENCE_MAP ) ;

		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/Map<L" ) ;
		sb.append( clazzName ) ;
		sb.append( ";L" ) ;
		sb.append( keyType ) ;
		sb.append( ";>;>;" ) ;
		return sb.toString( );
	}
	
	private String getTypeReferenceListClassName( String clazzName){
		StringBuffer sb = new StringBuffer( ) ;
		sb.append( "Lcom/alibaba/fastjson/TypeReference<Ljava/util/List<L" ) ;
		sb.append( clazzName ) ;
		sb.append( ";>;>;" ) ;
		return sb.toString( );
	}
}
